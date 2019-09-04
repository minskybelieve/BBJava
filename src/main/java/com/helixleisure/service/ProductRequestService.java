package com.helixleisure.service;

import com.helixleisure.dao.ProductsDAO;
import com.helixleisure.entities.Product;
import com.helixleisure.entities.ProductsEvent;
import com.helixleisure.entities.SimpleResponse;
import com.helixleisure.json.ProductResponseJSON;
import com.helixleisure.json.SimpleResponseJSON;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class ProductRequestService implements IProductRequestService {

    private static final Logger log = LogManager.getLogger(ProductRequestService.class);

    private ProductsDAO dao;

    @Override
    public String getProducts() {

        dao = new ProductsDAO();
        ArrayList<Product> allProducts = dao.getProducts();

        String json = "";
        SimpleResponse simpleResponse = new SimpleResponse();
        if(allProducts == null) {
            simpleResponse.setStatus(SimpleResponse.STATUS_ERROR);
            SimpleResponseJSON converter = new SimpleResponseJSON();
            json = converter.toJSON(simpleResponse);
        } else {
            ProductsEvent productResponse = new ProductsEvent();
            productResponse.setProducts(allProducts);

            ProductResponseJSON prj = new ProductResponseJSON();
            json = prj.toJSON(productResponse);
        }
        return json;
    }

    @Override
    public String storeProducts(String jsonRequest) {

        boolean success = false;
        ProductResponseJSON prj = new ProductResponseJSON();
        ProductsEvent event = prj.toObject(jsonRequest);
        if (event != null) {
            ArrayList<Product> productsToStore = event.getProducts();
            if(productsToStore != null) {
                dao = new ProductsDAO();
                success = dao.storeProducts(productsToStore);
            }
        }

        SimpleResponse simpleResponse = new SimpleResponse();
        if(!success) {
            simpleResponse.setStatus(SimpleResponse.STATUS_ERROR);
        } else {
            simpleResponse.setStatus(SimpleResponse.STATUS_SUCCESS);
        }

        SimpleResponseJSON converter = new SimpleResponseJSON();
        String result = converter.toJSON(simpleResponse);

        return result;
    }
}
