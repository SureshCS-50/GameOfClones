package com.sureshCS50.gameofclones.ui.appActivity;

import androidx.databinding.BaseObservable;
import androidx.lifecycle.MutableLiveData;

import com.sureshCS50.gameofclones.data.db.entity.Battle;
import com.sureshCS50.gameofclones.data.db.entity.Troop;

import java.util.ArrayList;

public class MainModel extends BaseObservable {

    MutableLiveData<Integer> navigation = new MutableLiveData<>();
    MutableLiveData<ArrayList<Troop>> troops = new MutableLiveData<>();
    MutableLiveData<Battle> selectedBattle = new MutableLiveData<>();

}
