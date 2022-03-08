package com.example.networkingj.model;

import com.google.gson.annotations.SerializedName;

public class PosterResp {
    @SerializedName("userId")
    int userId;
    @SerializedName("id")
    int id;
    @SerializedName("title")
    String title;
    @SerializedName("body")
    String body;
}
