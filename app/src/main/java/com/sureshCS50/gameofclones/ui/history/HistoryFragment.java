package com.sureshCS50.gameofclones.ui.history;


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

import com.sureshCS50.gameofclones.R;
import com.sureshCS50.gameofclones.data.db.entity.Battle;
import com.sureshCS50.gameofclones.databinding.FragmentHistoryBinding;
import com.sureshCS50.gameofclones.ui.BaseFragment;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryFragment extends BaseFragment {

    private HistoryFragmentViewModel mViewModel;
    private RecyclerView mRecyclerView;

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
        mRecyclerView = view.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mRecyclerView.getContext()));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(mRecyclerView.getContext(), DividerItemDecoration.VERTICAL));
        mRecyclerView.setAdapter(mViewModel.getAdapter());

        mViewModel.getBattles().observe(this, new Observer<ArrayList<Battle>>() {
            @Override
            public void onChanged(ArrayList<Battle> battles) {
                mViewModel.notifyAdapter(battles);
            }
        });
    }
}