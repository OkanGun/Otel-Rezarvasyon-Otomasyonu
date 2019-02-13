package com.okan.lenovo.otel;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Rezervasyon extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = Rezervasyonislemlerii.class.getSimpleName();

    Button anasayfageri;
    Button uyeol;
    Button odalarsyf2;
    Button havzlrsayf2;
    Button spasyf2;
    Button resteron2;
    Button iletsim2;
    Button analizlersyf1;
    Button girisyap;
    EditText tckimlik;
    ProgressDialog progressDialog;
    RequestQueue requestQueue;

    String girisYapanMusteri;

    int a = 0;

    StringBuilder result;

    String verileriAlUrl = "http://192.168.43.168:82/otel/login.php";

    String tc1, ad, soyad, mail, telNo, dtarih, hakkinda;

    int id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rezervasyon);

        requestQueue = Volley.newRequestQueue(getApplicationContext());

        result = new StringBuilder();


        anasayfageri = (Button) findViewById(R.id.but1);

        anasayfageri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ar = new Intent(getApplicationContext(), Birsayfa.class);
                startActivity(ar);
            }
        });

        uyeol = (Button) findViewById(R.id.button10);

        uyeol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), com.okan.lenovo.otel.uyeol.class);
                startActivity(intent);
            }
        });

        odalarsyf2 = (Button) findViewById(R.id.but3);

        odalarsyf2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent od = new Intent(getApplicationContext(), Odalar.class);
                startActivity(od);
            }
        });

        havzlrsayf2 = (Button) findViewById(R.id.but4);

        havzlrsayf2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hav = new Intent(getApplicationContext(), havzlar.class);
                startActivity(hav);
            }
        });

        spasyf2 = (Button) findViewById(R.id.but5);

        spasyf2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent spy = new Intent(getApplicationContext(), spa.class);
                startActivity(spy);
            }
        });

        resteron2 = (Button) findViewById(R.id.but6);

        resteron2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent res = new Intent(getApplicationContext(), restrntlar.class);
                startActivity(res);
            }
        });

        iletsim2 = (Button) findViewById(R.id.but7);

        iletsim2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent il2 = new Intent(getApplicationContext(), iletisim.class);
                startActivity(il2);
            }
        });

        analizlersyf1 = (Button) findViewById(R.id.but9);

        analizlersyf1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent anz2 = new Intent(getApplicationContext(), analizler.class);
                startActivity(anz2);
            }
        });


        tckimlik = (EditText) findViewById(R.id.editText);


        girisyap = (Button) findViewById(R.id.button);
        girisyap.setOnClickListener(this);
        uyeol.setOnClickListener(this);


    }

    public void VerileriCek(final String tc) {

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,
                verileriAlUrl, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                System.out.println(response.toString());
                try {

                    JSONArray getir = response.getJSONArray("showarray");
                    for (int i = 0; i < getir.length(); i++) {
                        JSONObject showdata = getir.getJSONObject(i);

                        id = showdata.getInt("mstr_id");
                        tc1 = showdata.getString("mstr_tc");
                        ad = showdata.getString("mstr_ad");
                        soyad = showdata.getString("mstr_soyad");
                        mail = showdata.getString("mstr_mail");
                        dtarih = showdata.getString("mstr_dtarih");
                        telNo = showdata.getString("mstr_tel");
                        hakkinda = showdata.getString("mstr_hareketler");


                        if (tc.equals(tc1))

                        {
                            a++;


                        }


                        //result.append(tc + " " + ad + " " + soyad + " " + mail + " " + dtarih + " " + telNo + " \n");
                    }
                    //result.append("===\n");

                    if (durum()) {
                        girisYapanMusteri = id + "&" + tc + "&" + ad + "&" + soyad + "&" + mail + "&" + dtarih + "&" + telNo + "&" + hakkinda;

                        SharedPreferences sharedPreferences = getSharedPreferences(getPackageName(), MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();

                        editor.putString("girisYapan", girisYapanMusteri);

                        editor.apply();

                        String[] bilgiler = girisYapanMusteri.split("&");

                        Toast.makeText(getApplicationContext(), "Sayın  " + bilgiler[2] + " " + bilgiler[3] + "  hoşgeldiniz..", Toast.LENGTH_SHORT).show();
                        Intent rzr = new Intent(getApplicationContext(), com.okan.lenovo.otel.Rezervasyonislemlerii.class);
                        startActivity(rzr);
                    } else {
                        Toast.makeText(getApplicationContext(), "Böyle bir üye bulunmamaktadır.", Toast.LENGTH_SHORT).show();
                    }

                    Log.d("VERİLERRR", result.toString());


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.append(error.getMessage());

            }
        });
        requestQueue.add(jsonObjectRequest);


    }

    public boolean durum() {

        if (a > 0) {
            return true;
        } else {
            return false;
        }


    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button: {

                String tcNo = tckimlik.getText().toString();

                VerileriCek(tcNo);


                break;

            }
            case R.id.button10: {

                Intent rzr = new Intent(getApplicationContext(), com.okan.lenovo.otel.uyeol.class);
                startActivity(rzr);
                break;

            }
        }

    }


}


