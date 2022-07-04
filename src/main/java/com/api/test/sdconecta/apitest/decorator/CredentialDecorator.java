package com.api.test.sdconecta.apitest.decorator;

import lombok.Data;

@Data
public class CredentialDecorator {

    private String access_token;

    private String scope;

    private String token_type;

    private Long expires_in;

}
