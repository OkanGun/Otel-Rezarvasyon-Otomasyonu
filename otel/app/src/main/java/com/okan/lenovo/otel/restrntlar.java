package com.okan.lenovo.otel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.okan.lenovo.otel.R;

public class restrntlar extends AppCompatActivity {

    Button ansyf9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restrntlar);

        ansyf9=(Button) findViewById(R.id.button38);

        ansyf9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ans9=new Intent(getApplicationContext(),Birsayfa.class);
                startActivity(ans9);
            }
        });





    }
}
