package com.example.hanan.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Hanan on 20/09/16.
 */
public class showOppDetails  extends AppCompatActivity {

    //Defining views
    private TextView textViewOppName;
    private TextView textViewOppSDate;
    private TextView textViewOppEDate;
    private TextView textViewOppSTime;
    private TextView textViewOppETime;
    private TextView textViewOppStatus;
    private TextView textViewOppDescription;
    private TextView textViewOppVNum;
    private TextView textViewOppCurrentVNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_opp_details);

        //Initializing Views
        textViewOppName = (TextView) findViewById(R.id.textViewOppName);
        textViewOppSDate = (TextView) findViewById(R.id.textViewOppSDate);
        textViewOppEDate = (TextView) findViewById(R.id.textViewOppEDate);
        textViewOppSTime = (TextView) findViewById(R.id.textViewOppSTime);
        textViewOppETime = (TextView) findViewById(R.id.textViewOppETime);
        textViewOppStatus = (TextView) findViewById(R.id.textViewOppStatus);
        textViewOppDescription = (TextView) findViewById(R.id.textViewOppDescription);
        textViewOppVNum = (TextView) findViewById(R.id.textViewOppVNum);
        textViewOppCurrentVNum = (TextView) findViewById(R.id.textViewOppCurrentV);


        //Getting intent
        Intent intent = getIntent();

        //Displaying values by fetching from intent
        textViewOppName.setText(intent.getStringExtra(allOpp.KEY_opp_NAME));
        textViewOppSDate.setText("من تاريخ: " + intent.getStringExtra(allOpp.KEY_opp_SDate));
        textViewOppEDate.setText("إلى تاريخ: " + intent.getStringExtra(allOpp.KEY_opp_EDate));
        textViewOppSTime.setText("الوقت: من: " + intent.getStringExtra(allOpp.KEY_opp_STime));
        textViewOppETime.setText("إلى:"+ intent.getStringExtra(allOpp.KEY_opp_ETime));
        //textViewOppStatus.setText("الحالة:"+intent.getStringExtra(allOpp.KEY_opp_status));
        textViewOppVNum.setText("العدد المطلوب: " + String.valueOf(intent.getIntExtra(allOpp.KEY_opp_v_num, 0)));
        textViewOppCurrentVNum.setText("عدد الفرص المتبقية: " + String.valueOf(intent.getIntExtra(allOpp.KEY_opp_current_v_num, 0)));
        //textViewOppDescription.setText("الوصف: " + intent.getStringExtra(allOpp.KEY_opp_description));

    }


}

