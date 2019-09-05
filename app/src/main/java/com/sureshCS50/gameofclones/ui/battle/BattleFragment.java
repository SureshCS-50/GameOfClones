package com.sureshCS50.gameofclones.ui.battle;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
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
import com.sureshCS50.gameofclones.ui.battle.createTroopsDialog.CreateCTTroopDialog;
import com.sureshCS50.gameofclones.ui.battle.createTroopsDialog.CreateTroopFragmentCommunicator;

/**
 * A simple {@link Fragment} subclass.
 */
public class BattleFragment extends Fragment implements CreateTroopFragmentCommunicator {

    MainViewModel mSharedViewModel;
    BattleFragmentViewModel mViewModel;
    FragmentBattleBinding binding;
    CreateCTTroopDialog createCTTroopDialog;

    public BattleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_battle, container, false);
        mViewModel = new BattleFragmentViewModel(mSharedViewModel);
        binding.setViewModel(mViewModel);
        binding.setTroop(new Troop());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel.createBattleDroidArmy();
        observeBdArmy();
        observeShowCreateCTArmyPopup();
        observeCtArmy();
    }

    private void observeCtArmy() {
        mViewModel.ctTroopData.observe(this, new Observer<TroopData>() {
            @Override
            public void onChanged(TroopData troopData) {
                binding.setCtTroopData(troopData);
            }
        });
    }

    private void observeShowCreateCTArmyPopup() {
        mViewModel.showCreateCTArmyPopup.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean show) {
                if(show){
                    showPopup();
                }
            }
        });
    }

    private void showPopup() {
        FragmentManager fragmentManager = getFragmentManager();
        createCTTroopDialog = new CreateCTTroopDialog();
        createCTTroopDialog.setTargetFragment(this, 1001);
        createCTTroopDialog.show(fragmentManager, CreateCTTroopDialog.TAG);
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

    @Override
    public void onCancelDialog() {
        if(createCTTroopDialog != null && createCTTroopDialog.isVisible()){
            createCTTroopDialog.dismiss();
        }
    }

    @Override
    public void onCreateTroops(TroopData troopData) {
        mViewModel.setCtTroopData(troopData);
        onCancelDialog();
    }

}
