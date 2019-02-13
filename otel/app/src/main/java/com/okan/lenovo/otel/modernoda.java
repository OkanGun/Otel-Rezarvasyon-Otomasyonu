package com.okan.lenovo.otel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.okan.lenovo.otel.R;

public class modernoda extends AppCompatActivity {

    Button ansayfa2;
    Button odalar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modernoda);

        ansayfa2=(Button) findViewById(R.id.button14);

        ansayfa2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ag2=new Intent(getApplicationContext(),Birsayfa.class);
                startActivity(ag2);
            }
        });

        odalar2=(Button) findViewById(R.id.button15);

        odalar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent oda2=new Intent(getApplicationContext(),Odalar.class);
                startActivity(oda2);
            }
        });




    }
}
