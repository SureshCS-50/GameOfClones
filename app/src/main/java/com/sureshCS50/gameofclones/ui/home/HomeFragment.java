package com.sureshCS50.gameofclones.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import com.sureshCS50.gameofclones.R;
import com.sureshCS50.gameofclones.data.db.entity.Troop;
import com.sureshCS50.gameofclones.databinding.FragmentHomeBinding;
import com.sureshCS50.gameofclones.ui.appActivity.MainActivity;
import com.sureshCS50.gameofclones.ui.appActivity.MainViewModel;

import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private MainViewModel mSharedViewModel;
    private HomeFragmentViewModel viewModel;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        viewModel = new HomeFragmentViewModel(mSharedViewModel);
        binding.setViewModel(viewModel);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mSharedViewModel.getTroops().observe(this, new Observer<List<Troop>>() {
            @Override
            public void onChanged(List<Troop> troops) {
                viewModel.notifyAdapterDateSetChanged(troops);
                binding.setTroop(troops.get(0));
            }
        });

        setupClickListener();
    }

    private void setupClickListener() {
        viewModel.getSelectedTroop().observe(this, new Observer<Troop>() {
            @Override
            public void onChanged(Troop troop) {
                binding.setTroop(troop);
            }
        });
    }

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