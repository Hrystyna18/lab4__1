package com.example.exception;

import com.example.status.HttpStatus;

public class HttpException extends RuntimeException {
    public HttpStatus state;
    public int code;

    public HttpException(HttpStatus s, int c, String message) {
        super(message);
        state = s;
        code = c;
    }
}
