package com.miislyk.notifactions.restAPI.adapter;

import com.miislyk.notifactions.restAPI.ConstantesRestApi;
import com.miislyk.notifactions.restAPI.Endpoints;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lhrat on 02/02/2017.
 */

public class RestApiAdapter {

    public Endpoints establecerConexionRestApi() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(Endpoints.class);

    };

}
