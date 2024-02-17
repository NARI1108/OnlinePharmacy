package com.example.online_pharmcy;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DataBaseManager extends SQLiteOpenHelper {

    //  private static final String DATABASE_NAME ="DrugsStore.db";
    private static final String DATABASE_NAME = "DrugsStore.db";
    private static final int VERSION = 1;
    public static final String TABLE_NAME_HONEY = "honey_tbl";
    public static final String TABLE_NAME_ALAYEM = "alayem_tbl";
    public static final String TABLE_NAME_AVAREZ = "avarez_tbl";
    public static final String TABLE_NAME_DURGS = "durgs_tbl";
    public static final String TABLE_NAME_SICKNESS = "sickness_tbl";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String KHAVASEASAL = "khavaseasal";
    private static final String GOROHE_DARO = "gorohedaro";
    private static final String MOREDEMASRAF = "moredemasraf";
    private static final String MIZANEMASRAF = "mizanemasraf";
    private static final String TOZIHAT = "tozihat";
    private static final String SHARHE_BIMARI = "sharhe_bimari";
    private static final String ALAYEM = "alayem";
    private static final String FAVORITE = "favorite";
    private static final String TEXT = "text";

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

        String sicknessQuery = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME_SICKNESS + " ( " + ID + " INTEGER PRIMARY KEY, " + NAME + " TEXT, " + SHARHE_BIMARI + " TEXT, " + ALAYEM + ALAYEM + " TEXT, " + FAVORITE + " INTEGER );";
        sqLiteDatabase.execSQL(sicknessQuery);
    }

    //  In short, this method is used to perform database update operations when the version changes.
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
    }

    //  The method of entering information about honey therapy into the database.
    public long insertHoneyData(Items items) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID, items.id_Items);
        contentValues.put(NAME, items.name_Items);
        contentValues.put(KHAVASEASAL, items.khavaseasal_Items);
        contentValues.put(FAVORITE, 0);
        return sqLiteDatabase.insert(TABLE_NAME_HONEY, null, contentValues);
    }

    //  The method of entering information about the symptoms of diseases into the database.
    public long insertAlayemData(Items items) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID, items.id_Items);
        contentValues.put(NAME, items.name_Items);
        return sqLiteDatabase.insert(TABLE_NAME_ALAYEM, null, contentValues);
    }

    //  The method of entering information about the complications of diseases into the database.
    public long insertAvarezData(Items items) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID, items.id_Items);
        contentValues.put(NAME, items.name_Items);
        contentValues.put(TEXT, items.text_Items);
        contentValues.put(FAVORITE, 0);
        return sqLiteDatabase.insert(TABLE_NAME_AVAREZ, null, contentValues);
    }
//    The method of entering information about drugs in the database.
    public long insertDurgsData(Items items){
        SQLiteDatabase sqliteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID, items.id_Items);
        contentValues.put(NAME, items.name_Items);
        contentValues.put(GOROHE_DARO, items.gorohedaro_Items);
        contentValues.put(MOREDEMASRAF, items.moredemasraf_Items);
        contentValues.put(MIZANEMASRAF, items.mizaneMasraf_Items);
        contentValues.put(TOZIHAT, items.tozihat_Items);
        contentValues.put(FAVORITE, 0);
        return sqliteDatabase.insert(TABLE_NAME_DURGS,null,contentValues);
    }
//  The method of entering information about sickness in the database.
    public long insertSicknessData(Items items){
        SQLiteDatabase sqliteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID, items.id_Items);
        contentValues.put(NAME, items.name_Items);
        contentValues.put(SHARHE_BIMARI, items.sharhebinari_Items);
        contentValues.put(ALAYEM, items.alayem_Items);
        contentValues.put(FAVORITE,0);
        return sqliteDatabase.insert(TABLE_NAME_SICKNESS,null,contentValues);
    }
//    The method of counting the number of data (rows) stored in the desired table in the database.
    public int count(String table_name){
        String query = "SELECT * FROM " + table_name + "WHERE " + FAVORITE + "=1";
        SQLiteDatabase sqliteDatabase =this.getReadableDatabase();
        Cursor cursor = sqliteDatabase.rawQuery(query,null);
        return cursor.getCount();
    }
