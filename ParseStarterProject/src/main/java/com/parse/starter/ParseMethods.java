package com.parse.starter;

/*
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.parse.ParseAnalytics;
import com.parse.ParseUser;
/*
 * Copyright (c) 2015-present, Parse, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.

package com.parse.starter;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseAnonymousUtils;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;

import java.util.List;


public class ParseMethods {




        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
/*
    ParseObject score = new ParseObject("Score");
    score.put("username", "Ross");
    score.put("score", "50");
    score.saveInBackground(new SaveCallback() {
      @Override
      public void done(ParseException e) {
        if(e == null){
          Log.i("Result", "Saved");
        } else {
          e.printStackTrace();
        }
      }
    });


    ParseQuery<ParseObject> query = ParseQuery.getQuery("Score");
    query.getInBackground("xX4PfJmhQk", new GetCallback<ParseObject>() {
      @Override
      public void done(ParseObject object, ParseException e) {
        if(e == null && object != null){
          Log.i("username",object.getString("username"));
          Log.i("score", Integer.toString(object.getInt("score")));
        } else {
          e.printStackTrace();
        }
      }
    });

*/

/*
  ParseObject twitter = new ParseObject("Tweet");
  twitter.put("username", "DKENZO");
  twitter.put("tweet", "This should be in the server");
  twitter.saveInBackground(new SaveCallback() {
    @Override
    public void done(ParseException e) {
      if(e == null){
        Toast.makeText(MainActivity.this, "Tweet Saved", Toast.LENGTH_SHORT).show();
      } else {
        e.printStackTrace();
      }
    }
  });


  ParseQuery<ParseObject> tweetQuery = new ParseQuery<ParseObject>("Tweet");
  tweetQuery.getInBackground("BLW8pw8O1P", new GetCallback<ParseObject>() {
    @Override
    public void done(ParseObject object, ParseException e) {
      if(e == null && object != null){
        Log.i("username",object.getString("username"));
        Log.i("tweet", object.getString("tweet"));
      } else {
        e.printStackTrace();
      }
    }
  });

  */

/* Advanced Queries
  ParseQuery<ParseObject> query = ParseQuery.getQuery("Score");

  //Use this to search for a specific query
  //  query.whereEqualTo("username", "Ross");
  //  query.setLimit(1); //Limits the amount of data return (1 Ross in this case)

    query.whereGreaterThan("score", 40);
  //This prints out everything thats under the Score category in the server
  query.findInBackground(new FindCallback<ParseObject>() {
    @Override
    public void done(List<ParseObject> objects, ParseException e) {
      if(e == null){
        if(objects.size() > 0){
          for(ParseObject object : objects){

            object.put("score", "70");
            object.saveInBackground();

            Log.i("username", object.getString("username"));
            Log.i("score", object.getString("score"));
          }
        }
      }
    }
  });
*/

/* Code for signing up
  ParseUser user = new ParseUser();
  user.setUsername("Ross");
  user.setPassword("samplePassword");

  user.signUpInBackground(new SignUpCallback() {
    @Override
    public void done(ParseException e) {
      if(e == null){
        Toast.makeText(MainActivity.this, "Sign up successful", Toast.LENGTH_SHORT).show();
      } else {
        e.printStackTrace();
      }
    }
  });


    ParseUser.logInInBackground("Ross", "samplePassword", new LogInCallback() {
      @Override
      public void done(ParseUser user, ParseException e) {
        if(e == null && user != null){
          Toast.makeText(MainActivity.this, "Welcome!", Toast.LENGTH_SHORT).show();
          Log.i("test", "Loggin succesful");
        } else {
          e.printStackTrace();
        }
      }
    });



//Check if there is already a user logged in
            if(ParseUser.getCurrentUser() != null) {
                //If not equal to null, someone is loggedIn
                Toast.makeText(this, ParseUser.getCurrentUser().getUsername() + " currently signed in", Toast.LENGTH_SHORT).show();
                ParseUser.logOut();
            } else {
                Toast.makeText(this, "No users currently signed in", Toast.LENGTH_SHORT).show();
            }


            ParseAnalytics.trackAppOpenedInBackground(getIntent());



        }

    }
}
*/