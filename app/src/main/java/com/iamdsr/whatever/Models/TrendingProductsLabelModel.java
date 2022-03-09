package com.iamdsr.whatever.Models;

public class TrendingProductsLabelModel extends MainParentModel{
    private String label;

    public TrendingProductsLabelModel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
