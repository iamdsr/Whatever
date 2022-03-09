package com.iamdsr.whatever.Utils;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.iamdsr.whatever.Models.MainParentModel;

public class Comparator extends DiffUtil.ItemCallback<MainParentModel> {
    @Override
    public boolean areItemsTheSame(@NonNull MainParentModel oldItem, @NonNull MainParentModel newItem) {
        return false;
    }

    @Override
    public boolean areContentsTheSame(@NonNull MainParentModel oldItem, @NonNull MainParentModel newItem) {
        return false;
    }
}
