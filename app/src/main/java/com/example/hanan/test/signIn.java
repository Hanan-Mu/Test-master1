package com.example.hanan.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class signIn extends AppCompatActivity {

    EditText email ,password ;
    String sEmail ,sPassword ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        email = (EditText)findViewById(R.id.signInEmail);
        password = (EditText)findViewById(R.id.signInPassword);

        final Button next = (Button) findViewById(R.id.newUser);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent newUser = new Intent(signIn.this,register.class);
             startActivity(newUser);
             }
           }
        );
    }
    public void userLogin(View view){
        sEmail = email.getText().toString();
        sPassword = password.getText().toString();
        String method = "Login";
        RegisterTasks registerTasks = new RegisterTasks(this);
        registerTasks.execute(method ,sEmail ,sPassword);
        startActivity(new Intent(this ,opportunities.class));
    }
}
