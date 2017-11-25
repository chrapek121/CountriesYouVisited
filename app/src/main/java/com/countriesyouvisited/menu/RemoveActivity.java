package com.countriesyouvisited.menu;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.countriesyouvisited.R;
import com.countriesyouvisited.database.CountryListViewAdapter;
import com.countriesyouvisited.database.DataBaseHandler;
import com.countriesyouvisited.database.objects.VisitedRegionObject;

import java.util.ArrayList;
import java.util.List;

public class RemoveActivity extends Activity implements View.OnClickListener {

    private Button button_remove;
    private Spinner spinnerContinents;
    private Spinner spinnerCountruies;
    private Spinner spinnerRegion;
    private TextView textViewContinents;
    private TextView textViewCountries;
    private TextView textViewregion;
    private FrameLayout frameLayout;



    private String[] textContinents = {"Africa", "Antarctica", "Asia", "Australia", "Europe", "North America", "South America" };

    //Countries
    private String[] textCountriesEurope =  {"France","German","Poland"};

    //Region
    private String[] textRegionPoland = {"dolnośląskie", "kujawsko-pomorskie", "lubelskie", "lubuskie", "łódzkie", "małopolskie", "mazowieckie", "opolskie", "podkarpackie", "podlaskie", "pomorskie", "śląskie","świętokrzyskie", "warmińsko-mazurskie", "wielkopolskie", "zachodniopomorskie"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove);

        button_remove = (Button)(findViewById(R.id.remove_button));
        button_remove.setOnClickListener(this);

        frameLayout = (FrameLayout) findViewById(R.id.remove_frameLayout);

        spinnerContinents = (Spinner) findViewById(R.id.remove_spinner_continents);
        spinnerCountruies = (Spinner) findViewById(R.id.remove_spinner_countries);
        spinnerRegion = (Spinner) findViewById(R.id.remove_spinner_region);

        spinnerAdapter(spinnerContinents, textContinents);
        spinnerAdapter(spinnerCountruies, textCountriesEurope);
        spinnerAdapter(spinnerRegion, textRegionPoland);



        txtRemoveAdapterContinents();
        txtRemoveAdapterCountries();
        txtRemoveAdapterRegion();
    }

    private void spinnerAdapter(Spinner spinner, String[] data) {
        ArrayAdapter<String> adapterContinents = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, data);
        adapterContinents
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterContinents);
    }



    private void txtRemoveAdapterContinents() {
         textViewContinents = (TextView) findViewById(R.id.remove_textView_continents);
         textViewContinents.setText("" + spinnerContinents.getSelectedItem());
        }

    private void txtRemoveAdapterCountries() {
        textViewCountries = (TextView) findViewById(R.id.remove_textView_countries);
        textViewCountries.setText("" + spinnerCountruies.getSelectedItem());
    }

    private void txtRemoveAdapterRegion() {
        textViewregion= (TextView) findViewById(R.id.remove_textView_region);
        textViewregion.setText("" + spinnerRegion.getSelectedItem());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.remove_button:
                if(v==button_remove) {
                    frameLayout.removeAllViews();
                    Toast.makeText(this, "Remove" + " " + spinnerContinents.getSelectedItem() + " " + spinnerCountruies.getSelectedItem() + " " + spinnerRegion.getSelectedItem(), Toast.LENGTH_LONG).show();

                } break;
        }
    }
}
