package com.countriesyouvisited.database.objects;


import android.support.annotation.NonNull;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @author horodysk
 */
public class CountryObject {
    private int id;

    private int name;

    private int continent;


    /***/
    public CountryObject(int id, int name, int continent) {
        this.id = id;
        this.name = name;
        this.continent = continent;

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
    public int getContinentId() {
        return continent;
    }

    /***/


}
