package com.myapp.samli.elearning;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener, SearchView.OnQueryTextListener {

    RecyclerView recyclerView;
    customAdapter adapter;
    ArrayList<String> items, itemDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen_layout);

        SearchView searchView = findViewById(R.id.searchBar);
        searchView.setOnQueryTextListener(this);

        //create list of classes and display them in the recycler view
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

        //send info to recyclr view and adapter
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new customAdapter(this, items, itemDescription);
        recyclerView.setAdapter(adapter);

        Button logoutButton = findViewById(R.id.buttonLogout);
    }

    //show the user their classes
    public void yourCoursesClicked(View view){
        Intent intent = new Intent(view.getContext(), MyClasses.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    //log the user out
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

    //implement the searchbar
    @Override
    public boolean onQueryTextSubmit(String query) {
        String userInput = query.toLowerCase();
        List<String> newList = new ArrayList<>();

        //sends everything to lowercase, so the user can search in caps or lowercase if they want
        for(String data: items){
            if(data.toLowerCase().contains(userInput)){
                newList.add(data);
            }
        }

        adapter.updateList(newList);

        return true;
    }

    //implement search bar
    @Override
    public boolean onQueryTextChange(String newText) {

        String userInput = newText.toLowerCase();
        List<String> newList = new ArrayList<>();

        for(String data: items){
            if(data.toLowerCase().contains(userInput)){
                newList.add(data);
            }
        }

        adapter.updateList(newList);

        return true;
    }
}



