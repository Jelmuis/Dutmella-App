package com.example.dutmella;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.dutmella.Model.Reservering;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.io.StringReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;

public class ReserveringenOverzichtActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserveringen_overzicht);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://145.49.70.200:50651/BP3Webservice/webresources/model.reservation";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        buildItems(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error.getMessage());
            }
        });
        queue.add(stringRequest);
    }

    public void buildItems(String response){
        try {
            DocumentBuilderFactory db = DocumentBuilderFactory.newInstance();
            db.setNamespaceAware(true);
            Document doc = db.newDocumentBuilder().parse(new InputSource(new StringReader(response)));
            NodeList velden = doc.getElementsByTagName("reservations");
            NodeList alVelden = (velden.item(0)).getChildNodes();
            ArrayList<String> deVelden = new ArrayList<>();

            for(int x = 0; x < alVelden.getLength(); x++) {
                NodeList reservation = alVelden.item(x).getChildNodes();

                Node vergunning = reservation.item(1);
                String strSoort = vergunning.getLocalName();


                NodeList persoon = reservation.item(0).getChildNodes();
                NodeList reserveringsrt = reservation.item(1).getChildNodes();
                Node starttijd =null;

                if (strSoort.equals("idIdcampfire") ) {
                     starttijd = reserveringsrt.item(3);
                }else if (strSoort.equals("idIdovernight")){
                     starttijd = reserveringsrt.item(9);
                }

                Node voornaam = persoon.item(1);
                Node achterNaam = persoon.item(2);
                Node telefoonnr = persoon.item(4);



                Node speltak = reserveringsrt.item(1);
                Node eindtijd = reserveringsrt.item(0);


                String strVoornaam = voornaam.getTextContent();
                String strAchternaam = achterNaam.getTextContent();
                String strTelefoonnr = telefoonnr.getTextContent();

                String strStarttijd = starttijd.getTextContent();
                String strSpeltak = speltak.getTextContent();
                String strEindtijd = eindtijd.getTextContent();

                deVelden.add("Voornaam: " + strVoornaam + "\nAchternaam: " + strAchternaam + "\nTelefoonnummer: "+ strTelefoonnr + "\n" + "\nStarttijd: " + strStarttijd + "\nSpeltak: " + strSpeltak + "\nEindtijd: " + strEindtijd + "\n");

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, deVelden);
                ListView lv = (ListView)findViewById(R.id.lv);
                lv.setAdapter(adapter);


            }

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
