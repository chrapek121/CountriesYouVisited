package com.countriesyouvisited.menu;


import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.countriesyouvisited.R;
import com.countriesyouvisited.database.DataBaseHandler;
import com.countriesyouvisited.database.objects.ContinentObject;
import com.countriesyouvisited.database.objects.CountryObject;
import com.countriesyouvisited.database.objects.RegionObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AddActivity extends Activity implements OnClickListener, AdapterView.OnItemSelectedListener {

    Button button_add;
    Spinner spinnerContinents;
    Spinner spinnerCountruies;
    Spinner spinnerRegion;
    EditText date = null;
    DataBaseHandler db;
    private Typeface font;
    Map<String, ContinentObject> continentMap;
    Map<String, CountryObject> countryMap;
    Map<String, RegionObject> regionMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        button_add = (Button) (findViewById(R.id.add_button));
        button_add.setOnClickListener(this);
        db = new DataBaseHandler(this);

        spinnerContinents = (Spinner) findViewById(R.id.add_spinner_continents);
        spinnerCountruies = (Spinner) findViewById(R.id.add_spinner_countries);
        spinnerRegion = (Spinner) findViewById(R.id.add_spinner_region);

        spinnerContinents.setOnItemSelectedListener(this);
        spinnerCountruies.setOnItemSelectedListener(this);
        spinnerRegion.setOnItemSelectedListener(this);

        spinnerAdapter(spinnerContinents, continentMap.keySet());
        spinnerAdapter(spinnerCountruies, db.getAllCountriesName(getIdName(spinnerContinents)));
        spinnerAdapter(spinnerRegion, db.getAllRegionsName(getIdName(spinnerCountruies)));
        addDate();

    }

    private void fillContinents(){
        List <ContinentObject> continents = db.getAllContinents();

        for(ContinentObject continent:continents ){
            String name = "";
            continentMap.put(name, continent);
        }
    }

    private void spinnerAdapter(Spinner spinner, Set<String> data) {
        ArrayAdapter<String> adapterContinents = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, new ArrayList<String>(data));
        adapterContinents
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterContinents);
    }

    private void spinnerAdapter(Spinner spinner, List<String> data) {
        ArrayAdapter<String> adapterContinents = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, data);
        adapterContinents
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterContinents);
    }

    private int getIdName(Spinner spinner) {
        int nameId = (int) spinner.getSelectedItemId();
        return nameId ;
    }

    /*
    private String getName(Spinner spinner) {
        String name = (String) spinner.getSelectedItem();
        return name != null ? name : "";
    }
    */

    public void onItemSelected(AdapterView<?> parentView, View arg1, int arg2, long arg3) {
        TextView childAt = (TextView) parentView.getChildAt(0);
        if (childAt != null) {
            childAt.setTextColor(Color.BLACK);
            childAt.setTypeface(font);
        }

        switch (parentView.getId()) {
            case R.id.add_spinner_continents:
                spinnerAdapter(spinnerCountruies, db.getAllCountriesName(getIdName(spinnerContinents)));
                spinnerAdapter(spinnerRegion, db.getAllRegionsName(getIdName(spinnerCountruies)));
                break;

            case R.id.add_spinner_countries:
                spinnerAdapter(spinnerRegion, db.getAllRegionsName(getIdName(spinnerCountruies)));
                break;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    private void addDate() {
        date = (EditText) findViewById(R.id.add_date);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.add_button:
                if (v == button_add) {
                    if (date != null) {
                        finish();
                        Toast.makeText(this, "Add" + " " + spinnerContinents.getSelectedItem() + " " + spinnerCountruies.getSelectedItem() + " " + spinnerRegion.getSelectedItem() + " " + date.getText(), Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(this, "Enter the date", Toast.LENGTH_SHORT).show();
                    }

                }
                break;
        }
    }
}
