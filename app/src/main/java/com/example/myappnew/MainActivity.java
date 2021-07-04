package com.example.myappnew;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.myappnew.retrofit2.Delete_Del;
import com.example.myappnew.retrofit2.GetDelRes;
import com.example.myappnew.retrofit2.GetListRes;
import com.example.myappnew.retrofit2.GetSinUser;
import com.example.myappnew.retrofit2.GetSingleRes;
import com.example.myappnew.retrofit2.GetUser;
import com.example.myappnew.retrofit2.Get_DelayedRes;
import com.example.myappnew.retrofit2.Get_ListRes;
import com.example.myappnew.retrofit2.Get_ListUse;
import com.example.myappnew.retrofit2.Get_SingleRes;
import com.example.myappnew.retrofit2.Get_SingleUse;
import com.example.myappnew.retrofit2.Patch_Update;
import com.example.myappnew.retrofit2.PostCreate;
import com.example.myappnew.retrofit2.PostLoginSuc;
import com.example.myappnew.retrofit2.PostRegSuc;
import com.example.myappnew.retrofit2.Post_Create;
import com.example.myappnew.retrofit2.Post_LoginSuc;
import com.example.myappnew.retrofit2.Post_RegSuc;
import com.example.myappnew.retrofit2.PutUpdate;
import com.example.myappnew.retrofit2.Put_Update;
import com.example.myappnew.retrofit2.RegSuc;
import com.google.gson.Gson;

