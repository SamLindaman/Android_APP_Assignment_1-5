package com.myapp.samli.elearning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    customAdapter adapter;
    ArrayList<String> items, itemDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen_layout);


        items = new ArrayList<>();
        itemDescription = new ArrayList<>();

        items.add("C++");
        itemDescription.add("Java");
        items.add("Data Structure");
        items.add("UI Design");
        items.add("Algorithms");
        items.add("Database Systems");
        items.add("Discrete Mathematics");
        items.add("Spoken Chinese");
        items.add("Computer Organization");
        items.add("Mobile Application Development");
        items.add("Computer Networks");

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new customAdapter(this, items, itemDescription);
        recyclerView.setAdapter(adapter);
    }
    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }
}



