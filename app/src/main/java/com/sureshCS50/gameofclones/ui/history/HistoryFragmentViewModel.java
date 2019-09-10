package com.sureshCS50.gameofclones.ui.history;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.sureshCS50.gameofclones.data.db.DatabaseManager;
import com.sureshCS50.gameofclones.data.db.entity.Battle;
import com.sureshCS50.gameofclones.ui.appActivity.MainViewModel;
import com.sureshCS50.gameofclones.utils.NavigationHandler;

import java.util.ArrayList;

public class HistoryFragmentViewModel extends ViewModel {

    private MainViewModel mSharedViewModel;
    public MutableLiveData<ArrayList<Battle>> battles;
    public HistoryAdapter mAdapter;

    HistoryFragmentViewModel(MainViewModel sharedViewModel){
        this.mSharedViewModel = sharedViewModel;
        this.battles = new MutableLiveData<>();
        mAdapter = new HistoryAdapter(this);
    }

    public MutableLiveData<ArrayList<Battle>> getBattles(){
        battles.setValue(new ArrayList<>(DatabaseManager.getInstance().listAllBattles()));
        return battles;
    }

    public void notifyAdapter(ArrayList<Battle> battles) {
        mAdapter.submitList(battles);
    }

    public Battle getBattleAt(int position) {
        return battles.getValue().get(position);
    }

    public void onCloseButtonClick(){
        mSharedViewModel.setNavigation(NavigationHandler.HOME);
    }

    public void onItemClick(Battle battle){
        mSharedViewModel.setBattle(battle);
    }

    public HistoryAdapter getAdapter(){
        return mAdapter;
    }

}