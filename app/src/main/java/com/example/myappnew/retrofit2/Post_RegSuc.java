package com.example.myappnew.retrofit2;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Post_RegSuc {
    /*
    * REGISTER - SUCCESSFUL - Response 200
    * https://reqres.in/api/register
    * {
    *   "email": "eve.holt@reqres.in",
    *   "password": "pistol"
    * }
    *
    * Response 200
    * {
    *   "id": 4,
    *   "token": "QpwL5tke4Pnpja7X4"
    * }
    * */
    @POST("register")
    Call<PostRegSuc> postRegSuc(@Body RegSuc post);
}
