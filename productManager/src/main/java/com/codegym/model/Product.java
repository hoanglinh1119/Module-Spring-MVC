package com.codegym.model;

public class Product {
 private int productID;
 private String productName;
 private  String productCode;
 private int    productPrice;
 public Product(){

 }

    public Product(int productID, String productName, String productCode, int productPrice) {
        this.productID = productID;
        this.productName = productName;
        this.productCode = productCode;
        this.productPrice = productPrice;
    }


    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }
}
