package com.sureshCS50.gameofclones.ui.battle.createTroopsDialog;

import com.sureshCS50.gameofclones.models.TroopData;

public interface CreateTroopFragmentCommunicator {

    void onCancelDialog();

    void onCreateTroops(TroopData troopData);
}
