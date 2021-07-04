package com.example.myappnew.retrofit2;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Get_SingleRes {
    /*
    * SINGLE <RESOURCE> - Response 200
    * https://reqres.in/api/unknown/2
    * */

    @GET("unknown/{page}")
    Call<GetSingleRes> getSingleRes(@Path("page") Integer page);
}
