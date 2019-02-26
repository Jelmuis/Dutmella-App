package com.example.dutmella;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.util.Calendar;

public class Stookvergunning extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener{

    private static final String TAG = "MainActivity";

    private TextView mDisplaysDate, mDisplaysTime, mDisplayeDate, mDisplayeTime;
    private String diaTimeChecker, diaDateChecker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner mySpinner = (Spinner) findViewById(R.id.spinnerSpel);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(Stookvergunning.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.speltakken));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);

        //declaring textfields
        mDisplaysDate = (TextView) findViewById(R.id.editsDat);
        mDisplaysTime = (TextView) findViewById(R.id.editsTijd);

        mDisplayeDate = (TextView) findViewById(R.id.editeDat);
        mDisplayeTime = (TextView) findViewById(R.id.editeTijd);


        //Setting startDate dialog picker
        mDisplaysDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                setDiaDateChecker("sDate");
                datePicker.show(getSupportFragmentManager(), "Date Picker");


            }
        });
        //setting startTime dialog picker
        mDisplaysTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timePicker = new TimePickerFragment();
                setDiaTimeChecker("sTime");
                timePicker.show(getSupportFragmentManager(), "Start Time");
            }
        });
        //setting endDate dialog picker
        mDisplayeDate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                DialogFragment datepicker = new DatePickerFragment();
                setDiaDateChecker("eDate");
                datepicker.show(getSupportFragmentManager(), "Date picker");
            }
        });
        //setting endTime dialog picker
        mDisplayeTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timePicker = new TimePickerFragment();
                setDiaTimeChecker("eTime");
                timePicker.show(getSupportFragmentManager(), "End Time");
            }
        });
    }



    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        String time = hourOfDay + ":" + minute;
        if(getDiaTimeChecker().equals("sTime")){
            mDisplaysTime.setText(time);
        }else if (getDiaTimeChecker().equals("eTime")){
            mDisplayeTime.setText(time);
        }
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String currentDateString = DateFormat.getDateInstance().format(c.getTime());

        if(diaDateChecker.equals("sDate")){
            mDisplaysDate.setText(currentDateString);
        }else if(diaDateChecker.equals("eDate")){
            mDisplayeDate.setText(currentDateString);
        }
    }

    public void setDiaTimeChecker(String diaTimeChecker) {
        this.diaTimeChecker = diaTimeChecker;
    }
    public String getDiaTimeChecker(){
        return diaTimeChecker;
    }

    public void  setDiaDateChecker(String diaDateChecker){
        this.diaDateChecker = diaDateChecker;
    }
    public String getDiaDateChecker(){
        return diaDateChecker;
    }
}
