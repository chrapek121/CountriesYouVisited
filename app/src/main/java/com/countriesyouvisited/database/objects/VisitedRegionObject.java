package com.countriesyouvisited.database.objects;

import com.countriesyouvisited.database.DataBaseHandler;

/**
 * @author horodysk
 */
public class VisitedRegionObject {
    private int id;

    private int region;

    private int month;

    private int year;

    /***/
    public VisitedRegionObject(int id) {
        this.id = id;
        region = 0;
        month = 0;
        year = 0;
    }

    /***/
    public VisitedRegionObject(int region, int month, int year) {
        id = 0;
        this.region = region;
        this.month = month;
        this.year = year;
    }

    /***/
    public VisitedRegionObject(int id, int region, int month, int year) {
        this.id = id;
        this.region = region;
        this.month = month;
        this.year = year;
    }

    /***/
    public int getId() {
        return id;
    }

    /***/
    public RegionObject getRegion(DataBaseHandler db) {
        return db.getRegion(region);
    }

    /***/
    public void setRegion(int region) {
        this.region = region;
    }

    /***/
    public int getRegionId() {
        return region;
    }

    /***/
    public String getDate() {
        return year + "/" + month;
    }

    /***/
    public int getMonth() {
        return month;
    }

    /***/
    public void setMonth(int month) {
        this.month = month;
    }

    /***/
    public int getYear() {
        return year;
    }

    /***/
    public void setYear(int year) {
        this.year = year;
    }

}
