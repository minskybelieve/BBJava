package com.helixleisure.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.helixleisure.utils.DateUtils;
import com.helixleisure.utils.IDGenerator;

import java.sql.Timestamp;
import java.util.ArrayList;

public class ProductsEvent {

    private String id;
    private Timestamp timestamp;
    private ArrayList<Product> products;

    public ProductsEvent() {
        id = IDGenerator.UUIDGen();
        timestamp = DateUtils.getCurrentUTC();
        products = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
}
