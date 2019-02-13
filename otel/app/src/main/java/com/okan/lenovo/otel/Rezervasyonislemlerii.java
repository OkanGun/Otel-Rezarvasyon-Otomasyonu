package com.okan.lenovo.otel;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.okan.lenovo.otel.R;

import java.util.HashMap;
import java.util.Map;

public class Rezervasyonislemlerii extends AppCompatActivity implements View.OnClickListener {

    RadioButton standrt;
    RadioButton klasik;
    RadioButton modern;
    RadioButton aile;
    RadioButton villa;
    RadioGroup radioGroup;
    EditText giristarih;
    EditText cikistarih;
    EditText klckgun;
    Button rezkydt;
    Button uyebilgun;
    Button raniptl;
    Button rezsorgu;
    Button cksyap;

    String onlineMusteri, mstrTC, mstrAd, mstrSoyad, mstrTelNo, mstrMail, mstrdgTarih, mstrHakkinda,mstriD;


    RequestQueue requestQueue;
    String rezkydtUrl = "http://192.168.43.168:82/otel/guncelle.php";

    TextView musteriBilgileri, RezervasyonBilgileri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rezervasyonislemleri);

        musteriBilgileri = findViewById(R.id.textView5);
        RezervasyonBilgileri = findViewById(R.id.textView2);

        SharedPreferences sharedPreferences = getSharedPreferences(getPackageName(), MODE_PRIVATE);

        onlineMusteri = sharedPreferences.getString("girisYapan", "");

        String[] bilgiler = onlineMusteri.split("&");

        if(bilgiler.length==8)
        {
            mstriD = bilgiler[0];
            mstrTC = bilgiler[1];
            mstrAd = bilgiler[2];
            mstrSoyad = bilgiler[3];
            mstrMail = bilgiler[4];
            mstrdgTarih = bilgiler[5];
            mstrTelNo = bilgiler[6];
            mstrHakkinda = bilgiler[7];

            if(sayiVarmi(mstrHakkinda))

            {
                RezervasyonBilgileri.setText("REZERVASYON BİLGİLERİ" + "\n " + "" + "\n " + mstrHakkinda);
            }
            else
                {
                    mstrHakkinda="";

                    RezervasyonBilgileri.setText("REZERVASYON BİLGİLERİ" + "\n " + "" + "\n " + "  Kaydınız Yoktur");
                }

        }
        else {
            mstriD = bilgiler[0];
            mstrTC = bilgiler[1];
            mstrAd = bilgiler[2];
            mstrSoyad = bilgiler[3];
            mstrMail = bilgiler[4];
            mstrdgTarih = bilgiler[5];
            mstrTelNo = bilgiler[6];
            mstrHakkinda = "";

            RezervasyonBilgileri.setText("REZERVASYON BİLGİLERİ" + "\n " + "" + "\n " + "  Kaydınız Yoktur");
        }

        musteriBilgileri.setText("Müsteri TC: " + mstrTC + " \n" + "Müsteri İsim: " + mstrAd + " \n" + "Müsteri Soyisim: " + mstrSoyad);




        standrt = findViewById(R.id.checkBox);
        klasik = findViewById(R.id.checkBox2);
        modern = findViewById(R.id.checkBox3);
        aile = findViewById(R.id.checkBox4);
        villa = findViewById(R.id.checkBox5);
        giristarih = findViewById(R.id.editText39);
        cikistarih = findViewById(R.id.editText40);
        klckgun = findViewById(R.id.editTxt3);
        rezkydt = findViewById(R.id.button33);
        uyebilgun = findViewById(R.id.button40);
        raniptl = findViewById(R.id.button39);
        rezsorgu = findViewById(R.id.button34);
        cksyap = findViewById(R.id.button42);

        cksyap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ans002 = new Intent(getApplicationContext(), Birsayfa.class);
                startActivity(ans002);
            }
        });

    //    uyebilgun.setOnClickListener(new View.OnClickListener() {
      //      @Override
        //    public void onClick(View view) {
          //      Intent ans0005 = new Intent(getApplicationContext(), uyeol.class);
            //    startActivity(ans0005);
            //}
       // });


        radioGroup = findViewById(R.id.grup);


        requestQueue = Volley.newRequestQueue(getApplicationContext());

        raniptl.setOnClickListener(this);
        rezkydt.setOnClickListener(this);
        rezsorgu.setOnClickListener(this);
        uyebilgun.setOnClickListener(this);


    }

    public void yolla() {


        StringRequest request = new StringRequest(Request.Method.POST, rezkydtUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                System.out.println(response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parameters = new HashMap<String, String>();
                parameters.put("mstr_id",mstriD);
                parameters.put("mstr_tc", mstrTC);
                parameters.put("mstr_ad", mstrAd);
                parameters.put("mstr_soyad", mstrSoyad);
                parameters.put("mstr_mail", mstrMail);
                parameters.put("mstr_dtarih", mstrdgTarih);
                parameters.put("mstr_tel", mstrTelNo);
                parameters.put("mstr_hareketler", mstrHakkinda);

                return parameters;
            }
        };
        requestQueue.add(request);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button33:// Rezervasyon kaydet

                String id = String.valueOf(radioGroup.getCheckedRadioButtonId());


                String soniki = id.substring(id.length() - 2, id.length());
                int id2 = Integer.parseInt(soniki);

                String girisTarihi = giristarih.getText().toString();
                String cikisTarihi = cikistarih.getText().toString();


                if (id2==-1) {
                    Toast.makeText(getApplicationContext(), "Herhangi bir oda seçimi yapmadınız..", Toast.LENGTH_LONG).show();
                } else {
                    if (girisTarihi.isEmpty() || cikisTarihi.isEmpty()) {
                        Toast.makeText(getApplicationContext(), "Giriş ve çıkış tarihlerini eksiksiz doldurunuz..", Toast.LENGTH_LONG).show();
                    } else {

                        if (RezerVasyonVarmi()) {
                            Toast.makeText(getApplicationContext(), "Zaten bir rezervasyona sahipsiniz..", Toast.LENGTH_LONG).show();
                        } else {
                            if (id2==79) {

                                mstrHakkinda = girisTarihi + "&&" + cikisTarihi + "&&odanız Standart Oda";


                            } else if (id2==80) {

                                mstrHakkinda = girisTarihi + "&&" + cikisTarihi + "&&odanız Klasik Suit Oda";


                            } else if (id2==81) {

                                mstrHakkinda = girisTarihi + "&&" + cikisTarihi + "&&odanız Moder Suit Oda";


                            } else if (id2==82) {

                                mstrHakkinda = girisTarihi + "&&" + cikisTarihi + "&&odanız Aile Oda";


                            } else {

                                mstrHakkinda = girisTarihi + "&&" + cikisTarihi + "&&odanız Apart Villa";


                            }


                            String[] rezBilgi = mstrHakkinda.split("&&");


                            RezervasyonBilgileri.setText(("REZERVASYON BİLGİLERİ" + "\n " + "" + "\n " + rezBilgi[0] + "  ile  " + rezBilgi[1] + "  tarihleri arasında  " + rezBilgi[2] + "  için rezervasyonunuz bulunmaktadır"));


                        }


                    }

                }



                yolla();


                break;
           case R.id.button40:// Üye bilgilerini güncelle


                Intent rzr15 = new Intent(getApplicationContext(),uyeol.class);
                startActivity(rzr15);

                break;
            case R.id.button39:// Rezervasyon İptalet

                if (!RezerVasyonVarmi()) {
                    Toast.makeText(getApplicationContext(), "İptal Edilecek bir rezervasyon kaydınız yoktur.", Toast.LENGTH_SHORT).show();
                } else {

                    mstrHakkinda = "";

                    RezervasyonBilgileri.setText("REZERVASYON BİLGİLERİ" + "\n " + "" + "\n " + "Herhangi bir rezervasyon kaydınız yoktur");


                    Toast.makeText(getApplicationContext(), "Rezervasyonunuz iptal edilmiştir", Toast.LENGTH_SHORT).show();

                    yolla();


                }



                break;
            case R.id.button34:// Rezervasyon Sorgu

                if (RezerVasyonVarmi()) {


                    Toast.makeText(getApplicationContext(), "Şuan ki Rezervasyon Durumunuz: " + mstrHakkinda, Toast.LENGTH_SHORT).show();


                } else {

                    Toast.makeText(getApplicationContext(), "Herhangi  bir rezervasyon kaydınız yoktur.", Toast.LENGTH_SHORT).show();
                }

                break;

        }
    }

    public boolean RezerVasyonVarmi() {

        if (mstrHakkinda==null || mstrHakkinda.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public boolean sayiVarmi(String kelime) {



        for (int i = 0; i < kelime.length(); i++) {

            if(Character.isDigit(kelime.charAt(i)))
            {
                return true;
            }
            break;
        }


        return false;
    }
}
