package com.iamdsr.whatever.Models;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import java.util.Objects;

public class CategoryModel extends MainParentModel {
    private String CategoryID, CategoryImage, CategoryName;
    public CategoryModel(){

    }
    public CategoryModel(String categoryID, String categoryImage, String categoryName) {
        CategoryID = categoryID;
        CategoryImage = categoryImage;
        CategoryName = categoryName;
    }

    public String getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(String categoryID) {
        CategoryID = categoryID;
    }

    public String getCategoryImage() {
        return CategoryImage;
    }

    public void setCategoryImage(String categoryImage) {
        CategoryImage = categoryImage;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }

    @Override
    public String toString() {
        return "CategoryModel{" +
                "CategoryID='" + CategoryID + '\'' +
                ", CategoryImage='" + CategoryImage + '\'' +
                ", CategoryName='" + CategoryName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryModel that = (CategoryModel) o;
        return CategoryID.equals(that.CategoryID) && CategoryImage.equals(that.CategoryImage) && CategoryName.equals(that.CategoryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CategoryID, CategoryImage, CategoryName);
    }
}
