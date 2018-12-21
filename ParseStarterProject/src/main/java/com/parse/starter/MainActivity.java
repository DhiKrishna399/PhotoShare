/*
 * Copyright (c) 2015-present, Parse, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package com.parse.starter;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.gms.vision.text.Line;
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


public class MainActivity extends AppCompatActivity implements View.OnKeyListener, View.OnClickListener {

  EditText username;
  EditText password;
  ImageView logo;
  LinearLayout layout;

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.backgroundLayout || view.getId() == R.id.imageView) {

            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0 );

        }
    }

    public void signupClicked(View view){

    if(username.getText().toString().matches("") || password.getText().toString().matches("")){
      Toast.makeText(this, "Username and password required", Toast.LENGTH_SHORT).show();
    } else {
      ParseUser user = new ParseUser();
      user.setUsername(username.getText().toString());
      user.setPassword(password.getText().toString());

      user.signUpInBackground(new SignUpCallback() {
        @Override
        public void done(ParseException e) {
          if(e == null){
            Toast.makeText(MainActivity.this, "Succesfully created account!", Toast.LENGTH_SHORT).show();
          } else {
            e.printStackTrace();
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
          }
        }
      });
      showUserActivity();
    }


  }

  public void loginClicked(View view){

    ParseUser.logInInBackground(username.getText().toString(), password.getText().toString(), new LogInCallback() {
      @Override
      public void done(ParseUser user, ParseException e) {
        if(user != null){
          Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
          showUserActivity();
        } else {
          Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
      }
    });


  }

  public void showUserActivity(){
      Intent intent = new Intent(this, UserActivity.class);
      startActivity(intent);
  }



  public boolean onKey(View view, int i, KeyEvent keyEvent){

    //Method to hit enter key and login
    if(i == KeyEvent.KEYCODE_ENTER && keyEvent.getAction() == KeyEvent.ACTION_DOWN) {
      loginClicked(view);
    }
    return false;
  }


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    setTitle("PhotoShare");
    username = findViewById(R.id.usernameText);
    password = findViewById(R.id.passwordText);
    layout = findViewById(R.id.backgroundLayout);
    logo = findViewById(R.id.imageView);

    password.setOnKeyListener(this);
    logo.setOnClickListener(this);
    layout.setOnClickListener(this);



    if(ParseUser.getCurrentUser() != null){
      showUserActivity();
    }


    
    ParseAnalytics.trackAppOpenedInBackground(getIntent());

  }




}