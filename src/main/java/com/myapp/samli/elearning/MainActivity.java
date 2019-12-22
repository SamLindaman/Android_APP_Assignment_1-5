package com.myapp.samli.elearning;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    EditText usernameEditText;
    EditText passwordEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "c832d3ebf418145aa462597dfb0db3f090d0a62f", "81e06df69eaa4f0571dd985237c073422dfaeef0");

        usernameEditText = findViewById(R.id.editText_ID);
        passwordEditText = findViewById(R.id.editText_Password);

        Button loginButton =findViewById(R.id.buttonLogin);
        //loginButton.setOnClickListener(this);
        Button signUpButton = findViewById(R.id.buttonSignUp);
        //signUpButton.setOnClickListener(this);

    }




    public void signUpClicked(View view){
        Intent intent = new Intent(view.getContext(), HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        view.getContext().startActivity(intent);
        Log.i("Clicked","1");
        usernameEditText = findViewById(R.id.editText_ID);
        passwordEditText = findViewById(R.id.editText_Password);
        Log.i("Clicked","2");
        if(usernameEditText.getText().toString() == "" || passwordEditText.getText().toString() == ""){
            Toast.makeText(this,"Username and password are required.",Toast.LENGTH_SHORT).show();
        } else {
            Log.i("Clicked","3");
            ParseUser user = new ParseUser();
            user.setUsername(usernameEditText.getText().toString());
            Log.i("username",usernameEditText.getText().toString());
            user.setPassword(passwordEditText.getText().toString());
            Log.i("Clicked","4");

            user.signUpInBackground(new SignUpCallback() {
                @Override
                public void done(ParseException e) {
                    Log.i("Clicked","5");
                    if(e == null){
                        Log.i("Signup","Success");
                    } else{
                        Toast.makeText(MainActivity.this, "Signed in Anonymously", Toast.LENGTH_SHORT).show();
                        Log.i("Clicked","fail");
                    }
                }
            });

        }
    }

    public void loginClicked(View view){

        Log.i("Clicked","1");
        usernameEditText = findViewById(R.id.editText_ID);
        passwordEditText = findViewById(R.id.editText_Password);
        final String userName = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        Intent intent = new Intent(view.getContext(), HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        view.getContext().startActivity(intent);
        if(userName!=null&&password!=null) {
            Log.i("username",userName);
            ParseUser.logInInBackground(userName, password, new LogInCallback() {
                @Override
                public void done(ParseUser user, ParseException e) {
                    if (user != null) {
                        Log.i("Login", "Successful");
                    } else {
                        Toast.makeText(MainActivity.this, "Account created for "+userName, Toast.LENGTH_SHORT).show();
                        Log.i("Login","failed");
                    }
                }
            });

        }

    }


    @Override
    public void onClick(View view) {
    }
}
