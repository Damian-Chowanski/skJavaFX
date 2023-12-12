package com.example.erpjavafx.rest;

import com.example.erpjavafx.dto.OperatorCredentialsDto;

public class AuthenticatorImpl implements Authenticator{

    @Override
    public void authenticate(OperatorCredentialsDto operatorCredentialsDto, AuthenticationResultHandler authenticationResultHandler) {
        Runnable authenticationTask = createAuthenticationTask(operatorCredentialsDto, authenticationResultHandler);
        Thread authenticationThread = new Thread(authenticationTask);
        authenticationThread.setDaemon(true);
        authenticationThread.start();
    }

    private void procesAuthentication(OperatorCredentialsDto operatorCredentialsDto, AuthenticationResultHandler authenticationResultHandler) {
        return () -> {
            try {
                Thread.sleep(1000);
                boolean authenticated = LOGIN.equals(operatorCredentialsDto.getLogin()) && PASSWORD.equals(operatorCredentialsDto.getPassword());
                authenticationResultHandler.handle(authenticated);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
    }
}
