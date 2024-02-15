package com.example.online_pharmcy;

import android.database.sqlite.SQLiteOpenHelper;

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

}
