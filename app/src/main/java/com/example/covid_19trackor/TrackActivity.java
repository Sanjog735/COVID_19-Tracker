package com.example.covid_19trackor;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.leo.simplearcloader.SimpleArcLoader;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;
import org.json.JSONException;
import org.json.JSONObject;

public class TrackActivity extends AppCompatActivity {
    TextView tvCases,tvRecovered,tvCritical,tvActive,tvTodayCase,tvTotalDeath,tvTodayDeath,tvAffectedCountries;
    ScrollView scrollView;
    SimpleArcLoader loader;
    PieChart piechart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track);

        tvCases = findViewById(R.id.tvCases);
        tvRecovered = findViewById(R.id.tvRecovered);
        tvCritical = findViewById(R.id.tvCritical);
        tvActive = findViewById(R.id.tvActive);
        tvTodayCase = findViewById(R.id.tvTodayCase);
        tvTotalDeath = findViewById(R.id.tvTotalDeath);
        tvTodayDeath = findViewById(R.id.tvTodayDeath);
        tvAffectedCountries = findViewById(R.id.tvAffectedCountries);
        scrollView = findViewById(R.id.scrollView);
        loader = findViewById(R.id.loader);
        piechart = findViewById(R.id.piechart);
        
        FetchData();
    }

    private void FetchData() {
        String url = "https://corona.lmao.ninja/v2/all/";

        loader.start();
        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObject = new JSONObject(response.toString());

                            tvCases.setText(jsonObject.getString("cases"));
                            tvRecovered.setText(jsonObject.getString("recovered"));
                            tvCritical.setText(jsonObject.getString("critical"));
                            tvActive.setText(jsonObject.getString("active"));
                            tvTodayCase.setText(jsonObject.getString("todayCases"));
                            tvTotalDeath.setText(jsonObject.getString("deaths"));
                            tvTodayDeath.setText(jsonObject.getString("todayDeaths"));
                            tvAffectedCountries.setText(jsonObject.getString("affectedCountries"));


                            piechart.addPieSlice(new PieModel("Cases",Integer.parseInt(tvCases.getText().toString()), Color.parseColor("#66FF9800")));
                            piechart.addPieSlice(new PieModel("Recovered",Integer.parseInt(tvRecovered.getText().toString()), Color.parseColor("#8BC34A")));
                            piechart.addPieSlice(new PieModel("Deaths",Integer.parseInt(tvTotalDeath.getText().toString()), Color.parseColor("#7839EC")));
                            piechart.addPieSlice(new PieModel("Active",Integer.parseInt(tvActive.getText().toString()), Color.parseColor("#118DEF")));
                            piechart.startAnimation();

                            loader.stop();
                            loader.setVisibility(View.GONE);
                            scrollView.setVisibility(View.VISIBLE);


                        } catch (JSONException e) {
                            e.printStackTrace();
                            loader.stop();
                            loader.setVisibility(View.GONE);
                            scrollView.setVisibility(View.VISIBLE);
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                loader.stop();
                loader.setVisibility(View.GONE);
                scrollView.setVisibility(View.VISIBLE);
                Toast.makeText(TrackActivity.this,error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);

    }

    public void country(View view) {
    }
}