package com.okan.lenovo.otel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.okan.lenovo.otel.R;

public class Klasikoda extends AppCompatActivity {

    Button anasayfayagit;
    Button odalar1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_klasikoda);

        anasayfayagit=(Button) findViewById(R.id.button12);

        anasayfayagit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ag=new Intent(getApplicationContext(),Birsayfa.class);
                startActivity(ag);
            }
        });

        odalar1=(Button) findViewById(R.id.button13);

        odalar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent og=new Intent(getApplicationContext(),Odalar.class);
                startActivity(og);
            }
        });




    }
}
