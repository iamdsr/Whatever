package com.iamdsr.whatever.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iamdsr.whatever.Adapters.CategoryRecyclerAdapter;
import com.iamdsr.whatever.Adapters.TrendingProductsRecyclerAdapter;
import com.iamdsr.whatever.Models.CategoryModel;
import com.iamdsr.whatever.Models.ProductsModel;
import com.iamdsr.whatever.R;
import com.iamdsr.whatever.Utils.RecyclerViewActionsInterface;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements RecyclerViewActionsInterface {

    // WIDGETS
    private View view;

    // LOG TAGS
    private static final String TAG = "HomeFragment";

    // UTILS


    // FIREBASE

    public HomeFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
        // setup widgets

        return view;
    }



    @Override
    public void onItemClick(int position) {

    }
}