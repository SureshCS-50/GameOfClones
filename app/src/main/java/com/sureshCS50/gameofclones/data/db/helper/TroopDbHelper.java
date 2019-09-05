package com.sureshCS50.gameofclones.data.db.helper;

import com.sureshCS50.gameofclones.data.db.entity.Troop;

import java.util.List;

public interface TroopDbHelper {

    List<Troop> listAllTroops();

    Troop getTroopByKind(String kind);

    void insertTroop(Troop object);

    void insertMultipleTroops(List<Troop> objects);

    void updateTroop(Troop object);

    void deleteTroop(Troop object);

}
