package com.sureshCS50.gameofclones.ui.battle;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sureshCS50.gameofclones.R;
import com.sureshCS50.gameofclones.data.db.entity.Troop;
import com.sureshCS50.gameofclones.databinding.FragmentBattleBinding;
import com.sureshCS50.gameofclones.models.TroopData;
import com.sureshCS50.gameofclones.ui.appActivity.MainActivity;
import com.sureshCS50.gameofclones.ui.appActivity.MainViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class BattleFragment extends Fragment {

    MainViewModel mSharedViewModel;
    BattleFragmentViewModel mViewModel;
    FragmentBattleBinding binding;

    public BattleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_battle, container, false);
        mViewModel = new BattleFragmentViewModel(mSharedViewModel);
        binding.setTroop(new Troop());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel.createBattleDroidArmy();
        observeBdArmy();
    }

    private void observeBdArmy() {
        mViewModel.bdTroopData.observe(this, new Observer<TroopData>() {
            @Override
            public void onChanged(TroopData troopData) {
                binding.setBdTroopData(troopData);
            }
        });
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (getActivity() != null) {
            mSharedViewModel = ((MainActivity) getActivity()).getSharedViewModel();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mSharedViewModel = null;
    }

}
