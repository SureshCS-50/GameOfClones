package com.sureshCS50.gameofclones.ui.history;


import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.sureshCS50.gameofclones.R;
import com.sureshCS50.gameofclones.data.db.DatabaseManager;
import com.sureshCS50.gameofclones.data.db.entity.Battle;
import com.sureshCS50.gameofclones.databinding.FragmentHistoryBinding;
import com.sureshCS50.gameofclones.ui.BaseFragment;
import com.sureshCS50.gameofclones.utils.Constants;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryFragment extends BaseFragment {

    public static final String TAG = "HistoryFragment";

    private HistoryFragmentViewModel mViewModel;
    String[] winners = { "All", Constants.bd, Constants.ct};

    public HistoryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentHistoryBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_history, container, false);
        mViewModel = new HistoryFragmentViewModel(mSharedViewModel);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView mRecyclerView = view.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mRecyclerView.getContext()));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(mRecyclerView.getContext(), DividerItemDecoration.VERTICAL));
        mRecyclerView.setAdapter(mViewModel.getAdapter());

        mViewModel.getBattles().observe(this, new Observer<ArrayList<Battle>>() {
            @Override
            public void onChanged(ArrayList<Battle> battles) {
                mViewModel.notifyAdapter(battles);
            }
        });

        Button closeButton = view.findViewById(R.id.btnClose);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel.onCloseButtonClick();
            }
        });

        Spinner spinner = view.findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
                String selected = winners[position];
                ArrayList<Battle> battles;
                switch(selected){
                    case Constants.bd:
                        battles = new ArrayList<>(DatabaseManager.getInstance().getRecordsByWinner(Constants.bd));
                        break;
                    case Constants.ct:
                        battles = new ArrayList<>(DatabaseManager.getInstance().getRecordsByWinner(Constants.ct));
                        break;
                    default:
                        battles = new ArrayList<>(DatabaseManager.getInstance().listAllBattles());
                        break;
                }

                mViewModel.setBattles(battles);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                mViewModel.setBattles(new ArrayList<>(DatabaseManager.getInstance().listAllBattles()));
            }
        });

        ArrayAdapter aa = new ArrayAdapter(getActivity(), R.layout.item_spinner, winners);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(aa);
    }
}