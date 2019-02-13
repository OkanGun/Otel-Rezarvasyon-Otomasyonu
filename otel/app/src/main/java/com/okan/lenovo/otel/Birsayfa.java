package com.okan.lenovo.otel;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Birsayfa extends AppCompatActivity {

    Button rezervasyon;
    Button odalar;
    Button havuzlar;
    Button spasyf;
    Button resterant1;
    Button iletisim1;
    Button analizsyf;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birsayfa);

        final SharedPreferences sharedPreferences = getSharedPreferences(getPackageName(), MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String onlineMusteri = sharedPreferences.getString("girisYapan","");

        if (!onlineMusteri.isEmpty())
        {
            editor.clear();
            editor.apply();
            Toast.makeText(getApplicationContext(), "Çıkış Yapıldı..", Toast.LENGTH_LONG).show();
        }

        else
            {
                Toast.makeText(getApplicationContext(), "Hoş Geldiniz..", Toast.LENGTH_LONG).show();
            }

        odalar = (Button) findViewById(R.id.button3);

        odalar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent oda = new Intent(getApplicationContext(), Odalar.class);
                startActivity(oda);
            }
        });

        rezervasyon = (Button) findViewById(R.id.button2);

        rezervasyon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent r = new Intent(getApplicationContext(), Rezervasyon.class);
                startActivity(r);
            }
        });


        havuzlar = (Button) findViewById(R.id.button4);

        havuzlar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hv = new Intent(getApplicationContext(), havzlar.class);
                startActivity(hv);
            }
        });

        spasyf = (Button) findViewById(R.id.button5);

        spasyf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sps = new Intent(getApplicationContext(), spa.class);
                startActivity(sps);
            }
        });

        resterant1 = (Button) findViewById(R.id.button6);

        resterant1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rs1 = new Intent(getApplicationContext(), restrntlar.class);
                startActivity(rs1);
            }
        });

        analizsyf = (Button) findViewById(R.id.button9);

        analizsyf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent anlz = new Intent(getApplicationContext(), analizler.class);
                startActivity(anlz);
            }
        });


        iletisim1 = (Button) findViewById(R.id.button7);

        iletisim1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ilet = new Intent(getApplicationContext(), iletisim.class);
                startActivity(ilet);
            }
        });





    }
}
