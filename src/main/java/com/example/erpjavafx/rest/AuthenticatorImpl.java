package com.example.erpjavafx.rest;

import com.example.erpjavafx.dto.OperatorAuthenticationResultDto;
import com.example.erpjavafx.dto.OperatorCredentialsDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class AuthenticatorImpl implements Authenticator{

    private static final String AUTHENTICATION_URL = "http://localhost:8080/verify_operator_credentials";
    private final RestTemplate restTemplate;

    public AuthenticatorImpl(){
        this.restTemplate = new RestTemplate();
    }
    @Override
    public void authenticate(OperatorCredentialsDto operatorCredentialsDto, AuthenticationResultHandler authenticationResultHandler) {
        Runnable authenticationTask = () -> { processAuthentication(operatorCredentialsDto, authenticationResultHandler);
        };
        Thread authenticationThread = new Thread(authenticationTask);
        authenticationThread.setDaemon(true);
        authenticationThread.start();
    }

    private void processAuthentication(OperatorCredentialsDto operatorCredentialsDto, AuthenticationResultHandler authenticationResultHandler) {
        ResponseEntity<OperatorAuthenticationResultDto> responseEntity = restTemplate.postForEntity(AUTHENTICATION_URL, operatorCredentialsDto, OperatorAuthenticationResultDto.class);
        authenticationResultHandler.handle(responseEntity.getBody());
    }
}
