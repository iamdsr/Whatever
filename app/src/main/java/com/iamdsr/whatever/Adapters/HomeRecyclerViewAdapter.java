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
import com.iamdsr.whatever.Models.CategoryLabelModel;
import com.iamdsr.whatever.Models.CategoryModel;
import com.iamdsr.whatever.Models.MainParentModel;
import com.iamdsr.whatever.Models.ProductsModel;
import com.iamdsr.whatever.Models.TrendingProductsLabelModel;
import com.iamdsr.whatever.R;
import com.iamdsr.whatever.Utils.Comparator;
import com.iamdsr.whatever.Utils.RecyclerViewActionsInterface;

public class HomeRecyclerViewAdapter extends ListAdapter<MainParentModel, RecyclerView.ViewHolder> {

    private Context context;
    private RecyclerViewActionsInterface recyclerViewActionsInterface;

   public HomeRecyclerViewAdapter(){
       super(new Comparator());
   }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == 0){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recy_category_label, parent, false);
            context = parent.getContext();
            return new CategoryLabelViewHolder(view);
        }
        else if (viewType == 1){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recy_category_rec_view, parent, false);
            context = parent.getContext();
            return new CategoryRecyclerViewHolder(view);
        }
        if (viewType == 2){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recy_trend_prod_label, parent, false);
            context = parent.getContext();
            return new TrendingProductsLabelViewHolder(view);
        }
        else if (viewType == 3){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recy_trend_prod_rec_view, parent, false);
            context = parent.getContext();
            return new TrendingProductsRecyclerViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof CategoryLabelViewHolder){
            ((CategoryLabelViewHolder)holder).bindView();
        }
        else if (holder instanceof CategoryRecyclerViewHolder){
            ((CategoryRecyclerViewHolder)holder).bindView((CategoryModel) getItem(position), context);
        }
        else if (holder instanceof TrendingProductsLabelViewHolder){
            ((TrendingProductsLabelViewHolder)holder).bindView();
        }
        else if (holder instanceof TrendingProductsRecyclerViewHolder){
            ((TrendingProductsRecyclerViewHolder)holder).bindView((ProductsModel) getItem(position), context);
        }
    }

    // VIEW HOLDERS STARTS FROM HERE-------------------------------------------------------------------------------------

    public static class CategoryLabelViewHolder extends RecyclerView.ViewHolder{
        private TextView mLabel;
        public CategoryLabelViewHolder(@NonNull View itemView) {
            super(itemView);
            mLabel = itemView.findViewById(R.id.category_label);
        }
        public void bindView(){

        }
    }

    public static class CategoryRecyclerViewHolder extends RecyclerView.ViewHolder{
        private RecyclerView mRecyclerView;
        public CategoryRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            mRecyclerView = itemView.findViewById(R.id.category_recycler_view);
        }
        public void bindView(CategoryModel categoryModel, Context context){

        }
    }

    public static class TrendingProductsLabelViewHolder extends RecyclerView.ViewHolder{
        private TextView mLabel;
        public TrendingProductsLabelViewHolder(@NonNull View itemView) {
            super(itemView);
            mLabel = itemView.findViewById(R.id.trending_label);
        }
        public void bindView(){

        }
    }

    public static class TrendingProductsRecyclerViewHolder extends RecyclerView.ViewHolder{
        private RecyclerView mRecyclerView;
        public TrendingProductsRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
        }
        public void bindView(ProductsModel productsModel, Context context) {
            mRecyclerView = itemView.findViewById(R.id.trending_products_recycler_view);
        }
    }


    @Override
    public int getItemViewType(int position) {
       MainParentModel model = getItem(position);
       if (model instanceof CategoryModel)
           return 0;
       else if (model instanceof CategoryLabelModel)
           return 1;
       else if (model instanceof ProductsModel)
           return 2;
       else if (model instanceof TrendingProductsLabelModel)
           return 3;
       return super.getItemViewType(position);
    }
}
