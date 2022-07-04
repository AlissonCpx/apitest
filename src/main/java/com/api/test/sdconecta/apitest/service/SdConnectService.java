package com.api.test.sdconecta.apitest.service;

import com.api.test.sdconecta.apitest.decorator.CredentialDecorator;
import com.api.test.sdconecta.apitest.decorator.UserAcessDecorator;
import com.api.test.sdconecta.apitest.model.UserModel;
import com.api.test.sdconecta.apitest.util.Util;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.*;

public class SdConnectService {

    String uri = "https://beta.sdconecta.com";

    public ResponseEntity<CredentialDecorator> authenticateSdConnect() throws IOException {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        Properties prop = Util.getProp();

        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("client_id", prop.getProperty("prop.client_id").toString());
        map.add("client_secret", prop.getProperty("prop.client_secret".toString()));
        map.add("grant_type", prop.getProperty("prop.grant_type".toString()));

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
        ResponseEntity<CredentialDecorator> response = restTemplate.postForEntity(uri + "/oauth2/token", request, CredentialDecorator.class);
        return response;
    }

    public ResponseEntity<UserAcessDecorator> validUser(UserModel user) throws IOException {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        SdConnectService sd = new SdConnectService();
        CredentialDecorator cm = sd.authenticateSdConnect().getBody();

        headers.set("Authorization", cm.getToken_type() + " " + cm.getAccess_token());

        Map<String, String> map = new HashMap<>();
        map.put("email", user.getEmail());
        map.put("name", user.getName());

        HttpEntity<Map> request = new HttpEntity<>(map, headers);


        ResponseEntity<UserAcessDecorator> response = restTemplate.postForEntity(uri + "/api/v2/partners/generate-user-token", request, UserAcessDecorator.class);
        return response;
    }

}
