package com.example.hanan.test;


import android.content.Intent;
import android.content.SharedPreferences;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class myInfo extends AppCompatActivity {

    TextView username ,email ,date ,gender ,phonenumber ,city ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_info);

        username = (TextView) findViewById(R.id.edit_name);
        email = (TextView) findViewById(R.id.edit_email);
        date = (TextView) findViewById(R.id.edit_date);
        gender = (TextView) findViewById(R.id.edit_gender);
        phonenumber = (TextView) findViewById(R.id.edit_phone);
        city = (TextView) findViewById(R.id.edit_city);




        //needs dataBase to retype the texts in textView


    }

}
