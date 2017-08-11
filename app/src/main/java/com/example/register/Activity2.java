package com.example.register;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

/**
 * Created by 상헌 on 2016-07-28.
 */
public class Activity2 extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        Spinner spinner=(Spinner)findViewById(R.id.spinner1);
        ArrayAdapter adapter1=ArrayAdapter.createFromResource(this,R.array.countryarr,R.layout.support_simple_spinner_dropdown_item);

        adapter1.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter1);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        ImageButton button1=(ImageButton)findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(Activity2.this, Activity3.class);
                startActivity(intent);

            }
        });
    }
    }
