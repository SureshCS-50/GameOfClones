package com.sureshCS50.gameofclones.data.db.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.sureshCS50.gameofclones.data.db.entity.Troop;

import java.util.List;

@Dao
public interface TroopDao extends BaseDao<Troop> {

    @Query("SELECT * FROM " + Troop.TABLE_NAME + " WHERE " + Troop.COLUMN_KIND + " =:kind")
    List<Troop> getTroopByKind(String kind);

}