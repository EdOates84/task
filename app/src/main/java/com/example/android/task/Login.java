package com.example.android.task;

import android.app.Application;

import com.firebase.client.Firebase;

public class Login extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
