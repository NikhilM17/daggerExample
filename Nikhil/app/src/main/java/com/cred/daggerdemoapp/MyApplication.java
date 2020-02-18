package com.cred.daggerdemoapp;

import android.app.Application;

import static com.cred.daggerdemoapp.Constants.BASE_URL;

public class MyApplication extends Application {

    private ApiComponent apiComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        apiComponent = DaggerApiComponent.builder()
                .apiModule(new ApiModule(BASE_URL))
                .appModule(new AppModule(this))
                .build();

    }

    public ApiComponent getApiComponent() {
        return apiComponent;
    }
}