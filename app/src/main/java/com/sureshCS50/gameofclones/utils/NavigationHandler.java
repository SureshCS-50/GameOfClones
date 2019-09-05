package com.sureshCS50.gameofclones.utils;

public interface NavigationHandler {

    int HOME = 1;
    int NEW_BATTLE = 2;
    int BATTLE_RESULT = 3;
    int BATTLE_HISTORY = 4;

    void loadHomeFragment();

    void loadNewBattleFragment();

    void loadBattleResult();

    void loadBattleHistory();

}
