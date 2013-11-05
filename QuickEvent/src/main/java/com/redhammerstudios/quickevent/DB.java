package com.redhammerstudios.quickevent;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;



import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DB extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "userData";
    private static final String TABLE_FRIENDS = "friends";
    private static final String KEY_ID = "id";
    private static final String KEY_FIRST_NAME = "first_name";
    private static final String KEY_LAST_NAME="last_name";
    private static final String KEY_DATE_ADDED = "date_added";
    private static final String KEY_PHONE_NUMBER = "phone_number";
    private static final String KEY_USER_NAME = "user_name";
    private static final String KEY_COUNT_OF_EVENTS = "count_of_events";


    public DB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_FRIENDS_TABLE = "CREATE TABLE " + TABLE_FRIENDS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_FIRST_NAME +" TEXT,"+ KEY_LAST_NAME + " TEXT,"+
                KEY_DATE_ADDED + " Date/Time," + KEY_PHONE_NUMBER + " TEXT" + KEY_USER_NAME + " TEXT,"+ KEY_COUNT_OF_EVENTS + " INTEGER" + ")";
        db.execSQL(CREATE_FRIENDS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FRIENDS);

        // Create tables again
        onCreate(db);
    }

    void addFriend(Friend friend) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID, friend.getId());
        values.put(KEY_FIRST_NAME, friend.getFirstName());
        values.put(KEY_LAST_NAME, friend.getLastName());
        values.put(KEY_DATE_ADDED, friend.getDateAdded().toString());
        values.put(KEY_PHONE_NUMBER, friend.getPhoneNumber());
        values.put(KEY_USER_NAME, friend.getUserName());
        values.put(KEY_COUNT_OF_EVENTS,


        // Inserting Row
        db.insert(TABLE_FRIENDS, null, values);
        db.close(); // Closing database connection
    }

    Friend getFriend(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_FRIENDS, new String[] { KEY_ID,
                KEY_FIRST_NAME,KEY_LAST_NAME, KEY_ }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Friend friend = new Friend(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));
        return friend;
    }

    public List<Friend> getAllFriends() {
        List<Friend> friendList = new ArrayList<Friend>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_FRIENDS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Friend friend = new Friend();
                friend.setId(Integer.parseInt(cursor.getString(0)));
                friend.setName(cursor.getString(1));
                friend.setPhoneNumber(cursor.getString(2));
                friendList.add(friend);
            } while (cursor.moveToNext());
        }

        return friendList;
    }

    public List<String> getAllFriendsStrings(){
        List<String> friendList = new ArrayList<String>();

        String selectQuery = "SELECT  * FROM " + TABLE_FRIENDS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Friend friend = new Friend();
                friend.setName(cursor.getString(1));
                friendList.add(friend.getName());
            } while (cursor.moveToNext());
        }

        return friendList;
    }


    public int updateFriend(Friend friend) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, friend.getName());
        values.put(KEY_PH_NO, friend.getPhoneNumber());

        // updating row
        return db.update(TABLE_FRIENDS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(friend.getId()) });
    }


    public void deleteFriend(Friend friend) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_FRIENDS, KEY_ID + " = ?",
                new String[] { String.valueOf(friend.getId()) });
        db.close();
    }


    public int getFriendsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_FRIENDS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }
}
