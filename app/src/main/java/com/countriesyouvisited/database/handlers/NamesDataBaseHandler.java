package com.countriesyouvisited.database.handlers;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.countriesyouvisited.database.objects.ContinentObject;
import com.countriesyouvisited.database.objects.NamesObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lysy on 2015-04-13.
 */
public class NamesDataBaseHandler {
    /***/
    public static final String TABLE_NAME = "Name";

    private static final String KEY_ID = "id";

    private static final String KEY_NAME_ENGLISH = "EN";


    /***/
    public static String getCreateSQL() {
        return "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME_ENGLISH + " TEXT)";
    }

    /***/
    public static List<NamesObject> getAll(SQLiteDatabase db) {
        List<NamesObject> namesList = new ArrayList<NamesObject>();
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                int idValue = Integer.parseInt(cursor.getString(0));
                String nameValue = cursor.getString(1);
                NamesObject item = new NamesObject(idValue, nameValue);
                namesList.add(item);
            }
            while (cursor.moveToNext());
        }

        return namesList;
    }

    /***/
    public static NamesObject get(int id, SQLiteDatabase db) {
        String[] values = new String[] { KEY_ID, KEY_NAME_ENGLISH};
        String where = KEY_ID + "=?";
        String[] whatValue = new String[] { String.valueOf(id) };
        Cursor cursor = db.query(TABLE_NAME, values, where, whatValue, null, null, null, null);

        return get(cursor);
    }

    /***/
    public static NamesObject get(String name, SQLiteDatabase db) {
        String[] values = new String[] { KEY_ID, KEY_NAME_ENGLISH};
        String where = KEY_NAME_ENGLISH + "=?";
        String[] whatValue = new String[] { name };
        Cursor cursor = db.query(TABLE_NAME, values, where, whatValue, null, null, null, null);

        return get(cursor);
    }

    private static NamesObject get(Cursor cursor) {
        if (cursor != null) {
            cursor.moveToFirst();

            if (cursor.getCount() > 0) {
                int idValue = Integer.parseInt(cursor.getString(0));
                String nameValue = cursor.getString(1);
                return new NamesObject(idValue, nameValue);
            }
        }

        return null;
    }
}
