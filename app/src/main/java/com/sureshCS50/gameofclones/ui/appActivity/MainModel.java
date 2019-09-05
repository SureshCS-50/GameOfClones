package com.sureshCS50.gameofclones.ui.appActivity;

import androidx.databinding.BaseObservable;
import androidx.lifecycle.MutableLiveData;

import com.sureshCS50.gameofclones.data.db.entity.Troop;

import java.util.ArrayList;

public class MainModel extends BaseObservable {

    public MutableLiveData<Integer> navigation = new MutableLiveData<>();
    public MutableLiveData<ArrayList<Troop>> troops = new MutableLiveData<>();

}
