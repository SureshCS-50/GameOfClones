package com.sureshCS50.gameofclones.ui.battle.createTroopsDialog;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.sureshCS50.gameofclones.R;
import com.sureshCS50.gameofclones.data.db.entity.Troop;
import com.sureshCS50.gameofclones.databinding.ItemCreateTroopBinding;
import com.sureshCS50.gameofclones.databinding.ItemTroopBinding;
import com.sureshCS50.gameofclones.ui.home.HomeFragmentViewModel;
import com.sureshCS50.gameofclones.ui.home.TroopViewHolder;

public class CreateTroopsAdapter extends ListAdapter<Troop, CreateTroopViewHolder> {

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

    private CreateCTTroopDialogViewModel viewModel;

    public CreateTroopsAdapter(CreateCTTroopDialogViewModel viewModel) {
        super(DIFF_CALLBACK);
        this.viewModel = viewModel;
    }

    @NonNull
    @Override
    public CreateTroopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCreateTroopBinding binder = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.item_create_troop, parent, false);
        return new CreateTroopViewHolder(binder);
    }

    @Override
    public void onBindViewHolder(@NonNull CreateTroopViewHolder holder, int position) {
        holder.bind(viewModel, position);
    }

}