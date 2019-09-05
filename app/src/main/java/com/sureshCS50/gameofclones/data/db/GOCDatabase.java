package com.sureshCS50.gameofclones.data.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.sureshCS50.gameofclones.data.db.dao.BattleDao;
import com.sureshCS50.gameofclones.data.db.dao.TroopDao;
import com.sureshCS50.gameofclones.data.db.entity.Battle;
import com.sureshCS50.gameofclones.data.db.entity.Troop;

@Database(entities = {Troop.class, Battle.class}, version = 2, exportSchema = false)
public abstract class GOCDatabase extends RoomDatabase {

    private static GOCDatabase instance;

    public static GOCDatabase getInstance(final Context context) {
        if (instance == null) {
            synchronized (GOCDatabase.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                            GOCDatabase.class, "goc-database")
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return instance;
    }

    public abstract TroopDao troopDao();

    public abstract BattleDao battleDao();
}