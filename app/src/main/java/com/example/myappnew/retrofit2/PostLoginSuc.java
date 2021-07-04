package com.example.myappnew.retrofit2;

public class PostLoginSuc {
    /*
    * Response 200
    * {
    *    "token": "QpwL5tke4Pnpja7X4"
    * }
    * */

    private String token;
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "PostLoginSuc{" +
                "token='" + token + '\'' +
                '}';
    }
}
