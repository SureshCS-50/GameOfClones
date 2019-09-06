package com.sureshCS50.gameofclones.ui;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.sureshCS50.gameofclones.ui.appActivity.MainActivity;
import com.sureshCS50.gameofclones.ui.appActivity.MainViewModel;

public class BaseFragment extends Fragment {

    protected MainViewModel mSharedViewModel;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (getActivity() != null) {
            mSharedViewModel = ((MainActivity) getActivity()).getSharedViewModel();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mSharedViewModel = null;
    }

}
