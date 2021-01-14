package com.example.status;

public enum HttpStatus {
    OK(200), BAD_REQUEST(400), INTERNAL_SERVER_ERROR(500);
    public int code;

    HttpStatus(int code) {
        this.code = code;
    }
}
