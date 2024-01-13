package com.TransfertNational.demo.Services;

import com.TransfertNational.demo.Services.ServicesImpl.AuthenticationResponse;

public interface SalesforceAPIServ {

    public AuthenticationResponse login();
    public String addtrsData(String accessToken, String instanceUrl,String motif);

}
