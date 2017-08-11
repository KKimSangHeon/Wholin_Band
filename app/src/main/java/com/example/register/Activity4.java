package com.example.register;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by 상헌 on 2016-07-28.
 */
public class Activity4  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

    }
}