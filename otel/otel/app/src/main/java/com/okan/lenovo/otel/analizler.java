package com.okan.lenovo.otel;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.okan.lenovo.otel.Birsayfa;
import com.okan.lenovo.otel.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Random;

public class analizler extends AppCompatActivity implements View.OnClickListener {

    Button ansyfdn, analizet;
    GraphView graph, graph2, graph3, graph4, graph5,graph1;
  //  LineGraphSeries<DataPoint> series1;
    RequestQueue requestQueue;
    String verileriAlUrl = "http://192.168.43.168:82/otel/login.php";

    String veri;
   // int y,x;
    ArrayList arrayList;
    ArrayList arrayListDegerler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analizler);

        requestQueue = Volley.newRequestQueue(getApplicationContext());

        arrayList = new ArrayList();
        arrayListDegerler = new ArrayList();



        verileriCek();

        graph = (GraphView) findViewById(R.id.graph);
    //    graph1 = (GraphView) findViewById(R.id.graph1);

        graph2 = (GraphView) findViewById(R.id.graph2);
        graph3 = (GraphView) findViewById(R.id.graph3);
        graph4 = (GraphView) findViewById(R.id.graph4);
        graph5 = (GraphView) findViewById(R.id.graph5);


        ansyfdn = (Button) findViewById(R.id.button32);
        analizet = findViewById(R.id.button41);

        analizet.setOnClickListener(this);

        ansyfdn.setOnClickListener(this);

    }

    public void verileriCek() {

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,
                verileriAlUrl, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                System.out.println(response.toString());
                try {

                    JSONArray getir = response.getJSONArray("showarray");
                    for (int i = 0; i < getir.length(); i++) {
                        JSONObject showdata = getir.getJSONObject(i);

                        int id = showdata.getInt("mstr_id");
                        String tc = showdata.getString("mstr_tc");
                        String ad = showdata.getString("mstr_ad");
                        String soyad = showdata.getString("mstr_soyad");
                        String mail = showdata.getString("mstr_mail");
                        String dtarih = showdata.getString("mstr_dtarih");
                        String telNo = showdata.getString("mstr_tel");
                        String hakkinda = showdata.getString("mstr_hareketler");

                        veri = id + "&" + tc + "&" + ad + "&" + soyad + "&" + mail + "&" + dtarih + "&" + telNo + "&" + hakkinda;
                        arrayList.add(veri);

                    }


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

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v) {
        switch (v.getId())

        {
            case R.id.button41: {
                for (int i = 0; i < 12; i++) {
                    for (int j = 0; j < 6; j++) {
                        Random rand = new Random();
                        int n = rand.nextInt(30);



                        arrayListDegerler.add(n);

                    }
                }


              //     series1 = new LineGraphSeries<DataPoint>();

              //  y= (int) arrayListDegerler.get(0);
              //  x=0;
              //  series1.appendData(new DataPoint(x,y),true);



                    LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[]{
                            new DataPoint(0, (int) arrayListDegerler.get(0)),
                            new DataPoint(1, (int) arrayListDegerler.get(1)),
                            new DataPoint(2, (int) arrayListDegerler.get(2)),
                            new DataPoint(3, (int) arrayListDegerler.get(3)),
                            new DataPoint(4, (int) arrayListDegerler.get(4)),
                            new DataPoint(5, (int) arrayListDegerler.get(5)),
                            new DataPoint(6, (int) arrayListDegerler.get(6)),
                            new DataPoint(7, (int) arrayListDegerler.get(7)),
                            new DataPoint(8, (int) arrayListDegerler.get(8)),
                            new DataPoint(9, (int) arrayListDegerler.get(9)),
                            new DataPoint(10, (int) arrayListDegerler.get(10)),
                            new DataPoint(11, (int) arrayListDegerler.get(11)),


                    });




                graph.addSeries(series);




                    LineGraphSeries<DataPoint> series2 = new LineGraphSeries<DataPoint>(new DataPoint[]{
                            new DataPoint(0, (int) arrayListDegerler.get(12)),
                            new DataPoint(1, (int) arrayListDegerler.get(13)),
                            new DataPoint(2, (int) arrayListDegerler.get(14)),
                            new DataPoint(3, (int) arrayListDegerler.get(15)),
                            new DataPoint(4, (int) arrayListDegerler.get(16)),
                            new DataPoint(5, (int) arrayListDegerler.get(17)),
                            new DataPoint(6, (int) arrayListDegerler.get(18)),
                            new DataPoint(7, (int) arrayListDegerler.get(19)),
                            new DataPoint(8, (int) arrayListDegerler.get(20)),
                            new DataPoint(9, (int) arrayListDegerler.get(21)),
                            new DataPoint(10, (int) arrayListDegerler.get(22)),
                            new DataPoint(11, (int) arrayListDegerler.get(23)),

                    });
                    graph2.addSeries(series2);


                    LineGraphSeries<DataPoint> series3 = new LineGraphSeries<DataPoint>(new DataPoint[]{
                            new DataPoint(0, (int) arrayListDegerler.get(24)),
                            new DataPoint(1, (int) arrayListDegerler.get(25)),
                            new DataPoint(2, (int) arrayListDegerler.get(26)),
                            new DataPoint(3, (int) arrayListDegerler.get(27)),
                            new DataPoint(4, (int) arrayListDegerler.get(28)),
                            new DataPoint(5, (int) arrayListDegerler.get(29)),
                            new DataPoint(6, (int) arrayListDegerler.get(30)),
                            new DataPoint(7, (int) arrayListDegerler.get(31)),
                            new DataPoint(8, (int) arrayListDegerler.get(32)),
                            new DataPoint(9, (int) arrayListDegerler.get(33)),
                            new DataPoint(10, (int) arrayListDegerler.get(34)),
                            new DataPoint(11, (int) arrayListDegerler.get(35)),

                    });
                    graph3.addSeries(series3);


                    LineGraphSeries<DataPoint> series4 = new LineGraphSeries<DataPoint>(new DataPoint[]{
                            new DataPoint(0, (int) arrayListDegerler.get(36)),
                            new DataPoint(1, (int) arrayListDegerler.get(37)),
                            new DataPoint(2, (int) arrayListDegerler.get(38)),
                            new DataPoint(3, (int) arrayListDegerler.get(39)),
                            new DataPoint(4, (int) arrayListDegerler.get(40)),
                            new DataPoint(5, (int) arrayListDegerler.get(41)),
                            new DataPoint(6, (int) arrayListDegerler.get(42)),
                            new DataPoint(7, (int) arrayListDegerler.get(43)),
                            new DataPoint(8, (int) arrayListDegerler.get(44)),
                            new DataPoint(9, (int) arrayListDegerler.get(45)),
                            new DataPoint(10, (int) arrayListDegerler.get(46)),
                            new DataPoint(11, (int) arrayListDegerler.get(47)),



                    });
                    graph4.addSeries(series4);

                    LineGraphSeries<DataPoint> series5 = new LineGraphSeries<DataPoint>(new DataPoint[]{
                            new DataPoint(0, (int) arrayListDegerler.get(48)),
                            new DataPoint(1, (int) arrayListDegerler.get(49)),
                            new DataPoint(2, (int) arrayListDegerler.get(50)),
                            new DataPoint(3, (int) arrayListDegerler.get(51)),
                            new DataPoint(4, (int) arrayListDegerler.get(52)),
                            new DataPoint(5, (int) arrayListDegerler.get(53)),
                            new DataPoint(6, (int) arrayListDegerler.get(54)),
                            new DataPoint(7, (int) arrayListDegerler.get(55)),
                            new DataPoint(8, (int) arrayListDegerler.get(56)),
                            new DataPoint(9, (int) arrayListDegerler.get(57)),
                            new DataPoint(10, (int) arrayListDegerler.get(58)),
                            new DataPoint(11, (int) arrayListDegerler.get(59)),



                    });
                    graph5.addSeries(series5);


                break;

            }
            case R.id.button32:

            {

                Intent agdn = new Intent(getApplicationContext(), Birsayfa.class);
                startActivity(agdn);
                break;

            }
        }
    }
}