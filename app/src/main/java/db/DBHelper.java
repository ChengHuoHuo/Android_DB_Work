package db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by 44223 on 2018/8/27.
 */

public class DBHelper extends SQLiteOpenHelper{

    public static final String DB_NAME = "test.db";
    public static final int DB_VERSION = 1;
    private static final String USER="t_user";
    private static final String Father="t_father";
    private static final String Mother="t_mother";
    private static final String Lover="t_lover";
    private static final String Grandpa="t_grandpa";
    private static final String Grandma="t_grandma";
    private static final String Grandfather="t_grandfather";
    private static final String Grandmother="t_grandmother";


    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+USER+"(name varchar(20) primary key,password varchar,email varchar)");
        db.execSQL("create table "+Father+"(id INTEGER PRIMARY KEY AUTOINCREMENT,name varchar(20),words varchar)");
        db.execSQL("create table "+Mother+"(id INTEGER PRIMARY KEY AUTOINCREMENT,name varchar(20),words varchar)");
        db.execSQL("create table "+Lover+"(id INTEGER PRIMARY KEY AUTOINCREMENT,name varchar(20),words varchar)");
        db.execSQL("create table "+Grandpa+"(id INTEGER PRIMARY KEY AUTOINCREMENT,name varchar(20),words varchar)");
        db.execSQL("create table "+Grandma+"(id INTEGER PRIMARY KEY AUTOINCREMENT,name varchar(20) ,words varchar)");
        db.execSQL("create table "+Grandfather+"(id INTEGER PRIMARY KEY AUTOINCREMENT,name varchar(20),words varchar)");
        db.execSQL("create table "+Grandmother+"(id INTEGER PRIMARY KEY AUTOINCREMENT,name varchar(20),words varchar)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i("UserDAOTest", "UpGrade!");
    }
}
