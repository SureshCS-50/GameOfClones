package com.sureshCS50.gameofclones.ui.appActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.sureshCS50.gameofclones.R;
import com.sureshCS50.gameofclones.data.db.DatabaseManager;
import com.sureshCS50.gameofclones.data.db.entity.Troop;
import com.sureshCS50.gameofclones.ui.battle.BattleFragment;
import com.sureshCS50.gameofclones.ui.battle_result.BattleResultFragment;
import com.sureshCS50.gameofclones.ui.history.HistoryFragment;
import com.sureshCS50.gameofclones.ui.home.HomeFragment;
import com.sureshCS50.gameofclones.utils.NavigationHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationHandler {

    private FragmentManager mFragmentManager;
    private MainViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DataBindingUtil.setContentView(this, R.layout.activity_main);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mFragmentManager = getSupportFragmentManager();

        observerNavigation();
        observerOnLoadDateComplete();

        loadDataFromAssets();
        mViewModel.setNavigation(NavigationHandler.HOME);
    }

    private void observerOnLoadDateComplete() {
        mViewModel.getTroops().observe(this, new Observer<ArrayList<Troop>>() {
            @Override
            public void onChanged(ArrayList<Troop> troops) {
            }
        });
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
            mViewModel.setTroops(troops);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void observerNavigation() {
        mViewModel.getNavigation().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer page) {
                switch(page){
                    case NavigationHandler.HOME:
                        loadHomeFragment();
                        break;
                    case NavigationHandler.NEW_BATTLE:
                        loadNewBattleFragment();
                        break;
                    case NavigationHandler.BATTLE_RESULT:
                        loadBattleResult();
                        break;
                    case NavigationHandler.BATTLE_HISTORY:
                        loadBattleHistory();
                        break;
                }
            }
        });
    }

    public MainViewModel getSharedViewModel(){
        return mViewModel;
    }

    private Fragment getCurrentFragment() {
        List<Fragment> fragments = mFragmentManager.getFragments();
        if (fragments.isEmpty()) {
            return null;
        }
        return fragments.get(fragments.size() - 1);
    }

    @Override
    public void loadHomeFragment() {
        loadFragment(new HomeFragment());
    }

    @Override
    public void loadNewBattleFragment() {
        loadFragment(new BattleFragment());
    }

    @Override
    public void loadBattleResult() {
        loadFragment(new BattleResultFragment());
    }

    @Override
    public void loadBattleHistory() {
        loadFragment(new HistoryFragment());
    }

    private void loadFragment(Fragment fragment) {
        mFragmentManager
                .beginTransaction()
                .add(R.id.container, fragment)
                .commit();
    }

}