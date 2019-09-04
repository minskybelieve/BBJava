package com.helixleisure.entities;

public class SimpleResponse {

    public static final String STATUS_SUCCESS = "Success";
    public static final String STATUS_ERROR = "Error";

    private String status;
    private String description;

    public SimpleResponse() {

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
