package com.example.myappnew.retrofit2;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Get_DelayedRes {
    /*
    * DELAYED RESPONSE - Response 200
    * https://reqres.in/api/users?delay=3
    * */
    @GET("users")
    Call<GetDelRes> getDelRes(@Query("delay") Integer delay);
}
