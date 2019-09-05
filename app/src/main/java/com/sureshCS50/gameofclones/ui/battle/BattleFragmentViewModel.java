package com.sureshCS50.gameofclones.ui.battle;

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

    MainViewModel mSharedViewModel;
    DatabaseManager mDatabaseManager;
    MutableLiveData<TroopData> bdTroopData;
    MutableLiveData<TroopData> ctTroopData;

    public BattleFragmentViewModel(MainViewModel sharedViewModel) {
        this.bdTroopData = new MutableLiveData<>();
        this.mSharedViewModel = sharedViewModel;
        this.mDatabaseManager = DatabaseManager.getInstance();
    }

    public void createBattleDroidArmy() {
        TroopData troopData = new TroopData();
        troopData.troops = new ArrayList<>();
        troopData.troopType = Constants.bd;

        Troop b1 = mDatabaseManager.getTroopByKind(Constants.bd_b1);
        b1.count = new Random().nextInt(201);
        b1.strength = getValue(b1.count, b1.strength);
        b1.agility = getValue(b1.count, b1.agility);
        b1.intelligence = getValue(b1.count, b1.intelligence);

        Troop b2 = mDatabaseManager.getTroopByKind(Constants.bd_b2);
        b2.count = new Random().nextInt(201);
        b2.strength = getValue(b2.count, b2.strength);
        b2.agility = getValue(b2.count, b2.agility);
        b2.intelligence = getValue(b2.count, b2.intelligence);

        Troop aat = mDatabaseManager.getTroopByKind(Constants.bd_aat);
        aat.count = new Random().nextInt(201);
        aat.strength = getValue(aat.count, aat.strength);
        aat.agility = getValue(aat.count, aat.agility);
        aat.intelligence = getValue(aat.count, aat.intelligence);

        troopData.troops.add(b1);
        troopData.troops.add(b2);
        troopData.troops.add(aat);

        troopData.totalStrength = ((b1.strength + b2.strength + aat.strength)*100)/6000;
        troopData.totalAgility = ((b1.agility + b2.agility + aat.agility)*100)/6000;
        troopData.totalIntelligence = ((b1.intelligence + b2.intelligence + aat.intelligence)*100)/6000;

        bdTroopData.setValue(troopData);
    }


    private int getValue(int count, int value){
        return count * value;
    }
}
