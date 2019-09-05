package com.sureshCS50.gameofclones.data.db.helper;

import com.sureshCS50.gameofclones.data.db.entity.Battle;

import java.util.HashMap;
import java.util.List;

public interface BattleDbHelper {

    List<Battle> listAllBattles();

    List<Battle> findCard(HashMap<String, String> fields);

    void insertBattle(Battle object);
}
