package com.example.myappnew.retrofit2;

public class RegSuc {
    /*
    * REGISTER - SUCCESSFUL - Response 200
        https://reqres.in/api/register
    {
        "email": "eve.holt@reqres.in",
        "password": "pistol"
    }
    */
    private String email;
    private String password;

    public RegSuc(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "RegSuc{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
