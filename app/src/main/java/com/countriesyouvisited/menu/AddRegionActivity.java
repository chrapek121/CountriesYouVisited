package com.countriesyouvisited.menu;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.countriesyouvisited.R;

public class AddRegionActivity extends Activity implements OnClickListener {

    Button button_add;
    Spinner spinnerContinents;
    Spinner spinnerCountruies;
    Spinner spinnerRegion;
    private String[] textContinents = {"Africa", "Antarctica", "Asia", "Australia", "Europe", "North America", "South America" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        button_add = (Button)(findViewById(R.id.add_button));
        button_add.setOnClickListener(this);
        

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.add_button:
                if(v==button_add) {
                    finish();
                    Toast.makeText(this, "Add visited place", Toast.LENGTH_SHORT).show();

                } break;
        }
    }
}
