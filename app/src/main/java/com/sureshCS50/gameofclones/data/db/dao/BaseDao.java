package com.sureshCS50.gameofclones.data.db.dao;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.RawQuery;
import androidx.room.Transaction;
import androidx.room.Update;
import androidx.sqlite.db.SimpleSQLiteQuery;

import com.sureshCS50.gameofclones.data.db.entity.BaseEntity;

import java.util.List;

public interface BaseDao<T extends BaseEntity> {

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMultipleRecords(List<T> objects);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertRecord(T object);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void update(T object);

    @Delete
    void delete(T object);

    @RawQuery
    int executeQuery(SimpleSQLiteQuery query);

    @RawQuery
    T getRecord(SimpleSQLiteQuery query);

    @RawQuery
    List<T> getItemMatchesKey(SimpleSQLiteQuery query);

    @RawQuery
    List<T> listAll(SimpleSQLiteQuery query);
}
