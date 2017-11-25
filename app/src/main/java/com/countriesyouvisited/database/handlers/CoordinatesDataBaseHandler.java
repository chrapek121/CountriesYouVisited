package com.countriesyouvisited.database.handlers;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.countriesyouvisited.database.objects.CoordinatesObject;
import com.countriesyouvisited.database.objects.NamesObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lysy on 2015-04-13.
 */
public class CoordinatesDataBaseHandler {
    /***/
    public static final String TABLE_NAME = "Coordinates";

    private static final String KEY_ID = "id";

    private static final String KEY_COORDINATES = "name";


    /***/
    public static String getCreateSQL() {
        return "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_COORDINATES + " TEXT)";
    }

    /***/
    public static List<CoordinatesObject> getAll(SQLiteDatabase db) {
        List<CoordinatesObject> namesList = new ArrayList<CoordinatesObject>();
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                int idValue = Integer.parseInt(cursor.getString(0));
                String coordinateValue = cursor.getString(1);
                CoordinatesObject item = new CoordinatesObject(idValue, coordinateValue);
                namesList.add(item);
            }
            while (cursor.moveToNext());
        }

        return namesList;
    }

    /***/
    public static CoordinatesObject get(int id, SQLiteDatabase db) {
        String[] values = new String[] { KEY_ID, KEY_COORDINATES};
        String where = KEY_ID + "=?";
        String[] whatValue = new String[] { String.valueOf(id) };
        Cursor cursor = db.query(TABLE_NAME, values, where, whatValue, null, null, null, null);

        return get(cursor);
    }

    /***/
    public static CoordinatesObject get(String name, SQLiteDatabase db) {
        String[] values = new String[] { KEY_ID, KEY_COORDINATES};
        String where = KEY_COORDINATES + "=?";
        String[] whatValue = new String[] { name };
        Cursor cursor = db.query(TABLE_NAME, values, where, whatValue, null, null, null, null);

        return get(cursor);
    }

    private static CoordinatesObject get(Cursor cursor) {
        if (cursor != null) {
            cursor.moveToFirst();

            if (cursor.getCount() > 0) {
                int idValue = Integer.parseInt(cursor.getString(0));
                String coordinateValue = cursor.getString(1);
                return new CoordinatesObject(idValue, coordinateValue);
            }
        }

        return null;
    }
}
