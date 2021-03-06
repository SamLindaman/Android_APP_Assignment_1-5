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
import com.parse.ParseACL;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    EditText usernameEditText;
    EditText passwordEditText;
    Button loginButton;
    Button signUpButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernameEditText = findViewById(R.id.editText_ID);
        passwordEditText = findViewById(R.id.editText_Password);
        loginButton = findViewById(R.id.buttonLogin);
        signUpButton = findViewById(R.id.buttonSignUp);
        //

        //Enable Parse Database
        // database username: user
        // database password: e6uPFYEglpBE

        // Enable Local Datastore.
//        Parse.enableLocalDatastore(this);

        Parse.initialize(new Parse.Configuration.Builder(getApplicationContext())
                .applicationId("c832d3ebf418145aa462597dfb0db3f090d0a62f")
                .clientKey("81e06df69eaa4f0571dd985237c073422dfaeef0")
                .server("http://18.220.228.1:80/parse/")
                .build()
        );

        ParseACL defaultACL = new ParseACL();
        defaultACL.setPublicReadAccess(true);
        defaultACL.setPublicWriteAccess(true);
        ParseACL.setDefaultACL(defaultACL, true);

        //Parse.enableLocalDatastore(this);
        //Parse.initialize(this, "c832d3ebf418145aa462597dfb0db3f090d0a62f", "81e06df69eaa4f0571dd985237c073422dfaeef0");

        usernameEditText = findViewById(R.id.editText_ID);
        passwordEditText = findViewById(R.id.editText_Password);

        Button loginButton =findViewById(R.id.buttonLogin);
        Button signUpButton = findViewById(R.id.buttonSignUp);


        //keeps the user logged in, so if they exit the app, they don't have to log in again
        if(ParseUser.getCurrentUser()!=null){
            showHome();
        }

        ParseAnalytics.trackAppOpenedInBackground(getIntent());

    }



    //action to take if the signup button is clicked
    public void signUpClicked(View view){
       Intent intent = new Intent(view.getContext(), HomeActivity.class);
       intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
       view.getContext().startActivity(intent);
        usernameEditText = findViewById(R.id.editText_ID);
        passwordEditText = findViewById(R.id.editText_Password);

        //makes sure that there is info in the username/password field or send an error.
        if(usernameEditText.getText().toString().matches("") || passwordEditText.getText().toString().matches("")){
            Toast.makeText(this,"Username and password are required.",Toast.LENGTH_SHORT).show();
        } else {
            //create new parse user in the database
            ParseUser user = new ParseUser();
            user.setUsername(usernameEditText.getText().toString());
            user.setPassword(passwordEditText.getText().toString());

            //sign the user in
            user.signUpInBackground(new SignUpCallback() {
                @Override
                public void done(ParseException e) {
                    if(e == null){
                        Log.i("Signup","Success");
                    } else{
                        Toast.makeText(MainActivity.this, "Signed in Anonymously", Toast.LENGTH_SHORT).show();
                        Log.i("Clicked","fail");
                        Log.i("Error",e.toString());
                    }
                }
            });


        }
    }

    //action to take is the login button is clicked
    public void loginClicked(View view){

        usernameEditText = findViewById(R.id.editText_ID);
        passwordEditText = findViewById(R.id.editText_Password);
        final String userName = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        Intent intent = new Intent(view.getContext(), HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        view.getContext().startActivity(intent);

        //make sure there is some info in the username+password fields
        if(userName!=""&&password!="") {
            Log.i("username",userName);
            ParseUser.logInInBackground(userName, password, new LogInCallback() {
                @Override
                public void done(ParseUser user, ParseException e) {
                    if (user != null) {
                        Log.i("Login", "Successful");
                    } else {
                        Toast.makeText(MainActivity.this, "Account created for "+userName, Toast.LENGTH_SHORT).show();
                        Log.i("Login","failed");
                        Log.i("failed:",e.getStackTrace().toString());
                    }
                }
            });

        }

    }

    //show the home activity
    public void showHome(){
        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
        startActivity(intent);
    }


    @Override
    public void onClick(View view) {

    }
}
