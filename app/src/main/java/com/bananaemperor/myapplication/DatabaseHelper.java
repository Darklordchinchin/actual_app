package com.bananaemperor.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {  //This activity is supposed to make my SQlite database work

    private Context context;
    private static final String DATABASE_NAME = "QuestData";         //Give the database its name
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "quest_info";        //Gives the database table its name
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_QUEST = "quest_name";


    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {  //Creates the database
        db.execSQL("CREATE TABLE " + TABLE_NAME +"(COLUMN_ID integer primary key, COLUMN_QUEST TEXT)");  //Defines the tables arrangement

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    void add_quest(String quest_name) {        //Adds the quest to the database
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_QUEST, quest_name);

        long result = db.insert(TABLE_NAME, null, cv); //Checks if the quest has been added
        if(result == -1) {
            Toast.makeText(context, "Not saved", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Saved successfully", Toast.LENGTH_SHORT).show();
        }

    }
}
