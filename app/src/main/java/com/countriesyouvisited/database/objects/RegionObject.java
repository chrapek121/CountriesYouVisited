package com.countriesyouvisited.database.objects;

import android.support.annotation.NonNull;
import android.util.Pair;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * @author horodysk
 */
public class RegionObject{
    private int id;

    private int name;

    private int country;

    private int coordinates;


    /***/
    public RegionObject(int id, int name, int country, int coordinates) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.coordinates = coordinates;
    }

    /***/
    public int getId() {
        return id;
    }

    /***/
    public int getName() {
        return name;
    }

    /***/
    public int getCountryId() {
        return country;
    }

    /***/
    public int getCoordinatesId() {
        return coordinates;
    }






}
