package com.okan.lenovo.otel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.okan.lenovo.otel.R;

public class havzlar extends AppCompatActivity {

    Button anasayfa5;
    Button kapalıhvz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_havzlar);


        anasayfa5=(Button) findViewById(R.id.button20);

        anasayfa5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ans5=new Intent(getApplicationContext(),Birsayfa.class);
                startActivity(ans5);
            }
        });

        kapalıhvz=(Button) findViewById(R.id.button21);

        kapalıhvz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent kphvz=new Intent(getApplicationContext(),kapalihavz.class);
                startActivity(kphvz);
            }
        });




    }
}
