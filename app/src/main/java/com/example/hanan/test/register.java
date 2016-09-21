package com.example.hanan.test;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hanan.test.service.registerAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class register extends AppCompatActivity implements View.OnClickListener {

    //Declaring views
    private EditText editTextName;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private EditText editTextDate;
    private EditText editTextGender;
    private EditText editTextPhone;
    private EditText editTextCity;
    private Button buttonRegister;

    //This is our root url
    public static final String ROOT_URL = "http://10.0.2.2/API.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Initializing Views
        editTextName = (EditText) findViewById(R.id.edit_name);
        editTextEmail = (EditText) findViewById(R.id.edit_email);
        editTextPassword = (EditText) findViewById(R.id.edit_password1);
        editTextDate = (EditText) findViewById(R.id.edit_date);
        editTextGender = (EditText) findViewById(R.id.edit_gender);
        editTextPhone = (EditText) findViewById(R.id.edit_phone);
        editTextCity = (EditText) findViewById(R.id.edit_city);
        buttonRegister = (Button) findViewById(R.id.button_register);

        //Adding listener to button
        buttonRegister.setOnClickListener(this);
    }


    private void insertUser(){
        //Creating a RestAdapter
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(ROOT_URL) //Setting the Root URL
                .build(); //Finally building the adapter

        //Creating object for our interface
        registerAPI api = adapter.create(registerAPI.class);

        //Defining the method insertuser of our interface
        api.insertUser(

                //Passing the values by getting it from editTexts
                editTextName.getText().toString(),
                editTextEmail.getText().toString(),
                editTextPassword.getText().toString(),
                editTextDate.getText().toString(),
                editTextGender.getText().toString(),
                editTextPhone.getText().toString(),
                editTextCity.getText().toString(),
                //Creating an anonymous callback
                new Callback<Response>() {
                    @Override
                    public void success(Response result, Response response) {
                        //On success we will read the server's output using bufferedreader
                        //Creating a bufferedreader object
                        BufferedReader reader = null;

                        //An string to store output from the server
                        String output = "";

                        try {
                            //Initializing buffered reader
                            reader = new BufferedReader(new InputStreamReader(result.getBody().in()));

                            //Reading the output in the string
                            output = reader.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        //Displaying the output as a toast
                       // Toast.makeText(register.this, output, Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        //If any error occur displaying the error as toast
                        Toast.makeText(register.this, error.toString(),Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
    //Overriding onclick method
    @Override
    public void onClick(View v) {
        //Calling insertUser on button click
        insertUser();
        Intent opportunities = new Intent(register.this,allOpp.class);
        startActivity(opportunities);
    }
}