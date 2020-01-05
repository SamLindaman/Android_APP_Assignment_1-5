package com.myapp.samli.elearning;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyClasses extends AppCompatActivity {

    RecyclerView recyclerView;
    customAdapter adapter;
    ArrayList<String> items, itemDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yourcourses);


        items = new ArrayList<>();
        itemDescription = new ArrayList<>();

        Intent in= getIntent();
        Bundle b = in.getExtras();

        if(b!=null)
        {
            String title =(String) b.get("Title");
            items.add(title);
        }

        //checks for which courses have been added in their activity
        //and if they have, add them to the array list
        items.add("Mobile Application Development");
        if(CPPActivity.added){
            items.add("C++");
        }
        if(JavaActivity.added){
            items.add("Java");
        }
        if(DataStructureActivity.added){
            items.add("Data Structure");
        }
        if(UIDesignActivity.added){
            items.add("UI Design");
        }
        if(AlgorithmsActivity.added){
            items.add("Algorithms");
        }
        if(DatabaseSystemsActivity.added){
            items.add("Database Systems");
        }
        if(DiscreteMathematicsActivity.added){
            items.add("Discrete Mathematics");
        }
        if(SpokenChineseActivity.added){
            items.add("Spoken Chinese");
        }
        if(ComputerOrganizationActivity.added) {
            items.add("Computer Organization");
        }

        if(ComputerNetworksActivity.added){
            items.add("Computer Networks");
        }

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new customAdapter(this, items, itemDescription);
        recyclerView.setAdapter(adapter);
        //Button back = findViewById(R.id.buttonHome);
        //back.setText("Home");
        Button logoutButton = findViewById(R.id.buttonLogout);
    }
}
