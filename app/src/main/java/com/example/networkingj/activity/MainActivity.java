package com.example.networkingj.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.networkingj.R;
import com.example.networkingj.model.Poster;
import com.example.networkingj.model.PosterResp;
import com.example.networkingj.network.retrofit.RetrofitHttp;
import com.example.networkingj.network.volley.VolleyHandler;
import com.example.networkingj.network.volley.VolleyHttp;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView tv_home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initViews();
    }

    private void initViews() {
        tv_home = findViewById(R.id.tv_home);
        workWithRetrofit();
//        workWithVolley();
    }

    private void workWithRetrofit() {

        RetrofitHttp.posterService.listPost().enqueue(new Callback<ArrayList<PosterResp>>() {
            @Override
            public void onResponse(Call<ArrayList<PosterResp>> call, Response<ArrayList<PosterResp>> response) {
                Log.d("@@@onResponse", response.body().toString());
                tv_home.setText(response.body().toString());
            }

            @Override
            public void onFailure(Call<ArrayList<PosterResp>> call, Throwable t) {
                Log.d("@@@onFailure", t.toString());
            }
        });

        Poster poster = new Poster(1, 1, "PDP", "Online");
        RetrofitHttp.posterService.createPost(poster).enqueue(new Callback<PosterResp>() {
            @Override
            public void onResponse(Call<PosterResp> call, Response<PosterResp> response) {
                Log.d("@@@onResponse", response.body().toString());
            }

            @Override
            public void onFailure(Call<PosterResp> call, Throwable t) {
                Log.d("@@@onFailure", t.toString());
            }
        });

        RetrofitHttp.posterService.updatePost(poster.getId(), poster).enqueue(new Callback<PosterResp>() {
            @Override
            public void onResponse(Call<PosterResp> call, Response<PosterResp> response) {
                Log.d("@@@onResponse", response.body().toString());
            }

            @Override
            public void onFailure(Call<PosterResp> call, Throwable t) {
                Log.d("@@@onFailure", t.toString());
            }
        });

        RetrofitHttp.posterService.deletePost(poster.getId()).enqueue(new Callback<PosterResp>() {
            @Override
            public void onResponse(Call<PosterResp> call, Response<PosterResp> response) {
                Log.d("@@@onResponse", response.body().toString());
            }

            @Override
            public void onFailure(Call<PosterResp> call, Throwable t) {
                Log.d("@@@onFailure", t.toString());
            }
        });
    }

    private void workWithVolley() {
        VolleyHttp.get(VolleyHttp.API_LIST_POST, VolleyHttp.paramsEmpty(), new VolleyHandler() {
            @Override
            public void onSuccess(String response) {
                Log.d("@@@onResponse ", response);
                tv_home.setText(response);
            }

            @Override
            public void onError(String error) {
                Log.d("@@@onResponse ", error);
            }
        });

        Poster poster = new Poster(1, 1, "PDP", "Online");
        VolleyHttp.post(VolleyHttp.API_CREATE_POST, VolleyHttp.paramsCreate(poster), new VolleyHandler() {
            @Override
            public void onSuccess(String response) {
                Log.d("@@@onResponse ", response);
            }

            @Override
            public void onError(String error) {
                Log.d("@@@onErrorResponse ", error);
            }
        });

        VolleyHttp.put(VolleyHttp.API_UPDATE_POST + poster.getId(), VolleyHttp.paramsUpdate(poster), new VolleyHandler() {
            @Override
            public void onSuccess(String response) {
                Log.d("@@@onResponse ", response);
            }

            @Override
            public void onError(String error) {
                Log.d("@@@onErrorResponse ", error);
            }
        });

        VolleyHttp.del(VolleyHttp.API_DELETE_POST + poster.getId(), new VolleyHandler() {
            @Override
            public void onSuccess(String response) {
                Log.d("@@@onResponse ", response);
            }

            @Override
            public void onError(String error) {
                Log.d("@@@onErrorResponse ", error);
            }
        });

    }
}