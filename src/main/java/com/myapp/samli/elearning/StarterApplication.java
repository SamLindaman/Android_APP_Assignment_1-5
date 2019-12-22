
package com.myapp.samli.elearning;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseACL;

// parse login
// username: user
// password: lEDUXEvRbS9i

public class StarterApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // database username: user
        // database password: e6uPFYEglpBE

        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        // Add your initialization code here
        Parse.initialize(new Parse.Configuration.Builder(getApplicationContext())
                .applicationId("c832d3ebf418145aa462597dfb0db3f090d0a62f")
                .clientKey("81e06df69eaa4f0571dd985237c073422dfaeef0")
                .server("http://18.220.228.1:80/parse/")
                .build()
        );




        //ParseUser.enableAutomaticUser();

        ParseACL defaultACL = new ParseACL();
        defaultACL.setPublicReadAccess(true);
        defaultACL.setPublicWriteAccess(true);
        ParseACL.setDefaultACL(defaultACL, true);

    }
}
