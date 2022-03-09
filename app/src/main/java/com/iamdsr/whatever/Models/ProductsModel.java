package com.iamdsr.whatever.Models;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import java.util.Objects;

public class ProductsModel extends MainParentModel {
    private String productID, productName, productImage, productPrice, productRating, productSellerID, productSellerName;

    public ProductsModel(String productID, String productName, String productImage, String productPrice, String productRating, String productSellerID, String productSellerName) {
        this.productID = productID;
        this.productName = productName;
        this.productImage = productImage;
        this.productPrice = productPrice;
        this.productRating = productRating;
        this.productSellerID = productSellerID;
        this.productSellerName = productSellerName;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductRating() {
        return productRating;
    }

    public void setProductRating(String productRating) {
        this.productRating = productRating;
    }

    public String getProductSellerID() {
        return productSellerID;
    }

    public void setProductSellerID(String productSellerID) {
        this.productSellerID = productSellerID;
    }

    public String getProductSellerName() {
        return productSellerName;
    }

    public void setProductSellerName(String productSellerName) {
        this.productSellerName = productSellerName;
    }

    @Override
    public String toString() {
        return "TrendingProductsModel{" +
                "productID='" + productID + '\'' +
                ", productName='" + productName + '\'' +
                ", productImage='" + productImage + '\'' +
                ", productPrice='" + productPrice + '\'' +
                ", productRating='" + productRating + '\'' +
                ", productSellerID='" + productSellerID + '\'' +
                ", productSellerName='" + productSellerName + '\'' +
                '}';
    }

}

