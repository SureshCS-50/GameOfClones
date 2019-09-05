package com.sureshCS50.gameofclones.data.repo;

import androidx.sqlite.db.SimpleSQLiteQuery;

import com.sureshCS50.gameofclones.data.db.dao.BaseDao;
import com.sureshCS50.gameofclones.data.db.entity.BaseEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BaseRepo<E extends BaseDao, T extends BaseEntity> {

    E mDao;

    List<T> listAll(String tableName) {
        SimpleSQLiteQuery query = new SimpleSQLiteQuery("SELECT * FROM " + tableName);
        return mDao.listAll(query);
    }

    List<T> findItem(String tableName, HashMap<String, String> fields) {
        StringBuilder query = new StringBuilder("SELECT * FROM " + tableName + " WHERE ");
        String equals = " LIKE ";
        String separator = " OR ";
        if (fields != null) {
            Set set = fields.entrySet();
            Iterator iterator = set.iterator();
            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry) iterator.next();
                if (entry.getValue() != null && entry.getKey() != null) {
                    String key = entry.getKey().toString().trim();
                    String value = entry.getValue().toString().trim();
                    if (!value.isEmpty() && !key.isEmpty()) {
                        query.append(key).append(equals).append("\"%" + value + "%\"");
                        if (iterator.hasNext()) {
                            query.append(separator);
                        }
                    }
                }
            }
            SimpleSQLiteQuery sqLiteQuery = new SimpleSQLiteQuery(query.toString());
            return mDao.getItemMatchesKey(sqLiteQuery);
        }
        return new ArrayList<>();
    }

}