package com.TransfertNational.demo.Services.ServicesImpl;

import com.TransfertNational.demo.Services.SalesforceAPIServ;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class SalesforceAPIService implements SalesforceAPIServ {

    @Override
    public AuthenticationResponse login() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();

        params.add("username", "yh.elhachimi@playful-fox-ld5a0w.com");
        params.add("password", "Iym@20302030tQ9rIcVLIXqF2C8zhzRiAcFLp");
        params.add("client_secret", "435AA67761BC05B5D9343E36B988CE5C3FF05CAD8A7E424B394A12D16DC08E52");
        params.add("client_id", "3MVG9I9urWjeUW05uFQmm.7gi_NtBPiFkZug3Ud80K2O6y3JmPbHUzBzqapVoJLbcgoLjv_4hR9K3Wzjf98qg");
        params.add("grant_type", "password");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(params, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity response = restTemplate.postForEntity("https://login.salesforce.com/services/oauth2/token", request, AuthenticationResponse.class);


        System.out.println(response.getBody());
        return (AuthenticationResponse) response.getBody();

    }

    @Override
    public String addtrsData(String accessToken, String instanceUrl,String motif) {

        HttpHeaders headers = new HttpHeaders();
        RestTemplate restTemplate = new RestTemplate();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + accessToken);
        //   Account a = new Account();
        //  a.setName("test spring integration");
        // a.setAccountSite("account site test");
        HttpEntity<String> request = new HttpEntity<String>("{\"name\":\""+motif+"\"}", headers);
        ResponseEntity<String> salesforceTestData = restTemplate.exchange(instanceUrl + "/services/apexrest/updateres", HttpMethod.PUT, request, String.class);
        System.out.println("TOKEN DETAILS :: " + salesforceTestData.getBody());
        return salesforceTestData.getBody().toString();
    }

    
/*
    @Override
    public String updatetrsData(String accessToken, String instanceUrl) {

        HttpHeaders headers = new HttpHeaders();
        RestTemplate restTemplate = new RestTemplate();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.set("Authorization", "Bearer " + accessToken);
        //   Account a = new Account();
        //  a.setName("test spring integration");
        // a.setAccountSite("account site test");
        HttpEntity<String> request = new HttpEntity<String>("Resrvation-0242", headers);
        ResponseEntity<String> salesforceTestData = restTemplate.exchange(instanceUrl + "/services/apexrest/updateres", HttpMethod.PUT, request, String.class);
        System.out.println("TOKEN DETAILS :: " + salesforceTestData.getBody());
        return salesforceTestData.getBody().toString();

        return "";
    }
*/



}