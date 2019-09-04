package com.helixleisure.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.helixleisure.entities.ProductsEvent;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class ProductResponseJSON {

    private static final Logger log = LogManager.getLogger(ProductResponseJSON.class);

    public ProductResponseJSON() {

    }

    public String toJSON(ProductsEvent prodResponse) {
        String json = "{}";
        if (prodResponse == null) {
            return json;
        }
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            json = objectMapper.writeValueAsString(prodResponse);
//            objectMapper.writeValue(new File("c://BBTest/GetProduct.json"), bp);
        } catch (Exception e) {
            log.error("", e);
            return json;
        }
        return json;
    }

    public ProductsEvent toObject(String json) {

        if (json == null || json.isEmpty()) {
            return null;
        }

        ObjectMapper mapper = new ObjectMapper();
        ProductsEvent productEvent = null;
        try {
            productEvent = mapper.readValue(json, ProductsEvent.class);
        } catch (Exception ex) {
            log.error("", ex);
            return null;
        }
        return productEvent;
    }

}
