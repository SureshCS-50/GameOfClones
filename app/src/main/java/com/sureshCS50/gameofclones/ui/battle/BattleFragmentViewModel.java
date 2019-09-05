package com.sureshCS50.gameofclones.ui.battle;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.sureshCS50.gameofclones.data.db.DatabaseManager;
import com.sureshCS50.gameofclones.data.db.entity.Troop;
import com.sureshCS50.gameofclones.models.TroopData;
import com.sureshCS50.gameofclones.ui.appActivity.MainViewModel;
import com.sureshCS50.gameofclones.utils.Constants;

import java.util.ArrayList;
import java.util.Random;

public class BattleFragmentViewModel extends ViewModel {

    private static final String TAG = "BattleFragmentViewModel";

    private DatabaseManager mDatabaseManager;
    MutableLiveData<TroopData> bdTroopData;
    MutableLiveData<TroopData> ctTroopData;
    MutableLiveData<Boolean> showCreateCTArmyPopup;

    BattleFragmentViewModel(MainViewModel sharedViewModel) {
        this.bdTroopData = new MutableLiveData<>();
        this.ctTroopData = new MutableLiveData<>();
        this.mDatabaseManager = DatabaseManager.getInstance();
        this.showCreateCTArmyPopup = new MutableLiveData<>();
    }

    void createBattleDroidArmy() {
        TroopData troopData = new TroopData();
        troopData.troops = new ArrayList<>();
        troopData.troopType = Constants.bd;

        Troop b1 = mDatabaseManager.getTroopByKind(Constants.bd_b1);
        b1.count = getRandom();
        b1.strength = getValue(b1.count, b1.strength);
        b1.agility = getValue(b1.count, b1.agility);
        b1.intelligence = getValue(b1.count, b1.intelligence);

        Troop b2 = mDatabaseManager.getTroopByKind(Constants.bd_b2);
        b2.count = getRandom();
        b2.strength = getValue(b2.count, b2.strength);
        b2.agility = getValue(b2.count, b2.agility);
        b2.intelligence = getValue(b2.count, b2.intelligence);

        Troop aat = mDatabaseManager.getTroopByKind(Constants.bd_aat);
        aat.count = getRandom();
        aat.strength = getValue(aat.count, aat.strength);
        aat.agility = getValue(aat.count, aat.agility);
        aat.intelligence = getValue(aat.count, aat.intelligence);

        troopData.troops.add(b1);
        troopData.troops.add(b2);
        troopData.troops.add(aat);
        troopData.totalTroops = b1.count + b2.count + aat.count;

        troopData.totalStrength = ((b1.strength + b2.strength + aat.strength)*100)/6000;
        troopData.totalAgility = ((b1.agility + b2.agility + aat.agility)*100)/6000;
        troopData.totalIntelligence = ((b1.intelligence + b2.intelligence + aat.intelligence)*100)/6000;

        bdTroopData.setValue(troopData);
    }

    public void createCloneTroopersArmy() {
        showCreateCTArmyPopup.setValue(true);
        showCreateCTArmyPopup.postValue(false);
    }

    private int getRandom() {
        Random r = new Random();
        int low = 1;
        int high = 200;
        return r.nextInt(high-low) + low;
    }

    private int getValue(int count, int value){
        return count * value;
    }

    void setCtTroopData(TroopData troopData) {
        ctTroopData.setValue(troopData);
    }

}