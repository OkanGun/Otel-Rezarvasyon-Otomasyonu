package com.okan.lenovo.otel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.okan.lenovo.otel.R;

public class kapalihavz extends AppCompatActivity {

    Button anasf6;
    Button ackhvz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kapalihavz);

        anasf6=(Button) findViewById(R.id.button22);

        anasf6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ans6=new Intent(getApplicationContext(),Birsayfa.class);
                startActivity(ans6);
            }
        });

        ackhvz=(Button) findViewById(R.id.button23);

        ackhvz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ackhz=new Intent(getApplicationContext(),havzlar.class);
                startActivity(ackhz);
            }
        });
