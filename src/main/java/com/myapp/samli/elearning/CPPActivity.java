package com.myapp.samli.elearning;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CPPActivity extends AppCompatActivity {

    ImageView addImage;
    TextView title;
    TextView time;
    public static boolean added = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cpp);
        addImage = findViewById(R.id.imageView4);
        if(added){
            addImage.setImageResource(R.drawable.check);
        }
        title = findViewById(R.id.titleTextView);
        time = findViewById(R.id.timeTextView);
    }

    public void addClicked(View view) {
        if (!added) {
            addImage.setImageResource(R.drawable.check);
            added = true;
        } else {
            addImage.setImageResource(R.drawable.add);
            added = false;
        }
    }
}
