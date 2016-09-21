package com.example.hanan.test.service;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by Hanan on 21/09/16.
 */
public interface registerAPI {
    @FormUrlEncoded
    @POST("/Volunteer/register")
    public void insertUser(
            @Field("name") String name,
            @Field("email") String email,
            @Field("password") String password,
            @Field("DOB") String DOB,
            @Field("gender") String gender,
            @Field("number") String number,
            @Field("city") String city,
            Callback<Response> callback);
}