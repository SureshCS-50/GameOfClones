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
        DatabaseManager databaseManager = DatabaseManager.getInstance();

        observerNavigation();
        observerOnLoadDateComplete();

        mViewModel.setTroops(new ArrayList<>(databaseManager.listAllTroops()));
        mViewModel.setNavigation(NavigationHandler.HOME);
    }

    private void observerOnLoadDateComplete() {
        mViewModel.getTroops().observe(this, new Observer<ArrayList<Troop>>() {
            @Override
            public void onChanged(ArrayList<Troop> troops) {
            }
        });
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
        loadFragment(new HomeFragment(), HomeFragment.TAG);
    }

    @Override
    public void loadNewBattleFragment() {
        loadFragment(new BattleFragment(), BattleFragment.TAG);
    }

    @Override
    public void loadBattleResult() {
        loadFragment(new BattleResultFragment(), BattleResultFragment.TAG);
    }

    @Override
    public void loadBattleHistory() {
        loadFragment(new HistoryFragment(), HistoryFragment.TAG);
    }

    private void loadFragment(Fragment fragment, String tag) {
        Fragment fragment1 = mFragmentManager.findFragmentByTag(tag);
        if(fragment1 != null){
            mFragmentManager.popBackStack(tag, 0);
        } else {
            mFragmentManager
                    .beginTransaction()
                    .replace(R.id.container, fragment, tag)
                    .addToBackStack(tag)
                    .commit();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        int i = mFragmentManager.getBackStackEntryCount() - 1;
        if(i >= 0){
            mFragmentManager.popBackStack(mFragmentManager.getBackStackEntryAt(i).getName(), 0);
        } else {
            finish();
        }
    }
}