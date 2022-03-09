package com.iamdsr.whatever.Models;

public class CategoryLabelModel extends MainParentModel{
    private String label;

    public CategoryLabelModel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
