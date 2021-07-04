package com.example.myappnew.retrofit2;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Path;

public interface Delete_Del {
    /*
    * DELETE - Response 204
    * https://reqres.in/api/users/2
    * */
    @DELETE("users/{id}")
    Call<PostCreate> deleteDel(@Path("id") Integer id);
}
