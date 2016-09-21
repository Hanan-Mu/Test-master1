package com.example.hanan.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);

        final Button next = (Button) findViewById(R.id.button2);

        next.setOnClickListener(new View.OnClickListener() {
          @Override
           public void onClick(View v) {
           Intent newUser = new Intent(MainActivity.this,signIn.class);
           startActivity(newUser);
          }
        }
       );

    }
}
