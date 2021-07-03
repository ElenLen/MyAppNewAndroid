package com.example.myappnew;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

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
    public static final String EXTRA_MESSAGE = "com.example.myappnew.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRetrofit();
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

    //Ретрофит1 - использ в проекте
    // API - календарь празников
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
                Log.d(getClass().toString(),"very good!");
            }

            /*если произошла ошибка*/
            @Override
            public void onFailure(Call<List<Year>> call, Throwable t) {
                Log.d(getClass().toString(), t.getMessage());
            }
        });
    }
}