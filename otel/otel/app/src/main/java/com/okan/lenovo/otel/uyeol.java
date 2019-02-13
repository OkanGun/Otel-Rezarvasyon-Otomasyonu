package com.okan.lenovo.otel;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class uyeol extends AppCompatActivity {

    Button kaydetanasayfayadon, button11, anasyf, rezrvyn;
    EditText tcnosu;
    EditText isimdegeri;
    EditText soyisimdegeri;
    EditText mailadresidegeri;
    EditText dogumtarihidegeri;
    EditText telnumsrsdi;
    RequestQueue requestQueue;


    String tc, ad, soyad, mail, dtarih, telNO;

    String onlineMusteri, mstrTC, mstrAd, mstrSoyad, mstrTelNo, mstrMail, mstrdgTarih, mstrHakkinda, MstriD;

    //String  kaydetanasayfayadonUrl = "http://172.20.10.5/phpmysqlbaglantisi/kaydet1.php";

    private static String kaydetanasayfayadonUrl = "http://192.168.43.168:82/otel/kaydet1.php";

    private static final String TAG_SUCCESS = "success";


    private ProgressDialog pDialog;

    int a = 0;


    public static class Fonksiyonlar {

        public static boolean isEmailValid(String email) { //mail formatt kontrol eder
            boolean isValid = false;

            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            CharSequence inputStr = email;

            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(inputStr);
            if (matcher.matches()) {
                isValid = true;
            }
            return isValid;
        }

    }

    TextView uyariTC,uyariad,uyarisoyAd,uyarimail,uyaridgtarih,uyaritelNo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uyeol);

        uyariTC = findViewById(R.id.textView6);
        uyariad = findViewById(R.id.textView7);
        uyarisoyAd = findViewById(R.id.textView8);
        uyarimail = findViewById(R.id.textView10);
        uyaridgtarih = findViewById(R.id.textView9);
        uyaritelNo = findViewById(R.id.textView11);


        tcnosu = (EditText) findViewById(R.id.editText3);
        isimdegeri = (EditText) findViewById(R.id.editText4);
        soyisimdegeri = (EditText) findViewById(R.id.editText5);
        mailadresidegeri = (EditText) findViewById(R.id.editText7);
        dogumtarihidegeri = (EditText) findViewById(R.id.editText6);
        telnumsrsdi = (EditText) findViewById(R.id.editText8);

        final SharedPreferences sharedPreferences = getSharedPreferences(getPackageName(), MODE_PRIVATE);
        onlineMusteri = sharedPreferences.getString("girisYapan", "");

        if (!onlineMusteri.isEmpty()) {
            String[] bilgiler = onlineMusteri.split("&");

            a++;
            MstriD = bilgiler[0];
            mstrTC = bilgiler[1];
            mstrAd = bilgiler[2];
            mstrSoyad = bilgiler[3];
            mstrMail = bilgiler[4];
            mstrdgTarih = bilgiler[5];
            mstrTelNo = bilgiler[6];
            mstrHakkinda = bilgiler[7];

            tcnosu.setText(mstrTC);
            isimdegeri.setText(mstrAd);
            soyisimdegeri.setText(mstrSoyad);
            mailadresidegeri.setText(mstrMail);
            dogumtarihidegeri.setText(mstrdgTarih);
            telnumsrsdi.setText(mstrTelNo);
        }

        mstrHakkinda ="";


        anasyf = (Button) findViewById(R.id.btn1);
        rezrvyn = (Button) findViewById(R.id.btn2);
        anasyf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ans01 = new Intent(getApplicationContext(), Birsayfa.class);
                startActivity(ans01);
            }
        });
        rezrvyn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rez01 = new Intent(getApplicationContext(), Rezervasyon.class);
                startActivity(rez01);
            }
        });

        kaydetanasayfayadon = (Button) findViewById(R.id.button11);
        //    button11=(Button)findViewById(R.id.button11);

        requestQueue = Volley.newRequestQueue(getApplicationContext());


        kaydetanasayfayadon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tc = tcnosu.getText().toString();
                ad = isimdegeri.getText().toString();
                soyad = soyisimdegeri.getText().toString();
                mail = mailadresidegeri.getText().toString();
                dtarih = dogumtarihidegeri.getText().toString();
                telNO = telnumsrsdi.getText().toString();

                if (tc.isEmpty() || ad.isEmpty() || soyad.isEmpty() || mail.isEmpty() || dtarih.isEmpty() || telNO.isEmpty())

                {
                    Toast.makeText(getApplicationContext(), "Tüm bilgileri eksiksiz doldurmalısınız..", Toast.LENGTH_LONG).show();

                }
                else {

                    if (11 != tc.length()) {
                        Toast.makeText(getApplicationContext(), "Kimlik numaranızı eksik veya fazla girdiniz..", Toast.LENGTH_LONG).show();

                        uyariTC.setText("Kimlik numaranızı eksik veya fazla girdiniz..");

                    } else if (sayiVarmi(ad)) {
                        Toast.makeText(getApplicationContext(), "İsmin içinde sayı olamaz..", Toast.LENGTH_LONG).show();
                        uyariad.setText("İsmin içinde sayı olamaz..");

                    } else if (sayiVarmi(soyad)) {
                        Toast.makeText(getApplicationContext(), "Soy ismin içinde sayı olamaz..", Toast.LENGTH_LONG).show();
                        uyarisoyAd.setText("Soy ismin içinde sayı olamaz..");

                    } else if (!Fonksiyonlar.isEmailValid(mail)) {
                        Toast.makeText(getApplicationContext(), "Girdiğiniz mail formata uygun değildir..", Toast.LENGTH_LONG).show();
                        uyarimail.setText("Girdiğiniz mail formata uygun değildir.");

                    }  else if (dtarih.length() != 10 ) {
                        Toast.makeText(getApplicationContext(), "Doğum tarihi YYYY.AA.GG gibi olmalıdır..Fazla veya eksik girdiniz..", Toast.LENGTH_LONG).show();
                        uyaridgtarih.setText("Doğum tarihi YYYY.AA.GG gibi olmalıdır..Fazla veya eksik girdiniz..");
                    } else if (telNO.length() != 11) {

                        Toast.makeText(getApplicationContext(), "Telefon numaranızı eksik veya fazla girdiniz..", Toast.LENGTH_LONG).show();
                        uyaritelNo.setText("Telefon numaranızı eksik veya fazla girdiniz.");

                    } else {

                        yolla();


                        Toast.makeText(getApplicationContext(), "Üye kaydı yapıldı", Toast.LENGTH_LONG).show();
                        Intent ans01 = new Intent(getApplicationContext(), Birsayfa.class);
                        startActivity(ans01);

                    }
                }


            }

        });


    }

    public void yolla() {

        if (a <1) {
            kaydetanasayfayadonUrl = "http://192.168.43.168:82/otel/kaydet1.php";
        } else {
            kaydetanasayfayadonUrl = "http://192.168.43.168:82/otel/guncelle.php";
        }


        StringRequest request = new StringRequest(Request.Method.POST, kaydetanasayfayadonUrl, new Response.Listener<String>() {
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

                if (a <1) {

                    // parameters.put("mstr_id", MstriD);
                    parameters.put("mstr_tc", tcnosu.getText().toString());
                    parameters.put("mstr_ad", isimdegeri.getText().toString());
                    parameters.put("mstr_soyad", soyisimdegeri.getText().toString());
                    parameters.put("mstr_mail", mailadresidegeri.getText().toString());
                    parameters.put("mstr_dtarih", dogumtarihidegeri.getText().toString());
                    parameters.put("mstr_tel", telnumsrsdi.getText().toString());
                    parameters.put("mstr_hareketler", mstrHakkinda);

                } else {
                    parameters.put("mstr_id", MstriD);
                    parameters.put("mstr_tc", tcnosu.getText().toString());
                    parameters.put("mstr_ad", isimdegeri.getText().toString());
                    parameters.put("mstr_soyad", soyisimdegeri.getText().toString());
                    parameters.put("mstr_mail", mailadresidegeri.getText().toString());
                    parameters.put("mstr_dtarih", dogumtarihidegeri.getText().toString());
                    parameters.put("mstr_tel", telnumsrsdi.getText().toString());
                    parameters.put("mstr_hareketler", mstrHakkinda);

                }


                return parameters;
            }
        };
        requestQueue.add(request);
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



