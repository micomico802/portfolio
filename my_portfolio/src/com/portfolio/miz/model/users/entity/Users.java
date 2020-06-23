package com.portfolio.miz.model.users.entity;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

public class Users {
    private String loginAddress;
    private String loginPassword;
    private String userName;

    public Users() {

    }

    public Users(HttpServletRequest request) throws UnsupportedEncodingException {

        request.setCharacterEncoding("UTF-8");

        this.loginAddress = request.getParameter("login_address");
        this.loginPassword = request.getParameter("pass");
        this.userName = request.getParameter("name");
    }

    public Users(String userId, String password) throws UnsupportedEncodingException {

        this.loginAddress = userId;
        this.loginPassword = password;

    }

    public String getLoginAddress() {
        return loginAddress;
    }

    public void setLoginAddress(String loginAddress) {
        this.loginAddress = loginAddress;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
