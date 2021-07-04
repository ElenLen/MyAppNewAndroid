package com.example.myappnew.retrofit2;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Get_SingleUse {
    /*
    * SINGLE USER - Response 200
    * https://reqres.in/api/users/2
    *
    * SINGLE USER NOT FOUND - Response 404
    * https://reqres.in/api/users/23
    * */

    @GET("users/{id}")
    Call<GetSinUser> getSinUser(@Path("id") Integer id);
}
