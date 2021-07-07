package com.example.myappnew;

import com.example.myappnew.retrofit2.GetUser;
import com.example.myappnew.retrofit2.PostCreate;
import com.example.myappnew.retrofit2.PostLoginSuc;
import com.example.myappnew.retrofit2.PostRegSuc;
import com.example.myappnew.retrofit2.PutUpdate;
import com.example.myappnew.retrofit2.RegSuc;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitService2 {
    /* BASE_URL2 = "https://reqres.in"
    * get
    * https://reqres.in/api/users?page=2 (Response-200)
    * */
    @GET("/api/users")
    Call<GetUser> getUser(@Query("page") Integer page);

    /**
     *  get
     * https://reqres.in/api/users?delay=3  (Response-200)
     */
    @GET("/api/users")
    Call<GetUser> getDelRes(@Query("delay") Integer delay);

    /**
     * get
     * https://reqres.in/api/users/2 (Response-200)
     * https://reqres.in/api/users/23 (Response-404)
     */
    @GET("/api/users/{id}")
    Call<GetUser> getSinUser(@Path("id") Integer id);

    /**
     * POST
     * https://reqres.in/api/users  (Response-201)
     * {
     *    "name": "morpheus",
     *    "job": "leader"
     * }
     * */
    @POST("/api/users")
    Call<PostCreate> postCreate(@Body PostCreate user);


    /**
     * PUT https://reqres.in/api/users/2  (Response-200)
     * UPDATE
     * {
     *    "name": "morpheus",
     *    "job": "zion resident"
     * }
     * */
    @PUT("/api/users/{id}")
    Call<PutUpdate> putUpdate(@Path("id") Integer id, @Body PostCreate put);


    /**
     * PATCH
     * https://reqres.in/api/users/2 (Response-200)
     * UPDATE
     * {
     *     "name": "morpheus",
     *     "job": "zion resident"
     * }
     */
    @PATCH("/api/users/{id}")
    Call<PutUpdate> patchUpdate(@Path("id") Integer id, @Body PostCreate patch);

    /**
     * DELETE https://reqres.in/api/users/2 (Response-204)
     */
    @DELETE("/api/users/{id}")
    Call<PostCreate> deleteDel(@Path("id") Integer id);


    /**
     * get https://reqres.in/api/unknown (Response-200)
     */
    @GET("/api/unknown")
    Call<GetUser> getListRes();

    /**
     * get https://reqres.in/api/unknown/2  (Response-200)
     * get https://reqres.in/api/unknown/23 (Response-404)
     * SINGLE <RESOURCE>
     * */
    @GET("/api/unknown/{page}")
    Call<GetUser> getSingleRes(@Path("page") Integer page);

    /**
     * POST
     * https://reqres.in/api/register (Response-200)
     * REGISTER - SUCCESSFUL
     * Response 200
     * {
     *   "email": "eve.holt@reqres.in",
     *   "password": "pistol"
     * }
     * REGISTER - UNSUCCESSFUL
     * Response 400
     * {
     *     "email": "sydney@fife"
     * }
     * */
    @POST("/api/register")
    Call<PostRegSuc> postRegSuc(@Body RegSuc post);


     /**
      * POST https://reqres.in/api/login (Response-200)
      * https://reqres.in/api/login (Response-400)
      * LOGIN - SUCCESSFUL - Response 200
      * {
      *   "email": "eve.holt@reqres.in",
      *   "password": "cityslicka"
      *  }
      * LOGIN - UNSUCCESSFUL - Response 400
      * {
      *     "email": "peter@klaven"
      * }
      * */
     @POST("/api/login")
     Call<PostLoginSuc> postLoginSuc(@Body RegSuc post);

}
