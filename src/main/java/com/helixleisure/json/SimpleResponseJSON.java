package com.helixleisure.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.helixleisure.entities.ProductsEvent;
import com.helixleisure.entities.SimpleResponse;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class SimpleResponseJSON {

    private static final Logger log = LogManager.getLogger(SimpleResponseJSON.class);

    public SimpleResponseJSON() {

    }

    public String toJSON(SimpleResponse simpleResponse) {
        String json = "{}";
        if (simpleResponse == null) {
            return json;
        }
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            json = objectMapper.writeValueAsString(simpleResponse);
        } catch (Exception e) {
            log.error("", e);
            return json;
        }
        return json;
    }

    public SimpleResponse toObject(String json) {

        if (json == null || json.isEmpty()) {
            return null;
        }

        ObjectMapper mapper = new ObjectMapper();
        SimpleResponse simpleResponse = null;
        try {
            simpleResponse = mapper.readValue(json, SimpleResponse.class);
        } catch (Exception ex) {
            log.error("", ex);
            return simpleResponse;
        }
        return simpleResponse;
    }
}
