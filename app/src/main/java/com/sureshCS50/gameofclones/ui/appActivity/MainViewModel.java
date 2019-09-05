package com.sureshCS50.gameofclones.ui.appActivity;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.sureshCS50.gameofclones.data.db.entity.Troop;

import java.util.ArrayList;

public class MainViewModel extends ViewModel {

    private MainModel mModel;

    public MainViewModel(){
        mModel = new MainModel();
    }


    public void setNavigation(int page) {
        mModel.navigation.setValue(page);
    }

    MutableLiveData<Integer> getNavigation() {
        return mModel.navigation;
    }

    public MutableLiveData<ArrayList<Troop>> getTroops() {
        return mModel.troops;
    }

    public void setTroops(ArrayList<Troop> troops) {
        mModel.troops.setValue(troops);
    }
}
