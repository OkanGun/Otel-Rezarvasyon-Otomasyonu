package com.okan.lenovo.otel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class spa extends AppCompatActivity {

    Button anasyf7;
    Button resimlerspa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spa);

        anasyf7=(Button) findViewById(R.id.button24);

        anasyf7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ag7=new Intent(getApplicationContext(),Birsayfa.class);
                startActivity(ag7);
            }
        });


        resimlerspa=(Button) findViewById(R.id.button25);

        resimlerspa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent spares=new Intent(getApplicationContext(),sparesimler.class);
                startActivity(spares);
            }
        });




    }
}
