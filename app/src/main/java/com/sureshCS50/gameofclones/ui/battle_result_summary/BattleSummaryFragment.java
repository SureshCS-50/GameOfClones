package com.sureshCS50.gameofclones.ui.battle_result_summary;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.sureshCS50.gameofclones.R;
import com.sureshCS50.gameofclones.data.db.DatabaseManager;
import com.sureshCS50.gameofclones.data.db.entity.Battle;
import com.sureshCS50.gameofclones.databinding.FragmentBattleResultBinding;
import com.sureshCS50.gameofclones.databinding.FragmentBattleSummaryBinding;
import com.sureshCS50.gameofclones.ui.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class BattleSummaryFragment extends BaseFragment {

    public static final String TAG = "BattleSummaryFragment";

    public static BattleSummaryFragment newInstance(Battle battle){
        BattleSummaryFragment fragment = new BattleSummaryFragment();
        Bundle extras = new Bundle();
        extras.putSerializable("battle", battle);
        fragment.setArguments(extras);
        return fragment;
    }

    public BattleSummaryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Bundle extras = getArguments();
        Battle battle = (Battle) extras.getSerializable("battle");

        FragmentBattleSummaryBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_battle_summary, container, false);
        BattleSummaryViewModel viewModel = new BattleSummaryViewModel(mSharedViewModel, battle);
        binding.setViewModel(viewModel);
        return binding.getRoot();
    }

}