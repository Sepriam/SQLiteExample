package com.example.matt.sqliteexample;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;
import android.preference.PreferenceFragment;

public class MyDBHandler extends SQLiteOpenHelper {

    /*
    creating variables to name the database, table, and columns within table
     */


    //note -- If new database required, must update the version number!
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Exercise.db";
    public static final String TABLE_PRODUCTS = "Exercises";
    public static final String COLUMN_EXERCISENAME =  "ExerciseName";
    public static final String COLUMN_ISSELECTED = "IsSelected";


    //Default contructor
    //Context - Background Info
    //Name - From DATABASE_NAME variable
    //Factory - Background information
    //Version - From DATABASE_VERSION variable
    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }


    //What do we want to do when we create the datbase
    @Override
    public void onCreate(SQLiteDatabase db) {

        //First -- Create the SQLite Database with the correct columns

        String query = "CREATE TABLE " + TABLE_PRODUCTS + "(" +
                COLUMN_EXERCISENAME + " TEXT " +
                COLUMN_ISSELECTED + " INTERGER " +
                ");";


        //db is the sqlitedatabase passed in parameters to function
        //execSQL - Execute the SQL
        //Executing our SQL to create the Database
        db.execSQL(query);

    }


    //What to do if you want to upgrade something
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        //delete the table if it exists
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_PRODUCTS);

        //create the new table
        onCreate(db);

    }


    //Adding a new row to the database
    public void addProduct(Exercises exercise)
    {

        //Class built into android
        //allows you to insert bunch of info into different columns in one statement.
        ContentValues values = new ContentValues();
        values.put(/*name of column*/ COLUMN_EXERCISENAME, /*What value*/ exercise.getExerciseName());

        int selectedIntValue;
        if (exercise.isSelected())
        {
            //if true then store as 1
            selectedIntValue = 1;
        }
        else
        {
            //if false, store as 0
            selectedIntValue = 0;
        }

        values.put(COLUMN_ISSELECTED, selectedIntValue);

        //write to the database
        SQLiteDatabase db = getWritableDatabase();

        //1st param - Name of table
        //2nd param - Opttional null
        //3rd param - Values
        //inserting values into aforementioned table
        db.insert(TABLE_PRODUCTS, null, values);

        //housekeeping
        db.close();
    }


    //Delete a product from the database
    public void deleteExercise(String exerciseName)
    {
        //write to the database
        SQLiteDatabase db = getWritableDatabase();

        //delete from table where ever the item in question contains the exercise in question.
        db.execSQL("DELETE FROM " + TABLE_PRODUCTS + " WHERE " + COLUMN_EXERCISENAME + " =\"" + exerciseName + "\";");

    }




}
