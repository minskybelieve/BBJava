package com.helixleisure.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.helixleisure.entities.Product;
import com.helixleisure.entities.ProductsEvent;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;

public class JSONTest {

    private static final Logger log = LogManager.getLogger(JSONTest.class);

    public JSONTest() {

    }

    public void testToObject(String json) {
        ObjectMapper mapper = new ObjectMapper();
        ProductsEvent productEvent = null;
        try {
            productEvent = mapper.readValue(json, ProductsEvent.class);
        } catch (Exception e) {
            log.error("", e);
        }
        log.debug(productEvent.getId());
    }

    public String testToString() {
        ObjectMapper objectMapper = new ObjectMapper();
        ProductsEvent bp = new ProductsEvent();

        ArrayList<Product> products = new ArrayList<Product>();
        products.add(new Product());
        bp.setProducts(products);

        String js = "";
        try {
            js = objectMapper.writeValueAsString(bp);
            log.debug(js);
//            objectMapper.writeValue(new File("c://BBTest/GetProduct.json"), bp);
            log.debug("Success");
        } catch (Exception e) {
            log.error("", e);
            return js;
        }
        return js;
    }

    public static void main(String[] args) {
        JSONTest test = new JSONTest();
//        String json = test.testToString();
//        log.debug(json);
        test.testToObject(null);
    }
}
