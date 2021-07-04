package com.example.myappnew.retrofit2;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Post_LoginSuc {
    /*
    * LOGIN - SUCCESSFUL - Response 200
    * https://reqres.in/api/login
    * {
    *   "email": "eve.holt@reqres.in",
    *   "password": "cityslicka"
    *  }
    *
    * - Response 200
    * {
    *   "token": "QpwL5tke4Pnpja7X4"
    * }
    * */
    @POST("login")
    Call<PostLoginSuc> postLoginSuc(@Body RegSuc post);
}
