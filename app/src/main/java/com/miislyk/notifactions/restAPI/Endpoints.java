package com.miislyk.notifactions.restAPI;

import com.miislyk.notifactions.restAPI.model.UsuarioResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by lhrat on 01/02/2017.
 */

public interface Endpoints {

    @FormUrlEncoded
    @POST(ConstantesRestApi.KEY_POST_ID_TOKEN)
    Call<UsuarioResponse> registrarTokenId(@Field("token") String token, @Field("animal") String animal);

    @GET(ConstantesRestApi.KEY_TOQUE_ANIMAL)
    Call<UsuarioResponse> toqueAnimal(@Path("id") String id, @Path("animal") String animal);

}
