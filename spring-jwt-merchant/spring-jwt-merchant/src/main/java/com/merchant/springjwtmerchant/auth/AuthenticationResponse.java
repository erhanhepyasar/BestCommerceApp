/**
 * @author Neslihan Bozer - 09.2020
 * Merchant application.
 **/
package com.merchant.springjwtmerchant.auth;

public class AuthenticationResponse {

    private final String jwt;

    public AuthenticationResponse(String jwt){
        this.jwt = jwt;
    }

    public String getJwt(){
        return jwt;
    }
}
