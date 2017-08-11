package com.example.register;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by 상헌 on 2016-07-28.
 */
public class Activity3 extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        ImageButton button1=(ImageButton)findViewById(R.id.button3);
        button1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(Activity3.this, Activity4.class);
                startActivity(intent);

            }
        });
    }
}
