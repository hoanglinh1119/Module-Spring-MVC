package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private static Map<Integer,Product> products;
    static {
        products=new HashMap<>();
        products.put(1,new Product(1,"DT Iphone","iphone 5",15000000));
        products.put(2,new Product(2,"DT Samsung","Sam sung",16500000));
        products.put(3,new Product(3,"Laptop DELL","DELL",19500000));
        products.put(4,new Product(4,"MacBook","Apple",12500000));

    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getProductID(),product);

    }

    @Override
    public Product findById(int productID) {
        return products.get(productID);
    }

    @Override
    public void update(int productID, Product product) {
        products.put(productID,product);
    }

    @Override
    public void remove(int productID) {
     products.remove(productID);
    }
}
