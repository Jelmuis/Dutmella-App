package com.example.dutmella;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.dutmella.Model.Overnachting;
import com.example.dutmella.Model.Reservering;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.io.StringReader;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;

/**
 * @author : Sebastiaan Uijlen
 * Deze activity wordt aangeroepen wanneer de gebruiker vraagt om een overzicht van vergunningaanvragen. Wanneer deze dan op een enkele
 * reservering klikt wordt de gebruiker doorverwezen naar de klasse ResOverzicht.
 */
public class TotaalOverzicht extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_totaal_overzicht);

        //final TextView textView = (TextView)findViewById(R.id.textView);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://145.49.70.200:50651/BP3Webservice/webresources/model.overnight";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        buildItems(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
               // textView.setText(error.getMessage());
            }
        });
        queue.add(stringRequest);
    }

    public void buildItems(String response){
        try {
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(response)));
            NodeList velden = doc.getElementsByTagName("overnights");
            NodeList alVelden = (velden.item(0)).getChildNodes();
            ArrayList<String> deVelden = new ArrayList<>();
            final ArrayList<Overnachting> resArray = new ArrayList<>();
            Overnachting reservering = null;
            for(int i = 0; i < alVelden.getLength(); i++){

                Node n = alVelden.item(i);
                Node name = n.getChildNodes().item(1);
                Node nameId = n.getChildNodes().item(2);
                Node nameMaxLeaders = n.getChildNodes().item(3);
                Node nameMaxMembers = n.getChildNodes().item(4);
                Node nameMinLeaders = n.getChildNodes().item(5);
                Node nameMinMembers = n.getChildNodes().item(6);
                Node nameQtyLeaders = n.getChildNodes().item(7);
                Node nameQtyMembers = n.getChildNodes().item(8);
                Node nameSDate = n.getChildNodes().item(9);
                Node nameEDate = n.getChildNodes().item(0);

                String strName = name.getTextContent();
                String strNameId = nameId.getTextContent();
                String strMaxLeaders = nameMaxLeaders.getTextContent();
                String strMaxMembers = nameMaxMembers.getTextContent();
                String strMinLeaders = nameMinLeaders.getTextContent();
                String strMinMembers = nameMinMembers.getTextContent();
                String strQtyLeaders = nameQtyLeaders.getTextContent();
                String strQtyMembers = nameQtyMembers.getTextContent();
                String strSDate = nameSDate.getTextContent();
                String strEDate = nameEDate.getTextContent();

                reservering = new Overnachting(strName, strNameId, strMaxLeaders, strMaxMembers, strMinLeaders, strMinMembers, strQtyLeaders, strQtyMembers, strSDate, strEDate, strSDate, strEDate);
                resArray.add(reservering);


                deVelden.add(strName + "--- " + strSDate);
            }
//            AdapterOvernachting aOver = new AdapterOvernachting(this,0,resArray);
//            ListView lv = (ListView) findViewById(R.id.myList);
//            lv.setAdapter(aOver);

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, deVelden);
            ListView lv = (ListView)findViewById(R.id.myList);
            lv.setAdapter(adapter);

            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), ResOverzicht.class);
                intent.putExtra("NAME",resArray.get(position).getSpeltak_naam());
                intent.putExtra("ID",resArray.get(position).getIdOvernachting());
                intent.putExtra("MAX_AGE_LEAD",resArray.get(position).getMax_leeftijd_beg());
                intent.putExtra("MAX_AGE_MEMB",resArray.get(position).getMax_leeftijd_lid());
                intent.putExtra("MIN_AGE_LEAD",resArray.get(position).getMin_leeftijd_beg());
                intent.putExtra("MIN_AGE_MEMB",resArray.get(position).getMin_leeftijd_lid());
                intent.putExtra("QTY_LEAD",resArray.get(position).getAant_begeleiders());
                intent.putExtra("QTY_MEMB",resArray.get(position).getAant_leden());
                intent.putExtra("SDATE",resArray.get(position).getsDatum());
                intent.putExtra("EDATE",resArray.get(position).geteDatum());

                startActivity(intent);
                }
            });

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
