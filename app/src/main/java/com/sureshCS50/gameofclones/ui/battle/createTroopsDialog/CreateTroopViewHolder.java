package com.sureshCS50.gameofclones.ui.battle.createTroopsDialog;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.sureshCS50.gameofclones.R;
import com.sureshCS50.gameofclones.data.db.entity.Troop;
import com.sureshCS50.gameofclones.databinding.ItemCreateTroopBinding;

class CreateTroopViewHolder extends RecyclerView.ViewHolder {

    private final ItemCreateTroopBinding binder;

    CreateTroopViewHolder(ItemCreateTroopBinding binder) {
        super(binder.getRoot());
        this.binder = binder;
    }

    void bind(CreateCTTroopDialogViewModel viewModel, int position) {
        final Troop selectedTroop = viewModel.getTroopAt(position);
        View view = binder.getRoot();

        final ElegantNumberButton button =  view.findViewById(R.id.number_button);
        button.setOnClickListener(new ElegantNumberButton.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedTroop.count = Integer.valueOf(button.getNumber());
            }
        });

        binder.setViewModel(viewModel);
        binder.setTroop(selectedTroop);
        binder.executePendingBindings();
    }
}