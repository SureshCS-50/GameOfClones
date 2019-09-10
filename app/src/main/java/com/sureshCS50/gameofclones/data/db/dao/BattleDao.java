package com.sureshCS50.gameofclones.data.db.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.sureshCS50.gameofclones.data.db.entity.Battle;

import java.util.List;

@Dao
public interface BattleDao extends BaseDao<Battle>{

    @Query("SELECT * FROM " + Battle.TABLE_NAME + " ORDER BY " + Battle.COLUMN_ID + " DESC LIMIT 1")
    Battle getLastRecord();

    @Query("SELECT * FROM " + Battle.TABLE_NAME + " WHERE " + Battle.COLUMN_WINNER + " = :winner " + " ORDER BY " + Battle.COLUMN_ID + " DESC")
    List<Battle> getRecordsByWinner(String winner);
}
