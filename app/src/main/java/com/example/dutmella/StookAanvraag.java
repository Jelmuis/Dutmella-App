package com.example.dutmella;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * @author : Sebastiaan Uijlen
 * In dit fragment was het de bedoeling dat een gebruiker een stookvergunning aan kon vragen. Maar omdat we
 * nooit geleerd hebben hoe we een insert konden maken zijn we niet verder gekomen dan de infrastructuur te maken.
 *
 */

public class StookAanvraag extends Fragment {

    private Spinner spinnerSpel;
    private EditText sDate, sTime, eDate, eTime;
    private Button aanvrButton;

    public StookAanvraag() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_stook_aanvraag, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);

        spinnerSpel = view.findViewById(R.id.spinnerSpel);
        sDate = view.findViewById(R.id.editsDate);
        sTime = view.findViewById(R.id.editSTime);
        eDate = view.findViewById(R.id.editEDate);
        eTime = view.findViewById(R.id.editETime);
        aanvrButton = view.findViewById(R.id.aanvrButton);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.speltakken));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSpel.setAdapter(adapter);

    }

}
