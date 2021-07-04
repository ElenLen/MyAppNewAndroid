package com.example.myappnew.retrofit2;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Get_ListUse {
    /*
    *  LIST USERS - Response 200
    *  https://reqres.in/api/users?page=2
    * */
    @GET("users")
    Call<GetUser> getUser(@Query("page") Integer page);
}
