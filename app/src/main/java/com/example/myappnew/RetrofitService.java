package com.example.myappnew;

import java.time.Year;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitService {
    /*
    *возвращает государственные праздники из данного года и страны.
    *https://date.nager.at/api/v3/publicholidays/2021/RU
    * GET /api/v3/PublicHolidays/{Year}/{CountryCode}
    * GET /api/v3/PublicHolidays/{Year}/RU
    * будем возвращать правздники за текущий год, только для RU
    * */

    @GET("GET /api/v3/PublicHolidays/{Year}/RU")
    Call<List<Year>> usersYear(@Query("year") Integer year);


}
