package com.countriesyouvisited.loading;

import android.content.Intent;
import android.os.Bundle;

import com.countriesyouvisited.MapsActivity;
import com.countriesyouvisited.R;

public class LogoApplication extends  SplashscreanActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setLogo(R.mipmap.logo_countries);
        }

        @Override
        void startActivity() {
            Intent intent = new Intent(LogoApplication.this, MapsActivity.class);
            startActivity(intent);
        }

    }


