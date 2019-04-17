package com.androidproject;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class IntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder().name("myrealm.realm").build();
        Realm.setDefaultConfiguration(config);

        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        }, 2000);

    }
}
