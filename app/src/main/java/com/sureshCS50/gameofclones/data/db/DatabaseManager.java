package com.sureshCS50.gameofclones.data.db;

import com.sureshCS50.gameofclones.data.db.entity.Battle;
import com.sureshCS50.gameofclones.data.db.entity.Troop;
import com.sureshCS50.gameofclones.data.repo.BattleRepo;
import com.sureshCS50.gameofclones.data.repo.TroopRepo;

import java.util.HashMap;
import java.util.List;

public class DatabaseManager implements DbHelper {

    private static DatabaseManager mInstance = null;

    private TroopRepo mTroopRepoInstance;

    private BattleRepo mBattleRepoInstance;

    private DatabaseManager() {
        createInstance();
    }

    public static DatabaseManager getInstance() {
        if (mInstance == null) {
            mInstance = new DatabaseManager();
        }
        return mInstance;
    }

    @Override
    public void createInstance() {
        mTroopRepoInstance = new TroopRepo();
        mBattleRepoInstance = new BattleRepo();
    }

    @Override
    public List<Troop> listAllTroops() {
        return mTroopRepoInstance.listAllTroops();
    }

    @Override
    public Troop getTroopByKind(String kind) {
        return mTroopRepoInstance.getTroopByKind(kind);
    }

    @Override
    public List<Troop> getTroopsByType(String type) {
        return mTroopRepoInstance.getTroopsByType(type);
    }

    @Override
    public void insertTroop(Troop object) {
        mTroopRepoInstance.insertTroop(object);
    }

    @Override
    public void insertMultipleTroops(List<Troop> objects) {
        mTroopRepoInstance.insertMultipleTroops(objects);
    }

    @Override
    public void updateTroop(Troop object) {
        mTroopRepoInstance.updateTroop(object);
    }

    @Override
    public void deleteTroop(Troop object) {
        mTroopRepoInstance.deleteTroop(object);
    }

    @Override
    public List<Battle> listAllBattles() {
        return mBattleRepoInstance.listAllBattles();
    }

    @Override
    public List<Battle> findCard(HashMap<String, String> fields) {
        return mBattleRepoInstance.findCard(fields);
    }

    @Override
    public void insertBattle(Battle object) {
        mBattleRepoInstance.insertBattle(object);
    }

    @Override
    public Battle getLastRecord() {
        return mBattleRepoInstance.getLastRecord();
    }

    @Override
    public List<Battle> getRecordsByWinner(String winner) {
        return mBattleRepoInstance.getRecordsByWinner(winner);
    }
}
