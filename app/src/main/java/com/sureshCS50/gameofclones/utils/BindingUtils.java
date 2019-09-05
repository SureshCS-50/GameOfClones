package com.sureshCS50.gameofclones.utils;

import android.widget.ImageView;

import androidx.annotation.IdRes;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class BindingUtils {
    @BindingAdapter("setAdapter")
    public static void bindRecyclerViewAdapter(RecyclerView recyclerView, RecyclerView.Adapter<?> adapter) {
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);
    }

    @BindingAdapter("load_image")
    public static void loadImage(ImageView view, String kind) {
        view.setImageResource(Constants.getImageResource(kind));
    }
}
