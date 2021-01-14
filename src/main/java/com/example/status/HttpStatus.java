package com.example.status;

public class HttpStatus {
    void OK(200),
    void BAD_REQUEST(400),

    void INTERNAL_SERVER_ERROR(500) {

    }

    int code;

    HttpStatus(int code) {
        this.code = code;
    }
}

