package com.countriesyouvisited.database.objects;

import java.io.File;

/**
 * Created by Lysy on 2015-04-13.
 */
public class CoordinatesObject {

    private int id;

    private String file;



    /***/
    public CoordinatesObject(int id, String file) {
        this.id = id;
        this.file = file;
    }

    /***/
    public int getId() {
        return id;
    }

    /***/
    public String getName() {
        return file;
    }
}
