package com.workintech.burgerRestAPI.exceptions;

import org.springframework.http.HttpStatus;

public class BurgerException extends BurgerErrorResponse{
    private HttpStatus status;

    public BurgerException(int status, String message, long timestamp, HttpStatus status1) {
        super(status, message, timestamp);
        this.status = status1;
    }

}
