package com.sureshCS50.gameofclones.data.repo;

import com.sureshCS50.gameofclones.GOCApplication;
import com.sureshCS50.gameofclones.data.db.dao.BattleDao;
import com.sureshCS50.gameofclones.data.db.entity.Battle;
import com.sureshCS50.gameofclones.data.db.helper.BattleDbHelper;

import java.util.HashMap;
import java.util.List;

public class BattleRepo extends BaseRepo<BattleDao, Battle> implements BattleDbHelper {

    public BattleRepo() {
        this.mDao = GOCApplication.getDatabase().battleDao();
    }

    @Override
    public List<Battle> listAllBattles() {
        return listAll(Battle.TABLE_NAME);
    }

    @Override
    public List<Battle> findCard(HashMap<String, String> fields) {
        return findItem(Battle.TABLE_NAME, fields);
    }

    @Override
    public void insertBattle(Battle object) {
        mDao.insertRecord(object);
    }

    @Override
    public Battle getLastRecord() {
        return mDao.getLastRecord();
    }

}
