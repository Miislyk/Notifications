package com.miislyk.notifactions;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by luis_gallegos on 29/08/2016.
 */
public class NotificationIdToken extends FirebaseInstanceIdService {

    private static final String TAG = "FIREBASETOKEN";

    @Override
    public void onTokenRefresh() {
        //super.onTokenRefresh();
        String token = FirebaseInstanceId.getInstance().getToken();
        enviarTokenRegistro(token);
    }

    private void enviarTokenRegistro(String token) {

        Log.d(TAG, token);

    }
}
