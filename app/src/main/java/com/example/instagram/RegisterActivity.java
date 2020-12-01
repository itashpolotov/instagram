package com.example.instagram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;

import com.rengwuxian.materialedittext.MaterialEditText;


public class RegisterActivity extends AppCompatActivity {

    MaterialEditText username, email, password;
    Button signup_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        TextView signin;
        signin = findViewById(R.id.signin);
        signup_btn = findViewById(R.id.signup_btn);
        username = findViewById(R.id.login);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);



        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                    ParseUser user = new ParseUser();


                    user.setUsername(username.getText().toString());
                    user.setPassword(password.getText().toString());
                    user.setEmail(email.getText().toString());

                    user.signUpInBackground(new SignUpCallback() {
                        @Override
                        public void done(ParseException e) {
                            if (e == null) {
                                Log.i("Parse Result", "Succesful");
                                Toast.makeText(RegisterActivity.this, "Sucessful Sign Up!", Toast.LENGTH_LONG).show();
                            } else {
                                ParseUser.logOut();
                                Toast.makeText(RegisterActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }

                    });




                signin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                    }

                    ;
                });
            }
        });
    }
}


