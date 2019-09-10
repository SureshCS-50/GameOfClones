package com.sureshCS50.gameofclones.ui.battle_result_summary;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.gson.reflect.TypeToken;
import com.sureshCS50.gameofclones.data.db.entity.Battle;
import com.sureshCS50.gameofclones.models.TroopData;
import com.sureshCS50.gameofclones.ui.appActivity.MainViewModel;
import com.sureshCS50.gameofclones.utils.NavigationHandler;
import com.sureshCS50.gameofclones.utils.Utils;

public class BattleSummaryViewModel extends ViewModel {

    MainViewModel mSharedViewModel;
    public MutableLiveData<String> winnerText;
    public MutableLiveData<String> summary;
    public MutableLiveData<TroopData> bdTroopData;
    public MutableLiveData<TroopData> ctTroopData;
    private Battle mBattleRecord;

    BattleSummaryViewModel(MainViewModel sharedViewModel, Battle battle){
        winnerText = new MutableLiveData<>();
        summary = new MutableLiveData<>();
        bdTroopData = new MutableLiveData<>();
        ctTroopData = new MutableLiveData<>();

        this.mSharedViewModel = sharedViewModel;
        this.mBattleRecord = battle;

        winnerText.setValue(battle.winner + " won the battle!!!");
        bdTroopData.setValue((TroopData) Utils.getObjectFromJson(mBattleRecord.bdTroops, new TypeToken<TroopData>(){}.getType()));
        ctTroopData.setValue((TroopData) Utils.getObjectFromJson(mBattleRecord.ctTroops, new TypeToken<TroopData>(){}.getType()));
        summary.setValue(battle.summary);
    }

    public void onCloseClick(){
        mSharedViewModel.setNavigation(NavigationHandler.BATTLE_HISTORY);
    }

}