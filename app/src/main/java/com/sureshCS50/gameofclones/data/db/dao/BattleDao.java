package com.sureshCS50.gameofclones.data.db.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.sureshCS50.gameofclones.data.db.entity.Battle;

@Dao
public interface BattleDao extends BaseDao<Battle>{

    @Query("SELECT * FROM " + Battle.TABLE_NAME + " ORDER BY " + Battle.COLUMN_ID + " DESC LIMIT 1")
    Battle getLastRecord();
}
