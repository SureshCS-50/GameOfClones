package com.sureshCS50.gameofclones.data.db.entity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import static com.sureshCS50.gameofclones.data.db.entity.Troop.TABLE_NAME;

@Entity(tableName = TABLE_NAME)
public class Troop extends BaseEntity {

    public final static String TABLE_NAME = "troop";
    public final static String COLUMN_KIND = "kind";
    public final static String COLUMN_DESCRIPTION = "description";
    public final static String COLUMN_STRENGTH = "strength";
    public final static String COLUMN_AGILITY = "agility";
    public final static String COLUMN_INTELLIGENCE = "intelligence";
    public final static String COLUMN_TERRAIN = "terrain";
    public final static String COLUMN_TYPE = "type";
    public final static String COLUMN_COUNT = "count";

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = COLUMN_KIND)
    @SerializedName(COLUMN_KIND)
    public String kind = "";

    @ColumnInfo(name = COLUMN_DESCRIPTION)
    @SerializedName(COLUMN_DESCRIPTION)
    public String description;

    @SerializedName(COLUMN_STRENGTH)
    @ColumnInfo(name = COLUMN_STRENGTH)
    public int strength;

    @SerializedName(COLUMN_AGILITY)
    @ColumnInfo(name = COLUMN_AGILITY)
    public int agility;

    @SerializedName(COLUMN_INTELLIGENCE)
    @ColumnInfo(name = COLUMN_INTELLIGENCE)
    public int intelligence;

    @SerializedName(COLUMN_TERRAIN)
    @ColumnInfo(name = COLUMN_TERRAIN)
    public String terrain;

    @SerializedName(COLUMN_TYPE)
    @ColumnInfo(name = COLUMN_TYPE)
    public String type;

    @SerializedName(COLUMN_COUNT)
    @ColumnInfo (name = COLUMN_COUNT)
    public int count;

    public Troop() {
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isCloneTroop(){
        return type.equalsIgnoreCase("clone trooper");
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        return super.equals(obj);
    }
}