//    The method of counting the number of rows that have been added to the favorites list.
    public int countFavorite(String table_name){
        String query = "SELECT * FROM " + table_name + "WHERE " + FAVORITE + "=1";
        SQLiteDatabase sqliteDatabase = this.getReadableDatabase();
        Cursor cursor = sqliteDatabase.rawQuery(query,null);
        return cursor.getCount();
    }
//    The method of displaying the information of a drug based on the name of the drug.
    @SuppressLint("Range")
    public Items showDrugs(String name){
        String showQuery = "SELECT * FROM " + TABLE_NAME_DURGS + " WHERE " + NAME + "='" + name + "'";
        SQLiteDatabase sqliteDatabase = this.getReadableDatabase();
        Cursor cursor = sqliteDatabase.rawQuery(showQuery,null);
        Items items = new Items();
        if (cursor.moveToFirst()){
            items.id_Items = cursor.getString(0);
            items.name_Items = cursor.getString(cursor.getColumnIndex(NAME));
            items.gorohedaro_Items = cursor.getString(cursor.getColumnIndex(GOROHE_DARO));
            items.moredemasraf_Items = cursor.getString(cursor.getColumnIndex(MOREDEMASRAF));
            items.mizaneMasraf_Items = cursor.getString(cursor.getColumnIndex(MIZANEMASRAF));
            items.tozihat_Items = cursor.getString(cursor.getColumnIndex(TOZIHAT));
            items.favorite = cursor.getInt(cursor.getColumnIndex(FAVORITE));
        }
        return items;
    }
//    The method of displaying the information of a disease based on the name of the disease.
    @SuppressLint("Range")
    public Items showSickness(String name){
        String showQuery = "SELECT * FROM " + TABLE_NAME_SICKNESS + " WHERE " + "='" + name + "'";
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(showQuery,null);
        Items items = new Items();
        if (cursor.moveToFirst()){
            items.id_Items = cursor.getString(0);
            items.name_Items = cursor.getString(cursor.getColumnIndex(NAME));
            items.sharhebinari_Items = cursor.getString(cursor.getColumnIndex(SHARHE_BIMARI));
            items.alayem_Items = cursor.getString(cursor.getColumnIndex(ALAYEM));
            items.favorite = cursor.getInt(cursor.getColumnIndex(FAVORITE));
        }
        return items;
    }
//    The method of searching in the list of diseases based on the symptoms of the disease.
    @SuppressLint("Range")
    public ArrayList<String> searchSickness(String alayem){
        String showQuery = "SELECT * FROM " + TABLE_NAME_SICKNESS + " WHERE " + ALAYEM + " LIKE '%" + alayem + "%'";
        SQLiteDatabase sqliteDatabase = this.getReadableDatabase();
        Cursor cursor = sqliteDatabase.rawQuery(showQuery,null);
        ArrayList<String> name_list = new ArrayList<>();
        if (cursor.moveToFirst()){
            do {
                name_list.add(cursor.getString(cursor.getColumnIndex(NAME)));
            }while(cursor.moveToNext());
        }
        return name_list;
    }
//    The method of displaying honey therapy information based on the title.
    @SuppressLint("Range")
    public Items showHoney(String name){
        String showQuery = "SELECT * FROM " + TABLE_NAME_HONEY + " WHERE " + NAME + "='" + name + "'";
        SQLiteDatabase  sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(showQuery,null);
        Items items = new Items();
        if (cursor.moveToFirst()){
            items.id_Items = cursor.getString(0);
            items.name_Items = cursor.getString(cursor.getColumnIndex(NAME));
            items.khavaseasal_Items = cursor.getString(cursor.getColumnIndex(KHAVASEASAL));
            items.favorite = cursor.getInt(cursor.getColumnIndex(FAVORITE));
        }
        return items;
    }
//   The method of displaying information on the complications of diseases.
    @SuppressLint("Range")
    public Items showAvarez(String name){
        String showQuery = "SELECT * FROM " + TABLE_NAME_AVAREZ + " WHERE " + NAME + "='" +name + "'";
        SQLiteDatabase sqliteDatabase = this.getReadableDatabase();
        Cursor cursor = sqliteDatabase.rawQuery(showQuery,null);
        Items items = new Items();
        if (cursor.moveToFirst()){
            items.id_Items = cursor.getString(0);
            items.name_Items = cursor.getString(cursor.getColumnIndex(NAME));
            items.text_Items = cursor.getString(cursor.getColumnIndex(TEXT));
            items.favorite = cursor.getInt(cursor.getColumnIndex(FAVORITE));
        }
        return items;
    }
}
