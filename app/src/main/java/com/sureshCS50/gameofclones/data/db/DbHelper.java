package com.sureshCS50.gameofclones.data.db;

import com.sureshCS50.gameofclones.data.db.helper.BattleDbHelper;
import com.sureshCS50.gameofclones.data.db.helper.TroopDbHelper;

public interface DbHelper extends TroopDbHelper, BattleDbHelper {

    void createInstance();

}
