package com.countriesyouvisited.database.objects;

/**
 * Created by Lysy on 2015-04-13.
 */
public class NamesObject {

    private int id;

    private String name;



    /***/
    public NamesObject(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /***/
    public int getId() {
        return id;
    }

    /***/
    public String getName() {
        return name;
    }
}
