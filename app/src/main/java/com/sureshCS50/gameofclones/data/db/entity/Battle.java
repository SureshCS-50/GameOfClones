package com.sureshCS50.gameofclones.data.db.entity;

import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import static com.sureshCS50.gameofclones.data.db.entity.Battle.TABLE_NAME;

@Entity(tableName = TABLE_NAME)
public class Battle extends BaseEntity{
    public static final String TABLE_NAME = "battle";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_BD_TROOPS = "bdTroops";
    public static final String COLUMN_CT_TROOPS = "ctTroops";
    public static final String COLUMN_WINNER = "winner";
    public static final String COLUMN_SUMMARY = "summary";

    @PrimaryKey (autoGenerate = true)
    @ColumnInfo(name = COLUMN_ID)
    @SerializedName(COLUMN_ID)
    public int id;

    @ColumnInfo(name = COLUMN_BD_TROOPS)
    @SerializedName(COLUMN_BD_TROOPS)
    public String bdTroops;

    @ColumnInfo(name = COLUMN_CT_TROOPS)
    @SerializedName(COLUMN_CT_TROOPS)
    public String ctTroops;

    @ColumnInfo(name = COLUMN_WINNER)
    @SerializedName(COLUMN_WINNER)
    public String winner;

    @ColumnInfo(name = COLUMN_SUMMARY)
    @SerializedName(COLUMN_SUMMARY)
    public String summary;

    public Battle() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBdTroops() {
        return bdTroops;
    }

    public void setBdTroops(String bdTroops) {
        this.bdTroops = bdTroops;
    }

    public String getCtTroops() {
        return ctTroops;
    }

    public void setCtTroops(String ctTroops) {
        this.ctTroops = ctTroops;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        return super.equals(obj);
    }
}
