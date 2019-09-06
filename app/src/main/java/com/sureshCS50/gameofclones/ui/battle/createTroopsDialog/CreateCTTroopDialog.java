package com.sureshCS50.gameofclones.ui.battle.createTroopsDialog;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;

import com.sureshCS50.gameofclones.R;
import com.sureshCS50.gameofclones.data.db.entity.Troop;
import com.sureshCS50.gameofclones.databinding.FragmentCreateCttroopDialogBinding;

import java.util.ArrayList;

public class CreateCTTroopDialog extends DialogFragment {

    public static final String TAG = "CreateCTTroopDialog";

    private FragmentCreateCttroopDialogBinding binding;
    private CreateCTTroopDialogViewModel mViewModel;

    public CreateCTTroopDialog() {
        // Required empty public constructor
    }

    @Override public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.CustomDialog);
    }

    @Override
    public void onStart() {
        super.onStart();
        getDialog().getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                        WindowManager.LayoutParams.MATCH_PARENT);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_create_cttroop_dialog,
                container, false);
        mViewModel = new CreateCTTroopDialogViewModel((CreateTroopFragmentCommunicator) getTargetFragment());
        binding.setViewModel(mViewModel);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel.getCtTroops().observe(this, new Observer<ArrayList<Troop>>() {
            @Override
            public void onChanged(ArrayList<Troop> troops) {
                mViewModel.notifyAdapter(troops);
            }
        });

        mViewModel.errorMessage.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(getActivity(), mViewModel.errorMessage.getValue(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
