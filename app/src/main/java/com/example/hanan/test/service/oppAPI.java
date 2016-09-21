package com.example.hanan.test.service;

import com.example.hanan.test.model.Opportunity;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by Hanan on 20/09/16.
 */
public interface oppAPI {
    @GET("/opportunity")
    public void getOppInfo(Callback<List<Opportunity>> response);
}