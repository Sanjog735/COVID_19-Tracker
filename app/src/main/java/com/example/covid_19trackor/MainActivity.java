package com.example.covid_19trackor;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    // Initialize Variable
    RecyclerView recyclerView;
    List<RecyclerViewData> myRecyclerViewData;
    RecyclerViewData mydata;
    Button donate_button,track;

    RecyclerView recyclerView2;
    List<ScreenItem> nRecyclerViewData;
    ScreenItem screenItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Assign Variable
        recyclerView = findViewById(R.id.recyclerView);

        recyclerView2 = findViewById(R.id.recyclerView2);


        // Design Horizontal Layout Manager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView2.setLayoutManager(linearLayoutManager2);


        myRecyclerViewData = new ArrayList<>();
        mydata = new RecyclerViewData("Fever",R.drawable.one);
        myRecyclerViewData.add(mydata);
        mydata = new RecyclerViewData("Dry Cough",R.drawable.two);
        myRecyclerViewData.add(mydata);
        mydata = new RecyclerViewData("Headache",R.drawable.three);
        myRecyclerViewData.add(mydata);
        mydata = new RecyclerViewData("Breadthe",R.drawable.four);
        myRecyclerViewData.add(mydata);


        nRecyclerViewData = new ArrayList<>();
        screenItem = new ScreenItem("Wash","hands offers",R.drawable.a10);
        nRecyclerViewData.add(screenItem);
        screenItem = new ScreenItem("Cover","your cough",R.drawable.a4);
        nRecyclerViewData.add(screenItem);
        screenItem = new ScreenItem("Keep","distance ",R.drawable.a8);
        nRecyclerViewData.add(screenItem);
        screenItem = new ScreenItem("Use","mask always",R.drawable.a9);
        nRecyclerViewData.add(screenItem);
        screenItem = new ScreenItem("Stay"," in home ",R.drawable.a2);
        nRecyclerViewData.add(screenItem);

        // Initialize Adapter
        SymptomAdapter symptomAdapter = new SymptomAdapter(MainActivity.this,myRecyclerViewData);
        PreventionAdapter preventionAdapter = new PreventionAdapter(MainActivity.this,nRecyclerViewData);

        // Set Adapter on RecyclerView
        recyclerView.setAdapter(symptomAdapter);
        recyclerView2.setAdapter(preventionAdapter);


        donate_button = findViewById(R.id.donate_button);
        donate_button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,PaymentActivity.class);


                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this);
                startActivity(intent,options.toBundle());
            }
        });

        track = findViewById(R.id.track);
        track.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,TrackActivity.class);


                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this);
                startActivity(intent,options.toBundle());

            }
        });
    }
}