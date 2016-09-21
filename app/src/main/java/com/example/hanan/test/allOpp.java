package com.example.hanan.test;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.hanan.test.model.Opportunity;
import com.example.hanan.test.service.oppAPI;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Hanan on 20/09/16.
 */
public class allOpp extends AppCompatActivity implements ListView.OnItemClickListener{

        //Root URL of our web service
        public static final String ROOT_URL = "http://10.0.2.2/API.php";
        public static final String  KEY_opp_NAME = "key_opp_name";
        public static final String  KEY_opp_SDate = "key_opp_SDate";
        public static final String  KEY_opp_EDate = "key_opp_EDate";
        public static final String  KEY_opp_STime = "key_opp_STime";
        public static final String  KEY_opp_ETime = "key_opp_ETime";
        public static final String  KEY_opp_status = "key_opp_status";
        public static final String  KEY_opp_description = "key_opp_description";
        public static final String  KEY_opp_v_num = "key_opp_v_num";
        public static final String  KEY_opp_current_v_num = "key_opp_current_v_num";
        //List view to show data
        private ListView listView;

        private List<Opportunity> opportunities;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_all_opp);

            //Initializing the listview
            listView = (ListView) findViewById(R.id.listViewOpportunities);

            //Calling the method that will fetch data
            getInfo();

            //Setting onItemClickListener to listview
            listView.setOnItemClickListener(this);
        }

        private void getInfo(){
            //While the app fetched data we are displaying a progress dialog
            final ProgressDialog loading = ProgressDialog.show(this,"Fetching Data","Please wait...",false,false);

            //Creating a rest adapter
            RestAdapter adapter = new RestAdapter.Builder()
                    .setEndpoint(ROOT_URL)
                    .build();

            //Creating an object of our api interface
            oppAPI api = adapter.create(oppAPI.class);

            //Defining the method
            api.getOppInfo(new Callback<List<Opportunity>>() {
                @Override
                public void success(List<Opportunity> list, Response response) {
                    //Dismissing the loading progressbar
                    loading.dismiss();

                    //Storing the data in our list
                    opportunities = list;

                    //Calling a method to show the list
                    showList();
                }

                @Override
                public void failure(RetrofitError error) {
                    //you can handle the errors here
                }
            });
        }

        //Our method to show list
        private void showList(){
            //String array to store all the opportunities names
            String[] items = new String[opportunities.size()];

            //Traversing through the whole list to get all the names
            for(int i=0; i<opportunities.size(); i++){
                //Storing names to string array
                items[i] = opportunities.get(i).getName();
            }

            //Creating an array adapter for list view
            ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.simple_list,items);

            //Setting adapter to listview
            listView.setAdapter(adapter);
        }


        //This method will execute on listitem click
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //Creating an intent
            Intent intent = new Intent(this, showOppDetails.class);

            //Getting the requested opportunity from the list
            Opportunity opportunity = opportunities.get(position);

            //Adding opportunity details to intent
            intent.putExtra(KEY_opp_NAME,opportunity.getName());
            intent.putExtra(KEY_opp_SDate,opportunity.getSDate());
            intent.putExtra(KEY_opp_EDate,opportunity.getEDate());
            intent.putExtra(KEY_opp_STime,opportunity.getSTime());
            intent.putExtra(KEY_opp_ETime,opportunity.getETime());
            intent.putExtra(KEY_opp_status,opportunity.getStatus());
            intent.putExtra(KEY_opp_description,opportunity.getDescription());
            intent.putExtra(KEY_opp_current_v_num,opportunity.getCurrent_num_of_v());
            intent.putExtra(KEY_opp_v_num,opportunity.getNum_of_v());
            //Starting another activity to show opportunity details
            startActivity(intent);
        }
}


