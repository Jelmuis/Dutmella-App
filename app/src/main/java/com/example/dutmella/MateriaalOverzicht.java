package com.example.dutmella;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

/**
 * @author : Jelle Muijsers
 * In dit fragment krijgt de gebruiker een overzicht te zien van de te reserveren items. Wanneer de gebruiker op
 * een voorwerp klikt wordt deze doorverwezen naar een reserveringspagina waar de gegevens ingevuld kunnen worden om de reservering mogelijk te maken.
 */

public class MateriaalOverzicht extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_materiaal_overzicht, container, false);


    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        ImageView tentButton = view.findViewById(R.id.reserverentent);
        tentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.fragment_container, new TentFragment());
                    ft.commit();

            }
        });

        ImageView touwButton = view.findViewById(R.id.reserverentouw);
        touwButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container, new TouwFragment());
                ft.commit();
            }
        });

        ImageView gasstelButton = view.findViewById(R.id.reserverengasbrander);
        gasstelButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container, new GasstelFragment());
            }
        });

       ImageView paalButton = view.findViewById(R.id.reserverenpionierpaal);
       paalButton.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick (View v){
               FragmentTransaction ft = getFragmentManager().beginTransaction();
               ft.replace(R.id.fragment_container, new PaalFragment());
           }
       });
    }



}