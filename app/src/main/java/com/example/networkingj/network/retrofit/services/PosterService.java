package com.example.networkingj.network.retrofit.services;

import com.example.networkingj.model.Poster;
import com.example.networkingj.model.PosterResp;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface PosterService {
    @Headers(
            "Content-type:application/json"
    )

    @GET("posts")
    Call<ArrayList<PosterResp>> listPost();

    @GET("posts/{id}")
    Call<PosterResp> singlePost(@Path("id") int id);

    @POST("posts")
    Call<PosterResp> createPost(@Body Poster poster);

    @PUT("posts/{id}")
    Call<PosterResp> updatePost(@Path("id") int id, @Body Poster post);

    @DELETE("posts/{id}")
    Call<PosterResp> deletePost(@Path("id") int id);
}
