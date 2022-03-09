package com.iamdsr.whatever.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.iamdsr.whatever.Models.CategoryModel;
import com.iamdsr.whatever.R;
import com.iamdsr.whatever.Utils.RecyclerViewActionsInterface;

public class CategoryRecyclerAdapter extends ListAdapter<CategoryModel, CategoryRecyclerAdapter.ViewHolder> {

    private final RecyclerViewActionsInterface recyclerViewActionsInterface;
    private Context context;

    public CategoryRecyclerAdapter(@NonNull DiffUtil.ItemCallback<CategoryModel> diffCallback, RecyclerViewActionsInterface recyclerViewActionsInterface) {
        super(diffCallback);
        this.recyclerViewActionsInterface = recyclerViewActionsInterface;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_category,parent,false);
        context = parent.getContext();
        return new ViewHolder(view, recyclerViewActionsInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CategoryModel categoryModel = getItem(position);
        holder.bind(categoryModel,context);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mCategoryName;
        private ImageView mCategoryImage;
        public ViewHolder(@NonNull View itemView, RecyclerViewActionsInterface recyclerViewActionsInterface) {
            super(itemView);
            mCategoryName = itemView.findViewById(R.id.category_name);
            mCategoryImage = itemView.findViewById(R.id.category_image);
        }
        public void bind(CategoryModel categoryModel, Context context){
            final String categoryName = categoryModel.getCategoryName();
            final String categoryImage = categoryModel.getCategoryImage();
            // set category name
            mCategoryName.setText(categoryName);
            // set category image
            RequestOptions placeholderRequest = new RequestOptions();
            if (context!=null) {
                placeholderRequest.placeholder(R.drawable.placeholder_image);
                Glide.with(context)
                        .applyDefaultRequestOptions(placeholderRequest)
                        .load(categoryImage)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(mCategoryImage);
            }
        }
    }
}
