package com.example.erpjavafx.rest;

import com.example.erpjavafx.dto.UserCredentialsDto;

public interface Authenticator {
    void authenticate(UserCredentialsDto userCredentialsDto);
}
