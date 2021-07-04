package com.example.myappnew.retrofit2;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.PATCH;
import retrofit2.http.Path;

public interface Patch_Update {
    /*
    * UPDATE - Response 200
    * https://reqres.in/api/users/2
    * {
    *     "name": "morpheus",
    *     "job": "zion resident"
    * }
    */
    @PATCH("users/{id}")
    Call<PutUpdate> patchUpdate(@Path("id") Integer id, @Body PostCreate patch);
}
