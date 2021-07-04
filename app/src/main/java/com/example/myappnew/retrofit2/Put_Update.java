package com.example.myappnew.retrofit2;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface Put_Update {
    /*
    * UPDATE - Response 200
    * https://reqres.in/api/users/2
    * {
    *    "name": "morpheus",
    *    "job": "zion resident"
    * }
    * */
    @PUT("users/{id}")
    Call<PutUpdate> putUpdate(@Path("id") Integer id, @Body PostCreate put);
}