import java.time.Year;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRetrofit();
        reqresRetrofit();
    }
    //Неделя
    public void sendWeek(View view) {
        Intent intent = new Intent(this, Activity_week.class);
        startActivity(intent);
    }

    //Календарь
    public void sendCalendar(View view) {
        Intent intent = new Intent(this, Activity_calendar.class);
        startActivity(intent);
    }

    //Трекер
    public void sendTrek(View view) {
        Intent intent = new Intent(this, Activity_trek.class);
        startActivity(intent);
    }

    /* Ретрофит1 - использ в проекте
    * API - календарь празников
    */
    private void initRetrofit() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new IntEx())
                .build();

        Retrofit retrofit = (new Retrofit.Builder())
                /* Базовая часть адреса */
                .baseUrl("https://date.nager.at/")
                /* Конвертер, необходимый для преобразования JSON'а в объекты */
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(client)
                .build();

        RetrofitService service = retrofit.create(RetrofitService.class);

        service.usersYear(2021).enqueue(new Callback<List<Year>>() {
            /*проверяем на null данные, которые пришли */
            @Override
            public void onResponse(Call<List<Year>> call, Response<List<Year>> response) {
                response.body();
                Log.d(getClass().toString(),"RetrofitService - very good!");
            }

            /*если произошла ошибка*/
            @Override
            public void onFailure(Call<List<Year>> call, Throwable t) {
                Log.d(getClass().toString(), t.getMessage());
                Log.d(getClass().toString(),"RetrofitService - ERROR!");
            }
        });
    }



    /******************************************
    * Ретрофит2 - для теста
    * https://reqres.in/
    */
    private void reqresRetrofit() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new IntEx())
                .build();

        Retrofit retrofit_req = (new Retrofit.Builder())
                /* Базовая часть адреса */
                .baseUrl("https://reqres.in/api/")
                /* Конвертер, необходимый для преобразования JSON'а в объекты */
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(client)
                .build();

        /*****************
        ****Get_ListUse***
        *  LIST USERS - Response 200
        * */
        Get_ListUse service1 = retrofit_req.create(Get_ListUse.class);
        service1.getUser(2).enqueue(new Callback<GetUser>() {
            @Override
            public void onResponse(Call<GetUser> call, Response<GetUser> response) {
                response.body();
                if (response.code() == 200) {
                    Log.d(getClass().toString(),"******* Get_ListUse - Response 200 *******");
                }
                else {
                Log.d(getClass().toString(),"Get_ListUse - very good!");}
            }

            @Override
            public void onFailure(Call<GetUser> call, Throwable t) {
                Log.d(getClass().toString(), t.getMessage());
                Log.d(getClass().toString(),"Get_ListUse - ERROR!");
            }
        });


        /*******************
         *** Get_SingleUse ***
         * SINGLE USER - Response 200
         * */
        Get_SingleUse service2 = retrofit_req.create(Get_SingleUse.class);
        service2.getSinUser(2).enqueue(new Callback<GetSinUser>() {
            @Override
            public void onResponse(Call<GetSinUser> call, Response<GetSinUser> response) {
                response.body();
                if (response.code() == 200) {
                    Log.d(getClass().toString(),"******* Get_SingleUse - Response 200 *******");
                }
                else {
                    Log.d(getClass().toString(),"Get_SingleUse - very good!");}
            }

            @Override
            public void onFailure(Call<GetSinUser> call, Throwable t) {
                Log.d(getClass().toString(), t.getMessage());
                Log.d(getClass().toString(),"Get_SingleUse - ERROR!");
            }
        });

         /********************************
          * *** Get_SingleUse_NotFound ***
         * SINGLE USER NOT FOUND - Response 404
         * */
        service2.getSinUser(23).enqueue(new Callback<GetSinUser>() {
            @Override
            public void onResponse(Call<GetSinUser> call, Response<GetSinUser> response) {
                response.body();
                if (response.code() == 404) {
                    Log.d(getClass().toString(),"******* Get_SingleUse_NotFound - Response 404 *******");
                }
                else {
                    Log.d(getClass().toString(),"Get_SingleUse_NotFound - very good!");}
            }

            @Override
            public void onFailure(Call<GetSinUser> call, Throwable t) {
                Log.d(getClass().toString(), t.getMessage());
                Log.d(getClass().toString(),"Get_SingleUse_NotFound - ERROR!");
            }
        });


        /******************
        *** Get_ListRes ***
        * LIST <RESOURCE> - Response 200
        * */
        Get_ListRes service3 = retrofit_req.create(Get_ListRes.class);
        service3.getListRes().enqueue(new Callback<GetListRes>() {
            @Override
            public void onResponse(Call<GetListRes> call, Response<GetListRes> response) {
                response.body();
                if (response.code() == 200) {
                    Log.d(getClass().toString(),"******* Get_ListRes - Response 200 *******");
                }
                else {
                    Log.d(getClass().toString(),"Get_ListRes - very good!");}
            }

            @Override
            public void onFailure(Call<GetListRes> call, Throwable t) {
                Log.d(getClass().toString(), t.getMessage());
                Log.d(getClass().toString(),"Get_ListRes - ERROR!");
            }
        });


        /*********************
         *** Get_SingleRes ***
         * SINGLE <RESOURCE> - Response 200
         * */
        Get_SingleRes service4 = retrofit_req.create(Get_SingleRes.class);
        service4.getSingleRes(2).enqueue(new Callback<GetSingleRes>() {
            @Override
            public void onResponse(Call<GetSingleRes> call, Response<GetSingleRes> response) {
                response.body();
                if (response.code() == 200) {
                    Log.d(getClass().toString(),"******* Get_SingleRes - Response 200 *******");
                }
                else {
                    Log.d(getClass().toString(),"Get_SingleRes - very good!");}
            }

            @Override
            public void onFailure(Call<GetSingleRes> call, Throwable t) {
                Log.d(getClass().toString(), t.getMessage());
                Log.d(getClass().toString(),"Get_SingleRes - ERROR!");
            }
        });

        /*** Get_SingleRes_NotFound***
        * SINGLE <RESOURCE> NOT FOUND - Response 404
        * */
        service4.getSingleRes(23).enqueue(new Callback<GetSingleRes>() {
            @Override
            public void onResponse(Call<GetSingleRes> call, Response<GetSingleRes> response) {
                response.body();
                if (response.code() == 404) {
                    Log.d(getClass().toString(),"******* Get_SingleRes_NotFound - Response 404 *******");
                }
                else {
                    Log.d(getClass().toString(),"Get_SingleRes_NotFound - very good!");}
            }

            @Override
            public void onFailure(Call<GetSingleRes> call, Throwable t) {
                Log.d(getClass().toString(), t.getMessage());
                Log.d(getClass().toString(),"Get_SingleRes_NotFound - ERROR!");
            }
        });


        /*********************
        *** Get_DelayedRes ***
         * DELAYED RESPONSE - Response 200
         * */
        Get_DelayedRes service5 = retrofit_req.create(Get_DelayedRes.class);
        service5.getDelRes(3).enqueue(new Callback<GetDelRes>() {
            @Override
            public void onResponse(Call<GetDelRes> call, Response<GetDelRes> response) {
                response.body();
                if (response.code() == 200) {
                    Log.d(getClass().toString(),"******* Get_DelayedRes - Response 200 *******");
                }
                else {
                    Log.d(getClass().toString(),"Get_DelayedRes - very good!");}
            }

            @Override
            public void onFailure(Call<GetDelRes> call, Throwable t) {
                Log.d(getClass().toString(), t.getMessage());
                Log.d(getClass().toString(),"Get_DelayedRes - ERROR!");
            }
        });


        /****************
        *** Post_Create ***
        * CREATE - Response 201
        * */
        Post_Create service6 = retrofit_req.create(Post_Create.class);
        service6.postCreate(new PostCreate("morpheus", "leader")).enqueue(new Callback<PostCreate>() {
            @Override
            public void onResponse(Call<PostCreate> call, Response<PostCreate> response) {
                response.body();
                if (response.code() == 201) {
                    Log.d(getClass().toString(),"******* Post_Create - Response 201 *******");
                }
                else {
                    Log.d(getClass().toString(),"Post_Create - very good!");}
            }

            @Override
            public void onFailure(Call<PostCreate> call, Throwable t) {
                Log.d(getClass().toString(), t.getMessage());
                Log.d(getClass().toString(),"Post_Create - ERROR!");
            }
        });

        /*************
         *** Post_RegSuc ***
        * REGISTER - SUCCESSFUL - Response 200
        */
        Post_RegSuc service7 = retrofit_req.create(Post_RegSuc.class);
        service7.postRegSuc(new RegSuc("eve.holt@reqres.in", "pistol")).enqueue(new Callback<PostRegSuc>() {
            @Override
            public void onResponse(Call<PostRegSuc> call, Response<PostRegSuc> response) {
                response.body();
                if (response.code() == 200) {
                    Log.d(getClass().toString(),"******* Post_RegSuc - Response 200 *******");
                }
                else {
                    Log.d(getClass().toString(),"Post_RegSuc - very good!");}
            }

            @Override
            public void onFailure(Call<PostRegSuc> call, Throwable t) {
                Log.d(getClass().toString(), t.getMessage());
                Log.d(getClass().toString(),"Post_RegSuc - ERROR!");
            }
        });

        /*** Post_RegUnSuc ***
        * REGISTER - UNSUCCESSFUL - Response 400
        * */
        service7.postRegSuc(new RegSuc("sydney@fife", null)).enqueue(new Callback<PostRegSuc>() {
            @Override
            public void onResponse(Call<PostRegSuc> call, Response<PostRegSuc> response) {
                response.body();
                if (response.code() == 400) {
                    Log.d(getClass().toString(),"******* Post_RegUnSuc - Response 400 *******");
                }
                else {
                    Log.d(getClass().toString(),"Post_RegUnSuc - very good!");}
            }

            @Override
            public void onFailure(Call<PostRegSuc> call, Throwable t) {
                Log.d(getClass().toString(), t.getMessage());
                Log.d(getClass().toString(),"Post_RegUnSuc - ERROR!");
            }
        });


        /*******************
         *** Post_LoginSuc ***
        * LOGIN - SUCCESSFUL - Response 200
        * */
        Post_LoginSuc service8 = retrofit_req.create(Post_LoginSuc.class);
        service8.postLoginSuc(new RegSuc("eve.holt@reqres.in", "cityslicka")).enqueue(new Callback<PostLoginSuc>() {
            @Override
            public void onResponse(Call<PostLoginSuc> call, Response<PostLoginSuc> response) {
                response.body();
                if (response.code() == 200) {
                    Log.d(getClass().toString(),"******* Post_LoginSuc - Response 200 *******");
                }
                else {
                    Log.d(getClass().toString(),"Post_LoginSuc - very good!");}
            }

            @Override
            public void onFailure(Call<PostLoginSuc> call, Throwable t) {
                Log.d(getClass().toString(), t.getMessage());
                Log.d(getClass().toString(),"Post_LoginSuc - ERROR!");
            }
        });

        /*** Post_LoginUnSuc ***
        * LOGIN - UNSUCCESSFUL - Response 400
        * */
        service8.postLoginSuc(new RegSuc("peter@klaven", null)).enqueue(new Callback<PostLoginSuc>() {
            @Override
            public void onResponse(Call<PostLoginSuc> call, Response<PostLoginSuc> response) {
                response.body();
                if (response.code() == 400) {
                    Log.d(getClass().toString(),"******* Post_LoginUnSuc - Response 400 *******");
                }
                else {
                    Log.d(getClass().toString(),"Post_LoginUnSuc - very good!");}
            }

            @Override
            public void onFailure(Call<PostLoginSuc> call, Throwable t) {
                Log.d(getClass().toString(), t.getMessage());
                Log.d(getClass().toString(),"Post_LoginUnSuc - ERROR!");
            }
        });


        /*********************
         *** Put_Update ***
        * UPDATE - Response 200
        * */
        Put_Update service9 = retrofit_req.create(Put_Update.class);
        service9.putUpdate(2, new PostCreate("morpheus", "zion resident")).enqueue(new Callback<PutUpdate>() {
            @Override
            public void onResponse(Call<PutUpdate> call, Response<PutUpdate> response) {
                response.body();
                if (response.code() == 200) {
                    Log.d(getClass().toString(),"******* Put_Update - Response 200 *******");
                }
                else {
                    Log.d(getClass().toString(),"Put_Update - very good!");}
            }

            @Override
            public void onFailure(Call<PutUpdate> call, Throwable t) {
                Log.d(getClass().toString(), t.getMessage());
                Log.d(getClass().toString(),"Put_Update - ERROR!");
            }
        });


        /*******************
         *** Patch_Update ***
         * UPDATE - Response 200
         */
        Patch_Update service10 = retrofit_req.create(Patch_Update.class);
        service10.patchUpdate(2, new PostCreate("morpheus", "zion resident")).enqueue(new Callback<PutUpdate>() {
            @Override
            public void onResponse(Call<PutUpdate> call, Response<PutUpdate> response) {
                response.body();
                if (response.code() == 200) {
                    Log.d(getClass().toString(),"******* Patch_Update - Response 200 *******");
                }
                else {
                    Log.d(getClass().toString(),"Patch_Update - very good!");}
            }

            @Override
            public void onFailure(Call<PutUpdate> call, Throwable t) {
                Log.d(getClass().toString(), t.getMessage());
                Log.d(getClass().toString(),"Patch_Update - ERROR!");
            }
        });

        /*********************
         *** Delete_Del ***
        * DELETE - Response 204
        * */
        Delete_Del service11 = retrofit_req.create(Delete_Del.class);
        service11.deleteDel(2).enqueue(new Callback<PostCreate>() {
            @Override
            public void onResponse(Call<PostCreate> call, Response<PostCreate> response) {
                response.body();
                if (response.code() == 204) {
                    Log.d(getClass().toString(),"******* Delete_Del - Response 204 *******");
                }
                else {
                    Log.d(getClass().toString(),"Delete_Del - very good!");}
            }

            @Override
            public void onFailure(Call<PostCreate> call, Throwable t) {
                Log.d(getClass().toString(), t.getMessage());
                Log.d(getClass().toString(),"Delete_Del - ERROR!");
            }
        });




    }

}