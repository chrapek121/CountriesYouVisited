package com.countriesyouvisited.database.objects;

/**
 * @author horodysk
 */
public class ContinentObject {
    private int id;

    private int name;



    /***/
    public ContinentObject(int id, int name) {
        this.id = id;
        this.name = name;
    }

    /***/
    public int getId() {
        return id;
    }

    /***/
    public int getName() {
        return name;
    }
}
