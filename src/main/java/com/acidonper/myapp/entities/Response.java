package com.acidonper.myapp.entities;

public class Response {

    public String message;
    public Integer code;

    public Response(String message, Integer code) {
        this.message = message;
        this.code = code;
    }
}
