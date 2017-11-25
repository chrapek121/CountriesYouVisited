package com.countriesyouvisited.database.handlers;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.countriesyouvisited.database.objects.RegionObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author horodysk
 */
public class RegionDataBaseHandler {
    /***/
    public static final String TABLE_NAME = "Regions";

    private static final String KEY_ID = "id";

    private static final String KEY_NAME = "name";

    private static final String KEY_PARENT = "countryId";

    private static final String KEY_COORDINATES = "coordinateId";

    /***/
    public static String getCreateSQL() {
        return "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " INTEGER," + KEY_PARENT + " INTEGER," +
                KEY_COORDINATES + " INTEGER)" ;
    }

    /***/
    public static List<RegionObject> getAll(int id, SQLiteDatabase db) {
        List<RegionObject> continentList = new ArrayList<RegionObject>();

        String[] values = new String[] { KEY_ID, KEY_NAME, KEY_PARENT, KEY_COORDINATES};
        String where = KEY_PARENT + "=?";
        String[] whatValue = new String[] { String.valueOf(id) };
        Cursor cursor = db.query(TABLE_NAME, values, where, whatValue, null, null, null, null);

        return getAll(continentList, cursor);
    }

    private static List<RegionObject> getAll(List<RegionObject> continentList, Cursor cursor) {
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                int idValue = Integer.parseInt(cursor.getString(0));
                int nameValue = Integer.parseInt(cursor.getString(1));
                int parentValue = Integer.parseInt(cursor.getString(2));
                int coordinatesValue = Integer.parseInt(cursor.getString(3));
                RegionObject item = new RegionObject(idValue, nameValue, parentValue, coordinatesValue);
                continentList.add(item);
            }
            while (cursor.moveToNext());
        }

        return continentList;
    }

    /***/
    public static RegionObject get(int id, SQLiteDatabase db) {
        String[] values = new String[] { KEY_ID, KEY_NAME, KEY_PARENT, KEY_COORDINATES};
        String where = KEY_ID + "=?";
        String[] whatValue = new String[] { String.valueOf(id) };
        Cursor cursor = db.query(TABLE_NAME, values, where, whatValue, null, null, null, null);

        return get(cursor);
    }

    /***/
    public static RegionObject get(String name, SQLiteDatabase db) {
        String[] values = new String[] { KEY_ID, KEY_NAME, KEY_PARENT, KEY_COORDINATES};
        String where = KEY_NAME + "=?";
        String[] whatValue = new String[] { String.valueOf(name) };
        Cursor cursor = db.query(TABLE_NAME, values, where, whatValue, null, null, null, null);

        return get(cursor);
    }

    private static RegionObject get(Cursor cursor) {
        if (cursor != null) {
            cursor.moveToFirst();

            if (cursor.getCount() > 0) {
                Log.d("REGION DB", cursor.getColumnCount() + "");
                int idValue = Integer.parseInt(cursor.getString(0));
                int nameValue = Integer.parseInt(cursor.getString(1));
                int parentValue = Integer.parseInt(cursor.getString(2));
                int coordinatesValue = Integer.parseInt(cursor.getString(3));

                return new RegionObject(idValue, nameValue, parentValue, coordinatesValue);
            }
        }

        return null;
    }
}
