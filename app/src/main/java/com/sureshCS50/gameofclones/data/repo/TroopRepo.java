package com.sureshCS50.gameofclones.data.repo;

import com.sureshCS50.gameofclones.GOCApplication;
import com.sureshCS50.gameofclones.data.db.dao.TroopDao;
import com.sureshCS50.gameofclones.data.db.helper.TroopDbHelper;
import com.sureshCS50.gameofclones.data.db.entity.Troop;

import java.util.List;

public class TroopRepo extends BaseRepo<TroopDao, Troop> implements TroopDbHelper {

    public TroopRepo() {
        this.mDao = GOCApplication.getDatabase().troopDao();
    }

    @Override
    public List<Troop> listAllTroops() {
        return listAll(Troop.TABLE_NAME);
    }

    @Override
    public Troop getTroopByKind(String kind) {
        return mDao.getTroopByKind(kind).get(0);
    }

    @Override
    public void insertTroop(Troop object) {
        mDao.insertRecord(object);
    }

    @Override
    public void insertMultipleTroops(List<Troop> objects) {
        mDao.insertMultipleRecords(objects);
    }

    @Override
    public void updateTroop(Troop object) {
        mDao.update(object);
    }

    @Override
    public void deleteTroop(Troop object) {
        mDao.delete(object);
    }

}
