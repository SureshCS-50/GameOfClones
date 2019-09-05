package com.sureshCS50.gameofclones;

import android.app.Application;

import com.sureshCS50.gameofclones.data.db.DatabaseManager;
import com.sureshCS50.gameofclones.data.db.GOCDatabase;
import com.sureshCS50.gameofclones.data.db.entity.Troop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GOCApplication extends Application {

    private static GOCDatabase mGOCDatabase;

    private static final String TAG = "GOCApplication";

    public static GOCDatabase getDatabase() {
        return mGOCDatabase;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mGOCDatabase = GOCDatabase.getInstance(this);
        loadDataFromAssets();
    }

    private void loadDataFromAssets() {
        DatabaseManager databaseManager = DatabaseManager.getInstance();
        ArrayList<Troop> troops = new ArrayList<>();
        ArrayList<String[]> rowData = new ArrayList<>();

        InputStreamReader is = null;
        BufferedReader reader = null;
        try {
            is = new InputStreamReader(getAssets().open("data.csv"));
            reader = new BufferedReader(is);
            reader.readLine();
            String line;

            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                String[] contents = new String[7];
                int contentPosition = 0;
                boolean hasQuote = false;
                String content = "";

                for(String s : row){
                    if(s.contains("\"")){
                        hasQuote = !hasQuote;
                    }

                    String separator = "";

                    if(!content.isEmpty()){
                        separator = ", ";
                    }

                    content = content + separator + s.replace("\"", "");

                    if(!hasQuote){
                        contents[contentPosition] = content;
                        contentPosition++;
                        content = "";
                    }
                }

                rowData.add(contents);
            }

            for(int i = 0; i < rowData.size(); i++){
                String[] row = rowData.get(i);
                Troop troop = new Troop();
                troop.kind = row[0];
                troop.description = row[1];
                troop.strength = Integer.valueOf(row[2]);
                troop.agility = Integer.valueOf(row[3]);
                troop.intelligence = Integer.valueOf(row[4]);
                troop.terrain = row[5];
                troop.type = row[6];
                troops.add(troop);
            }

            databaseManager.insertMultipleTroops(troops);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
