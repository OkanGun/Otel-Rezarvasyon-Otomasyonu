package com.okan.lenovo.otel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.okan.lenovo.otel.R;
import com.okan.lenovo.otel.villlaoda;

public class Odalar extends AppCompatActivity {

    Button klasikoda;
    Button ansyfa10;
    Button mrdnoda;
    Button aileoda1;
    Button aprtvilla1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_odalar);

        klasikoda=(Button) findViewById(R.id.b3);

        klasikoda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent klsk=new Intent(getApplicationContext(),Klasikoda.class);
                startActivity(klsk);
            }
        });


        ansyfa10=(Button) findViewById(R.id.b1);

        ansyfa10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent an10=new Intent(getApplicationContext(),Birsayfa.class);
                startActivity(an10);
            }
        });


        mrdnoda=(Button) findViewById(R.id.b4);

        mrdnoda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mdr=new Intent(getApplicationContext(),modernoda.class);
                startActivity(mdr);
            }
        });

        aileoda1=(Button) findViewById(R.id.b5);

        aileoda1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ail=new Intent(getApplicationContext(),aileodasi.class);
                startActivity(ail);
            }
        });

        aprtvilla1=(Button) findViewById(R.id.b6);

        aprtvilla1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent vil=new Intent(getApplicationContext(),villlaoda.class);
                startActivity(vil);
            }
        });




    }
}
