package com.iamdsr.whatever.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.iamdsr.whatever.Models.ProductsModel;
import com.iamdsr.whatever.R;
import com.iamdsr.whatever.Utils.RecyclerViewActionsInterface;

public class TrendingProductsRecyclerAdapter extends ListAdapter<ProductsModel, TrendingProductsRecyclerAdapter.ViewHolder> {

    private final RecyclerViewActionsInterface recyclerViewActionsInterface;
    private Context context;

    public TrendingProductsRecyclerAdapter(@NonNull DiffUtil.ItemCallback<ProductsModel> diffCallback, RecyclerViewActionsInterface recyclerViewActionsInterface) {
        super(diffCallback);
        this.recyclerViewActionsInterface = recyclerViewActionsInterface;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_products,parent,false);
        context = parent.getContext();
        return new TrendingProductsRecyclerAdapter.ViewHolder(view, recyclerViewActionsInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProductsModel productsModel = getItem(position);
        holder.bind(productsModel,context);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mProductName, mProductPrice;
        private RatingBar mProductRating;
        private ImageView mProductImage;
        public ViewHolder(@NonNull View itemView, RecyclerViewActionsInterface recyclerViewActionsInterface) {
            super(itemView);
            mProductName = itemView.findViewById(R.id.product_name);
            mProductPrice = itemView.findViewById(R.id.product_price);
            mProductRating = itemView.findViewById(R.id.product_rating);
            mProductImage = itemView.findViewById(R.id.product_image);
            mProductRating.setEnabled(false);
        }

        public void bind(ProductsModel productsModel, Context context) {
            final String productName = productsModel.getProductName();
            final String productPrice = productsModel.getProductPrice();
            final String productImage = productsModel.getProductImage();
            final float productRating = Float.parseFloat(productsModel.getProductRating());
            // set product name, price, rating
            mProductName.setText(productName);
            mProductPrice.setText(productPrice);
            mProductRating.setRating(productRating);
            // set product image
            RequestOptions placeholderRequest = new RequestOptions();
            if (context!=null) {
                placeholderRequest.placeholder(R.drawable.placeholder_image);
                Glide.with(context)
                        .applyDefaultRequestOptions(placeholderRequest)
                        .load(productImage)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(mProductImage);
            }
        }
    }
}
