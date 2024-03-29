package com.sureshCS50.gameofclones.ui.home;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.sureshCS50.gameofclones.data.db.entity.Troop;
import com.sureshCS50.gameofclones.ui.appActivity.MainViewModel;
import com.sureshCS50.gameofclones.utils.NavigationHandler;

import java.util.List;

public class HomeFragmentViewModel extends ViewModel {

    private MutableLiveData<Troop> mSelectedTroop;
    private TroopsAdapter mAdapter;
    private MainViewModel mSharedViewModel;

    HomeFragmentViewModel(MainViewModel mainViewModel) {
        mSharedViewModel = mainViewModel;
        mSelectedTroop = new MutableLiveData<>();
        mAdapter = new TroopsAdapter(this);
    }

    MutableLiveData<Troop> getSelectedTroop() {
        return mSelectedTroop;
    }

    public void setSelectedTroop(Troop troop) {
        mSelectedTroop.setValue(troop);
    }

    public TroopsAdapter getAdapter() {
        return mAdapter;
    }

    Troop getTroopAt(Integer index) {
        return mSharedViewModel.getTroops().getValue().get(index);
    }

    void notifyAdapterDateSetChanged(List<Troop> troops) {
        mAdapter.submitList(troops);
    }

    public void onCreateBattleClick(){
        mSharedViewModel.setNavigation(NavigationHandler.NEW_BATTLE);
    }

    public void onShowHistoryClick(){
        mSharedViewModel.setNavigation(NavigationHandler.BATTLE_HISTORY);
    }
}