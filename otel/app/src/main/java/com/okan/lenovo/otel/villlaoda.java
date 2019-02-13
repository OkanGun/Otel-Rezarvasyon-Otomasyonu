package com.okan.lenovo.otel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class villlaoda extends AppCompatActivity {

    Button anasyf4;
    Button odalar4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_villlaoda);

        anasyf4=(Button) findViewById(R.id.button18);

        anasyf4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ag4=new Intent(getApplicationContext(),Birsayfa.class);
                startActivity(ag4);
            }
        });

        odalar4=(Button) findViewById(R.id.button19);

        odalar4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent oda4=new Intent(getApplicationContext(),Odalar.class);
                startActivity(oda4);
            }
        });




    }
}
