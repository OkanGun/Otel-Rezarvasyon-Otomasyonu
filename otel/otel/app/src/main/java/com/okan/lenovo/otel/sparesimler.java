package com.okan.lenovo.otel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class sparesimler extends AppCompatActivity {

    Button ansayfa8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sparesimler);

        ansayfa8=(Button) findViewById(R.id.button31);

        ansayfa8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ag8=new Intent(getApplicationContext(),Birsayfa.class);
                startActivity(ag8);
            }
        });




    }
}
