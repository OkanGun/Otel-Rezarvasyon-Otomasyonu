package com.okan.lenovo.otel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.okan.lenovo.otel.Birsayfa;
import com.okan.lenovo.otel.Odalar;
import com.okan.lenovo.otel.R;

public class aileodasi extends AppCompatActivity {

    Button anasayfa3;
    Button oda3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aileodasi);

        anasayfa3=(Button) findViewById(R.id.button16);

        anasayfa3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ag3=new Intent(getApplicationContext(),Birsayfa.class);
                startActivity(ag3);
            }
        });

        oda3=(Button) findViewById(R.id.button17);

        oda3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent odalr3=new Intent(getApplicationContext(),Odalar.class);
                startActivity(odalr3);
            }
        });


    }
}
