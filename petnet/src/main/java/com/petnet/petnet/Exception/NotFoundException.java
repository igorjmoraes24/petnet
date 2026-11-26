package com.petnet.petnet.Exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String mensage) {
        super(mensage);
    }
}