package com.countriesyouvisited.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.countriesyouvisited.database.handlers.ContinentDataBaseHandler;
import com.countriesyouvisited.database.handlers.CountryDataBaseHandler;
import com.countriesyouvisited.database.handlers.NamesDataBaseHandler;
import com.countriesyouvisited.database.handlers.RegionDataBaseHandler;
import com.countriesyouvisited.database.objects.ContinentObject;
import com.countriesyouvisited.database.objects.CountryObject;
import com.countriesyouvisited.database.objects.NamesObject;
import com.countriesyouvisited.database.objects.RegionObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author horodysk
 */
public class SystemDataBaseHandler {

    /***/
    public void createSystemDatabase(SQLiteDatabase db, Context context) {
        try {
            InputStream input = context.getAssets().open("database/CountriesYouVisitedSystemData.sql");

            BufferedReader in = new BufferedReader(new InputStreamReader(input));
            String str;

            while ((str = in.readLine()) != null) {
                db.execSQL(str);
                Log.d("DATABASE ADDED", str);
            }

            in.close();
        } catch (IOException e) {
            Log.d("CYV_SystemData", e.getMessage());
        }

    }

    // CONTINENTS

    /***/
    public List<ContinentObject> getAllContinents(SQLiteDatabase db) {
        return ContinentDataBaseHandler.getAll(db);
    }

    /***/
    public List<String> getAllContinentsName(SQLiteDatabase db) {
        List<String> names = new ArrayList<String>();
        List<ContinentObject> objects = ContinentDataBaseHandler.getAll(db);

        for (ContinentObject ob : objects) {
            NamesObject name = getName(ob.getName(), db);
            String n = name.getName();
            names.add(n);
        }
        return names;
    }

    public List<ContinentObject> getAllContinentsObjects(SQLiteDatabase db) {
        return ContinentDataBaseHandler.getAll(db);
    }

    /***/
    public ContinentObject getContinent(int id, SQLiteDatabase db) {
        return ContinentDataBaseHandler.get(id, db);
    }

    /***/
    public ContinentObject getContinent(String name, SQLiteDatabase db) {
        return ContinentDataBaseHandler.get(name, db);
    }

    // COUNTRIES

    /**
     * Return all countries placed on selected continent
     */
    public List<CountryObject> getAllCountries(int id, SQLiteDatabase db) {
        return CountryDataBaseHandler.getAll(id, db);
    }

    /***/
    public List<String> getAllCountriesName(int nameId, SQLiteDatabase db) {
        ContinentObject continent = getContinent(nameId, db);
        if (continent == null) {
            Log.d("DATABASE_NULL_PROBLEM", "Not existing continent id: " + nameId);
        }
        int id = continent.getId();
        List<CountryObject> objects = CountryDataBaseHandler.getAll(id, db);


        List<String> names = new ArrayList<String>();
        for (CountryObject ob : objects) {
            String name = getName(ob.getName(), db).getName();
            names.add(name);
        }
        return names;
    }

    /***/
    public CountryObject getCountry(int id, SQLiteDatabase db) {
        return CountryDataBaseHandler.get(id, db);
    }

    /***/
    public CountryObject getCountry(String name, SQLiteDatabase db) {
        return CountryDataBaseHandler.get(name, db);
    }

    // REGIONS

    /**
     * Return all regions placed on selected country
     */
    public List<RegionObject> getAllRegions(int id, SQLiteDatabase db) {
        return RegionDataBaseHandler.getAll(id, db);
    }

    /***/
    public List<String> getAllRegionsName(int name, SQLiteDatabase db) {
        int id = getCountry(name, db).getId();
        List<RegionObject> objects = RegionDataBaseHandler.getAll(id, db);

        List<String> names = new ArrayList<String>();
        for (RegionObject ob : objects) {
            String n = getName(ob.getName(), db).getName();
            names.add(n);
        }
        return names;
    }

    /***/
    public RegionObject getRegion(int id, SQLiteDatabase db) {
        return RegionDataBaseHandler.get(id, db);
    }

    /***/
    public RegionObject getRegion(String name, SQLiteDatabase db) {
        return RegionDataBaseHandler.get(name, db);
    }

    /***/
    public NamesObject getName(int id, SQLiteDatabase db) {
        return NamesDataBaseHandler.get(id, db);
    }

    /***/
    public NamesObject getName(String name, SQLiteDatabase db) {
        return NamesDataBaseHandler.get(name, db);
    }

}
