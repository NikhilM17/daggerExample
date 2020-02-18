package com.cred.daggerdemoapp;

import androidx.annotation.NonNull;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

@Singleton
public class ApiManager {

    @Inject
    Retrofit retrofit;

    @Inject
    ApiManager provideApiManager() {
        return new ApiManager();
    }

    public void getHeroes(Retrofit retrofit, final RetrofitListener<List<Hero>> listener) {
        this.retrofit.create(Api.class).getHeroes().enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(@NonNull Call<List<Hero>> call, @NonNull Response<List<Hero>> response) {
                if (response.isSuccessful()) {
                    listener.response(response.body(), null);
                } else {
                    listener.response(null, "Please try again");
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Hero>> call, @NonNull Throwable t) {
                listener.response(null, t.getMessage());
            }
        });
    }


}
