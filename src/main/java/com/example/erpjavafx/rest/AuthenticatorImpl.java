package com.example.erpjavafx.rest;

import com.example.erpjavafx.dto.UserCredentialsDto;

public class AuthenticatorImpl implements Authenticator{

    private static final String LOGIN = "skuser";
    private static final String PASSWORD = "skpassword";
    @Override
    public void authenticate(UserCredentialsDto userCredentialsDto, AuthenticationResultHandler authenticationResultHandler) {
        Runnable authenticationTask = createAuthenticationTask(userCredentialsDto, authenticationResultHandler);
        Thread authenticationThread = new Thread(authenticationTask);
        authenticationThread.setDaemon(true);
        authenticationThread.start();
    }

    private Runnable createAuthenticationTask(UserCredentialsDto userCredentialsDto, AuthenticationResultHandler authenticationResultHandler) {
        return () -> {
            try {
                Thread.sleep(1000);
                boolean authenticated = LOGIN.equals(userCredentialsDto.getLogin()) && PASSWORD.equals(userCredentialsDto.getPassword());
                authenticationResultHandler.handle(authenticated);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
    }
}
