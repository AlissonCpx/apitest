package com.api.test.sdconecta.apitest.decorator;

import lombok.Data;

@Data
public class UserAcessDecorator {

    private String access_token;

    private String refresh_token;

    private String authorization_status;

}
