package com.myapp.samli.elearning;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.parse.ParseUser;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

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
        items.add("Java");
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

        Button logoutButton = findViewById(R.id.buttonLogout);
    }

    public void logoutPressed(View view){
        ParseUser.logOut();
        ParseUser currentUser = ParseUser.getCurrentUser(); // this will now be null
        Toast.makeText(this, "User Has Been Logged Out.", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(new Intent(view.getContext(), MainActivity.class));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        view.getContext().startActivity(intent);
    }
    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @Override
    public void onClick(View v) {
    }
}



