package com.sureshCS50.gameofclones.ui.history;

import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.reflect.TypeToken;
import com.sureshCS50.gameofclones.data.db.entity.Battle;
import com.sureshCS50.gameofclones.databinding.ItemBattleHistoryBinding;
import com.sureshCS50.gameofclones.models.TroopData;
import com.sureshCS50.gameofclones.utils.Utils;

class HistoryListViewHolder extends RecyclerView.ViewHolder {

    private final ItemBattleHistoryBinding binder;

    public HistoryListViewHolder(ItemBattleHistoryBinding binder) {
        super(binder.getRoot());
        this.binder = binder;
    }

    public void bind(HistoryFragmentViewModel viewModel, int position) {
        Battle selectedBattle = viewModel.getBattleAt(position);
        binder.setViewModel(viewModel);
        binder.setBattle(selectedBattle);
        TroopData btTroopData = Utils.getObjectFromJson(selectedBattle.bdTroops,
                new TypeToken<TroopData>() {
                }.getType());
        TroopData ctTroopData = Utils.getObjectFromJson(selectedBattle.ctTroops,
                new TypeToken<TroopData>() {
                }.getType());
        binder.setBdTroopData(btTroopData);
        binder.setCtTroopData(ctTroopData);
        binder.executePendingBindings();
    }
}