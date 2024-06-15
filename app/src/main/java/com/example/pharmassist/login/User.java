package com.example.pharmassist.login;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("response")
    private String Response;
    @SerializedName("id")
    private String id;

    public String getResponse() {
        return Response;
    }

    public String getId() {
        return id;
    }
}
