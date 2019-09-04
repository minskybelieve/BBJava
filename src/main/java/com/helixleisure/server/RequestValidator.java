package com.helixleisure.server;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import spark.Request;

public class RequestValidator {

    private static final Logger log = LogManager.getLogger(RequestValidator.class);

    protected static boolean valid(Request req) {
        boolean isvalid = false;
        if (req != null) {
            String contenttype = req.contentType();
            if (contenttype != null) {
                if(contenttype.equals("application/json")) {
                    isvalid = true;
                }
            }
        }

        if (!isvalid) {
            log.error("Request is null or content type is not application/json: " + req.toString());
        }
        return isvalid;
    }
}
