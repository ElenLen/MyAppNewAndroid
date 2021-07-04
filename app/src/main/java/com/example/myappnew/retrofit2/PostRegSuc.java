package com.example.myappnew.retrofit2;

public class PostRegSuc {
    /*
    * Response 200
    * {
    *   "id": 4,
    *   "token": "QpwL5tke4Pnpja7X4"
    *   }
    * */
    private String id;
    private String token;

    @Override
    public String toString() {
        return "PostRegSuc{" +
                "id='" + id + '\'' +
                ", token='" + token + '\'' +
                '}';
    }

    public PostRegSuc(String id, String token) {
        this.id = id;
        this.token = token;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
