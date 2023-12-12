package com.example.erpjavafx.rest;

import com.example.erpjavafx.dto.OperatorCredentialsDto;

public interface Authenticator {
    void authenticate(OperatorCredentialsDto operatorCredentialsDto, AuthenticationResultHandler authenticationResultHandler);

}
