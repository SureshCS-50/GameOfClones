package com.sureshCS50.gameofclones.ui.battle_result;


import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sureshCS50.gameofclones.R;
import com.sureshCS50.gameofclones.data.db.DatabaseManager;
import com.sureshCS50.gameofclones.data.db.entity.Battle;
import com.sureshCS50.gameofclones.databinding.FragmentBattleResultBinding;
import com.sureshCS50.gameofclones.ui.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class BattleResultFragment extends BaseFragment {

    public static final String TAG = "BattleResultFragment";

    public BattleResultFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentBattleResultBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_battle_result, container, false);
        Battle battle = DatabaseManager.getInstance().getLastRecord();
        BattleResultViewModel viewModel = new BattleResultViewModel(mSharedViewModel, battle);
        binding.setViewModel(viewModel);
        return binding.getRoot();
    }

}