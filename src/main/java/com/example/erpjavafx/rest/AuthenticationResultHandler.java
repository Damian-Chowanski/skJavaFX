package com.example.erpjavafx.rest;

@FunctionalInterface
public interface AuthenticationResultHandler {

    void handle(boolean authenticationResult);
}
