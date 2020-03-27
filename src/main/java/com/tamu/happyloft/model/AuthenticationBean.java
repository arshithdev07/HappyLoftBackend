package com.tamu.happyloft.model;

/**
 * Created by arshi on 3/26/2020.
 */

public class AuthenticationBean {

    private String message;

    public AuthenticationBean(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}