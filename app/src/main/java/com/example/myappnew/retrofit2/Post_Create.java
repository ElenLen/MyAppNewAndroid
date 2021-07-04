package com.example.myappnew.retrofit2;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Post_Create {
    /*
    * CREATE - Response 201
    * https://reqres.in/api/users
    * {
    *    "name": "morpheus",
    *    "job": "leader"
    * }
    * */
    @POST("users")
    Call<PostCreate> postCreate(@Body PostCreate user);
}
