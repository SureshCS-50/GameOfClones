package com.sureshCS50.gameofclones.ui.battle.createTroopsDialog;

import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.sureshCS50.gameofclones.data.db.DatabaseManager;
import com.sureshCS50.gameofclones.data.db.entity.Troop;
import com.sureshCS50.gameofclones.models.TroopData;
import com.sureshCS50.gameofclones.utils.Constants;

import java.util.ArrayList;

public class CreateCTTroopDialogViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Troop>> mCtTroops;
    private DatabaseManager mDatabaseManager;
    private CreateTroopFragmentCommunicator mCommunicator;
    private MutableLiveData<String> errorMessage;

    private CreateTroopsAdapter mAdapter;

    CreateCTTroopDialogViewModel(CreateTroopFragmentCommunicator communicator) {
        mCommunicator = communicator;
        mDatabaseManager = DatabaseManager.getInstance();
        mCtTroops = new MutableLiveData<>();
        errorMessage = new MutableLiveData<>();
        mAdapter = new CreateTroopsAdapter(this);
    }

    MutableLiveData<ArrayList<Troop>> getCtTroops(){
        mCtTroops.setValue(new ArrayList<>(mDatabaseManager.getTroopsByType(Constants.ct)));
        return mCtTroops;
    }

    void notifyAdapter(ArrayList<Troop> troops) {
        mAdapter.submitList(troops);
    }

    Troop getTroopAt(int position) {
        return mCtTroops.getValue().get(position);
    }

    public CreateTroopsAdapter getAdapter(){
        return mAdapter;
    }

    public void cancelDialog(){
        mCommunicator.onCancelDialog();
    }

    public void createTroops(){
        ArrayList<Troop> troops = mCtTroops.getValue();
        int count = 0;
        int totalTroopCount = 0;

        // to check atleast 3 troops selected..
        for(Troop t : troops){
            count = (t.count > 0) ? ++count : count;
            totalTroopCount = totalTroopCount + t.count;

            if(t.count > 0) {
                t.strength = t.strength * t.count;
                t.agility = t.agility * t.count;
                t.intelligence = t.intelligence * t.count;
            }
        }

        if(count < 3) {
            errorMessage.setValue("Please select atleast 3 troops");
        } else {
            TroopData troopData = new TroopData();
            troopData.troops = new ArrayList<>();
            troopData.troopType = Constants.ct;
            troopData.totalTroops = totalTroopCount;

            for(Troop t : troops){
                if(t.count > 0) {
                    troopData.totalStrength = t.strength + troopData.totalStrength;
                    troopData.totalAgility = t.agility + troopData.totalAgility;
                    troopData.totalIntelligence = t.intelligence + troopData.totalIntelligence;
                    troopData.troops.add(t);
                }
            }

            troopData.totalStrength = ((troopData.totalStrength)*100)/4000;
            troopData.totalAgility = ((troopData.totalAgility)*100)/4000;
            troopData.totalIntelligence = ((troopData.totalIntelligence)*100)/4000;

            mCommunicator.onCreateTroops(troopData);
        }
    }

}