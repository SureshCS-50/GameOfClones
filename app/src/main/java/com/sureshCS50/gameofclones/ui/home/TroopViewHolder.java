package com.sureshCS50.gameofclones.ui.home;

import androidx.recyclerview.widget.RecyclerView;

import com.sureshCS50.gameofclones.data.db.entity.Troop;
import com.sureshCS50.gameofclones.databinding.ItemTroopBinding;

public class TroopViewHolder extends RecyclerView.ViewHolder {

    private final ItemTroopBinding binder;

    TroopViewHolder(ItemTroopBinding binder) {
        super(binder.getRoot());
        this.binder = binder;
    }

    void bind(HomeFragmentViewModel viewModel, int position) {
        Troop selectedTroop = viewModel.getTroopAt(position);
        binder.setViewModel(viewModel);
        binder.setTroop(selectedTroop);
        binder.executePendingBindings();
    }

}
