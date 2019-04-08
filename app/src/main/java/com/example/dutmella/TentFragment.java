package com.example.dutmella;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author : Jelle Muijsers
 * Dit Fragment wordt aangeroepen wanneer er op de afbeelding van de tent geklikt wordt. Hier krijgt de
 * gebruiker de optie om in te voeren hoeveel tenten hij/zij wil reserveren. Helaas hebben we dit niet door kunnen zetten
 * omdat we niet begrepen hoe we een insert in de database moesten maken.
 * */

public class TentFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters


    public TentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tent, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
    }

}
