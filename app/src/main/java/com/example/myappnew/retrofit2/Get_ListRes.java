package com.example.myappnew.retrofit2;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Get_ListRes {
    /*
    * LIST <RESOURCE> - Response 200
    * https://reqres.in/api/unknown
    * */
    @GET("unknown")
    Call<GetListRes> getListRes();
}
