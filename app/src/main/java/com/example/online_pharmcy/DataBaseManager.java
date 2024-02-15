package com.example.online_pharmcy;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseManager extends SQLiteOpenHelper {

//  private static final String DATABASE_NAME ="DrugsStore.db";
    private static final String DATABASE_NAME ="DrugsStore.db";
    private static final int VERSION = 1;
    public static final String TABLE_NAME_HONEY = "honey_tbl";
    public static final String TABLE_NAME_ALAYEM ="alayem_tbl";
    public static final String TABLE_NAME_AVAREZ ="avarez_tbl";
    public static final String TABLE_NAME_DURGS ="durgs_tbl";
    public static final String TABLE_NAME_SICKNESS ="sickness_tbl";
    private static final String  ID ="id";
    private static final String NAME ="name";
    private static final String KHAVASEASAL ="khavaseasal";
    private static final String GOROHE_DARO ="gorohedaro";
    private static final String MOREDEMASRAF = "moredemasraf";
    private static final String MIZANEMASRAF ="mizanemasraf";
    private static final String TOZIHAT ="tozihat";
    private static final String SHARHE_BIMARI ="sharhe_bimari";
    private static final String ALAYEM ="alayem";
    private static final String FAVORITE ="favorite";
    private static final String TEXT ="text";
//  Class constructor method.
    public DataBaseManager(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }
//  This piece of code is used in Android to create the required tables in the SQLite database.
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//     Query to create the required tables in the database.
        String myQuery = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME_HONEY + " ( " + ID + " INTEGER PRIMARY KEY, " + NAME + " TEXT, " + KHAVASEASAL + " TEXT, " + FAVORITE + " INTEGER );";
        sqLiteDatabase.execSQL(myQuery);

        String alayemQuery = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME_ALAYEM + " ( " + ID + " INTEGER PRIMARY KEY, " + NAME + " TEXT );";
        sqLiteDatabase.execSQL(alayemQuery);

        String avarezQuery = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME_AVAREZ + " ( " + ID + " INTEGER PRIMARY KEY,  " + NAME + " TEXT, " + TEXT + " TEXT, " + FAVORITE + " INTEGER );";
        sqLiteDatabase.execSQL(avarezQuery);

        String durgsQuery = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME_DURGS + " ( " + ID + " INTEGER PRIMARY KEY, " + NAME + " TEXT, " + GOROHE_DARO + " TEXT, " + MOREDEMASRAF + " TEXT, " + MIZANEMASRAF + " TEXT, " + TOZIHAT + " TEXT, " + FAVORITE + " INTEGER );";
        sqLiteDatabase.execSQL(durgsQuery);

        String sicknessQuery = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME_SICKNESS +" ( " + ID + " INTEGER PRIMARY KEY, " + NAME + " TEXT, " + SHARHE_BIMARI + " TEXT, " + ALAYEM + ALAYEM + " TEXT, " + FAVORITE + " INTEGER );";
        sqLiteDatabase.execSQL(sicknessQuery);
    }
//    In short, this method is used to perform database update operations when the version changes.
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {}
}
