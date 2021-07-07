package com.example.myappnew;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitService {
    /*
    *возвращает государственные праздники из заданного года и страны.
    *https://date.nager.at/api/v3/publicholidays/2021/RU
    * GET
    * /api/v3/PublicHolidays/{Year}/{CountryCode}
    * GET
    * /api/v3/PublicHolidays/{Year}/RU
    * будем возвращать правздники за текущий год, только для RU
    * */
    @GET("/api/v3/publicholidays/{year}/{country}")
    Call<List<UsersYear>> load(@Path("year") String year, @Path("country") String country);


}
