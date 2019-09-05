package com.sureshCS50.gameofclones.ui.home;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.sureshCS50.gameofclones.R;
import com.sureshCS50.gameofclones.data.db.entity.Troop;
import com.sureshCS50.gameofclones.databinding.ItemTroopBinding;

public class TroopsAdapter extends ListAdapter<Troop, TroopViewHolder> {

    private static DiffUtil.ItemCallback<Troop> DIFF_CALLBACK = new DiffUtil.ItemCallback<Troop>() {
        @Override
        public boolean areItemsTheSame(@NonNull Troop oldItem, @NonNull Troop newItem) {
            return oldItem.kind.equals(newItem.kind);
        }

        @Override
        public boolean areContentsTheSame(@NonNull Troop oldItem, @NonNull Troop newItem) {
            return oldItem.equals(newItem);
        }
    };

    private HomeFragmentViewModel viewModel;

    TroopsAdapter(HomeFragmentViewModel viewModel) {
        super(DIFF_CALLBACK);
        this.viewModel = viewModel;
    }

    @NonNull
    @Override
    public TroopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemTroopBinding binder = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.item_troop, parent, false);
        return new TroopViewHolder(binder);
    }

    @Override
    public void onBindViewHolder(@NonNull TroopViewHolder holder, int position) {
        holder.bind(viewModel, position);
    }

}