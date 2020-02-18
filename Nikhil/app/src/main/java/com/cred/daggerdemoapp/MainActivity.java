package com.cred.daggerdemoapp;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    @Inject
    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((MyApplication) getApplication()).getApiComponent().inject(this);

        listView = findViewById(R.id.listView);

    }

    @Override
    protected void onResume() {
        super.onResume();
        getHeroes();
    }

    private void getHeroes() {

        new ApiManager().getHeroes(retrofit, new RetrofitListener<List<Hero>>() {
            @Override
            public void response(List<Hero> heroList, String error) {
                if (!TextUtils.isEmpty(error)) {
                    Toast.makeText(getApplicationContext(), error, Toast.LENGTH_SHORT).show();
                } else {
                    if (heroList != null) {
                        listView.setAdapter(new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, heroList));
                    }
                }
            }
        });

    }
}