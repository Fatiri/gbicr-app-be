package com.gbicr.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(value = HttpStatus.OK)
public class SuccessException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public SuccessException(String msg) {
        super(msg);
    }
}
