package com.miislyk.notifactions;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.firebase.iid.FirebaseInstanceId;
import com.miislyk.notifactions.restAPI.Endpoints;
import com.miislyk.notifactions.restAPI.adapter.RestApiAdapter;
import com.miislyk.notifactions.restAPI.model.UsuarioResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String ANIMAL_EMISOR = "perro";
    private static final String ANIMAL_RECEPTOR = "gato";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void enviarToken(View v) {

        String token = FirebaseInstanceId.getInstance().getToken();
       // Log.d("TOKEN", token);
        enviarTokenRegistro(token);

        //Intent i = new Intent(this, MainActivity.class);
        //PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, i, PendingIntent.FLAG_ONE_SHOT);

        //Uri sonido = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        /*NotificationCompat.Builder notification = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.guest_male_48)
                .setContentTitle("Notificacion")
                .setContentText("Hola Mundo")
                .setSound(sonido)7
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);*/

        //NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        //notificationManager.notify(0, notificacion.build());


    }

    //enviar registro al servidor
    private void enviarTokenRegistro(String token) {

//        Log.d("TOKEN", token);
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Endpoints endpoints = restApiAdapter.establecerConexionRestApi();
        Call<UsuarioResponse> usuarioResponseCall = endpoints.registrarTokenId(token, ANIMAL_EMISOR);

        usuarioResponseCall.enqueue(new Callback<UsuarioResponse>() {
            @Override
            public void onResponse(Call<UsuarioResponse> call, Response<UsuarioResponse> response) {
                UsuarioResponse usuarioResponse = response.body();
                //Log.d("ID_FIREBASE", usuarioResponse.getId());
                //Log.d("USUARIO_FIREBASE", usuarioResponse.getToken());
            }

            @Override
            public void onFailure(Call<UsuarioResponse> call, Throwable t) {

            }
        });

    }

    public void toqueAnimal(View v) {
        Log.d("TOQUE_ANIMAL", "true");
        UsuarioResponse usuarioResponse = new UsuarioResponse("-KcZsA48sko5O1aS7ZDX","123", ANIMAL_RECEPTOR);

        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Endpoints endpoints = restApiAdapter.establecerConexionRestApi();
        Call<UsuarioResponse> usuarioResponseCall = endpoints.toqueAnimal(usuarioResponse.getId(), usuarioResponse.getAnimal());
        usuarioResponseCall.enqueue(new Callback<UsuarioResponse>() {
            @Override
            public void onResponse(Call<UsuarioResponse> call, Response<UsuarioResponse> response) {
                UsuarioResponse usuarioResponse1 = response.body();
                Log.d("ID_FIREBASE", usuarioResponse1.getId());
                Log.d("TOKEN_FIREBASE", usuarioResponse1.getToken());
                Log.d("ANIMAL_FIREBASE", usuarioResponse1.getAnimal());

            }

            @Override
            public void onFailure(Call<UsuarioResponse> call, Throwable t) {

            }
        });

    }
}
