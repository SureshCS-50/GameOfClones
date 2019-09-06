package com.sureshCS50.gameofclones.ui.history;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.sureshCS50.gameofclones.R;
import com.sureshCS50.gameofclones.data.db.entity.Battle;
import com.sureshCS50.gameofclones.data.db.entity.Troop;
import com.sureshCS50.gameofclones.databinding.ItemBattleHistoryBinding;
import com.sureshCS50.gameofclones.databinding.ItemCreateTroopBinding;
import com.sureshCS50.gameofclones.ui.battle.createTroopsDialog.CreateCTTroopDialogViewModel;

public class HistoryAdapter extends ListAdapter<Battle, HistoryListViewHolder> {

    private static DiffUtil.ItemCallback<Battle> DIFF_CALLBACK = new DiffUtil.ItemCallback<Battle>() {
        @Override
        public boolean areItemsTheSame(@NonNull Battle oldItem, @NonNull Battle newItem) {
            return oldItem.id == newItem.id;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Battle oldItem, @NonNull Battle newItem) {
            return oldItem.equals(newItem);
        }
    };

    private HistoryFragmentViewModel viewModel;

    public HistoryAdapter(HistoryFragmentViewModel viewModel) {
        super(DIFF_CALLBACK);
        this.viewModel = viewModel;
    }

    @NonNull
    @Override
    public HistoryListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBattleHistoryBinding binder = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.item_battle_history, parent, false);
        return new HistoryListViewHolder(binder);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryListViewHolder holder, int position) {
        holder.bind(viewModel, position);
    }

}