package com.okan.lenovo.otel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.okan.lenovo.otel.R;

public class iletisim extends AppCompatActivity {

    Button anasyfgeridon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iletisim);

        anasyfgeridon=(Button) findViewById(R.id.button8);

        anasyfgeridon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent agd=new Intent(getApplicationContext(),Birsayfa.class);
                startActivity(agd);
            }
        });



    }
}