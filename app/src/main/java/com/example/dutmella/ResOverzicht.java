package com.example.dutmella;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * @author : Sebastiaan Uijlen
 * In deze activity krijgt de gebruiker een specifiek overzicht te zien van de aangevraagde vergunning en de bijbehorende informatie.
 *
 */
public class ResOverzicht extends AppCompatActivity {
    private TextView naam, id, maxLeid, maxLid, minLeid, minLid, aantLeid, aantLid, sDate, eDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res_overzicht);

        Intent intent = getIntent();
        String msgNaam = intent.getStringExtra("NAME");
        String msgId = intent.getStringExtra("ID");
        String msgMaxLeid = intent.getStringExtra("MAX_AGE_LEAD");
        String msgMaxLid = intent.getStringExtra("MAX_AGE_MEMB");
        String msgMinLeid = intent.getStringExtra("MIN_AGE_LEAD");
        String msgMinLid = intent.getStringExtra("MIN_AGE_MEMB");
        String msgAantLeid = intent.getStringExtra("QTY_LEAD");
        String msgAantLid = intent.getStringExtra("QTY_MEMB");
        String msgSDat = intent.getStringExtra("SDATE");
        String msgEDat = intent.getStringExtra("EDATE");


        naam = (TextView) findViewById(R.id.viewSpeltak);
        id = (TextView) findViewById(R.id.viewID);
        maxLeid = (TextView) findViewById(R.id.viewMaxLeid);
        maxLid= (TextView) findViewById(R.id.viewMaxLid);
        minLeid = (TextView) findViewById(R.id.viewMidLeid);
        minLid = (TextView) findViewById(R.id.viewMinLid);
        aantLeid = (TextView) findViewById(R.id.viewAantLeid);
        aantLid = (TextView) findViewById(R.id.viewAantLid);
        sDate = (TextView) findViewById(R.id.viewSdat);
        eDate = (TextView) findViewById(R.id.viewEdat);

        naam.setText(msgNaam);
        id.setText(msgId);
        maxLeid.setText(msgMaxLeid);
        maxLid.setText(msgMaxLid);
        minLeid.setText(msgMinLeid);
        minLid.setText(msgMinLid);
        aantLeid.setText(msgAantLeid);
        aantLid.setText(msgAantLid);
        sDate.setText(msgSDat);
        eDate.setText(msgEDat);
    }
}
