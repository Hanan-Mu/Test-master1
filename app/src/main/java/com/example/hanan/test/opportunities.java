package com.example.hanan.test;


import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.MenuItem;;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class opportunities extends AppCompatActivity {

    DrawerLayout drawerLayout ;
    Toolbar toolbar ;
    ArrayList<OpportunityCard> oppCard = new ArrayList<OpportunityCard>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.opp_recycle_view);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv);
      //initial data
        callInitialData();

        Adaptar adaptar = new Adaptar(oppCard ,this);
        LinearLayoutManager ln = new LinearLayoutManager(this);
        //GridLayoutManager gr = new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(ln);
        recyclerView.setAdapter(adaptar);

        toolbar = (Toolbar) findViewById(R.id.toolbar_layout);
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_opp_layout);
        callDrawerItem();

        ActionBar op_nav = getSupportActionBar();
        op_nav.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
        op_nav.setDisplayHomeAsUpEnabled(true);


    }

    public void callInitialData(){
        oppCard.add(new OpportunityCard(R.string.oppTitle1 ,R.string.oppText1 ,R.string.oppnum1,R.drawable.ppl ,R.drawable.in2));
        oppCard.add(new OpportunityCard(R.string.oppTitle2 ,R.string.oppText2 ,R.string.oppnum2,R.drawable.ppl ,R.drawable.end));
        oppCard.add(new OpportunityCard(R.string.oppTitle3 ,R.string.oppText3 ,R.string.oppnum3,R.drawable.ppl ,R.drawable.in2));
    }

    public void callDrawerItem(){
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(MenuItem item){
                Intent nextLayout;
                switch (item.getItemId()){
                    case R.id.activities:
                        nextLayout = new Intent(opportunities.this,opportunities.class);
                        startActivity(nextLayout);
                        return true ;
                    //case R.id.my_activities:
                    //getSupportFragmentManager().beginTransaction().add(R.id.frame_container,new BlankFragmen()).commit();
                    //return true;
                    case R.id.my_data:
                        nextLayout = new Intent(opportunities.this,myInfo.class);
                        startActivity(nextLayout);
                        return true ;
                    case R.id.about:
                        nextLayout = new Intent(opportunities.this,aboutApp.class);
                        startActivity(nextLayout);
                        return true ;
                    //case R.id.sign_out:
                    //  newUser = new Intent(opportunit.this,signI.class);
                    // startActivity(newUser);
                }
                return false;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home :
                drawerLayout.openDrawer(GravityCompat.START);
                return true ;
        }
        return super.onOptionsItemSelected(item);
    }
}

