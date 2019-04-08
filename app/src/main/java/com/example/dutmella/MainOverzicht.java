package com.example.dutmella;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


public class MainOverzicht extends Fragment {
    private Spinner spinner;
    private Button button;


    public MainOverzicht() {
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_overzicht_main, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState){
     super.onViewCreated(view, savedInstanceState);

     spinner = view.findViewById(R.id.spinnerSpel);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.speltakken));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        button =  view.findViewById(R.id.buttonOverzicht);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TotaalOverzicht.class);
                startActivity(intent);
            }
        });
    }


}
