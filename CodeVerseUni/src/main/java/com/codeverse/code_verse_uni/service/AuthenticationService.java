package com.codeverse.code_verse_uni.service;

import com.codeverse.code_verse_uni.request.AuthenticateRequest;
import com.codeverse.code_verse_uni.request.RegisterRequest;
import com.codeverse.code_verse_uni.response.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse register(RegisterRequest request);

    AuthenticationResponse authenticate(AuthenticateRequest request);

    AuthenticationResponse registerManager(RegisterRequest request);

    AuthenticationResponse registerAdmin(RegisterRequest request);
}
