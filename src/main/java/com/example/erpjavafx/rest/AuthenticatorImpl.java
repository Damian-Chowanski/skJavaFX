package com.example.erpjavafx.rest;

import com.example.erpjavafx.dto.UserCredentialsDto;

public class AuthenticatorImpl implements Authenticator{

    private static final String LOGIN = "skuser";
    private static final String PASSWORD = "skpassword";
    @Override
    public void authenticate(UserCredentialsDto userCredentialsDto) {
        boolean authenticated = LOGIN.equals(userCredentialsDto.getLogin()) && PASSWORD.equals(userCredentialsDto.getPassword());
        System.out.println("is authenticated?: " + authenticated);
    }
}
