package com.sureshCS50.gameofclones.ui.battle_result;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sureshCS50.gameofclones.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BattleResultFragment extends Fragment {


    public BattleResultFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_battle_result, container, false);
    }

}
