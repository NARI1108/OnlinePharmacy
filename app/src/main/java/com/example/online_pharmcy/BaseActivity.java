package com.example.online_pharmcy;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;
import tyrantgit.explosionfield.ExplosionField;

public class BaseActivity extends AppCompatActivity {
    ProgressDialog progressDialog;
    DataBaseManager dataBaseManager;
    boolean first_run = true;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    int tedad_honey_database,tedad_honey_server,tedad_alayem_database,tedad_alayem_server;
    int tedad_avarez_database,tedad_avarez_server,tedad_drugs_database,tedad_drugs_server;
    int tedad_sickness_database,tedad_sickness_server;
    final static String LIKE_GET_HONEY = "http://192.168.1.35/drugs/get_honey.php";
    final static String LIKE_GET_TEDAD = "http://192.168.1.35/drugs/get_tedad.php";
    final static String LIKE_GET_ALAYEM = "http://192.168.1.35/drugs/get_alayem.php";
    final static String LIKE_GET_AVAREZ = "http://192.168.1.35/drugs/get_avarez.php";
    final static String LIKE_GET_DRUGS = "http://192.168.1.35/drugs/get_drugs.php";
    final static String LIKE_GET_SICKNESS = "http://192.168.1.35/drugs/get_sickness.php";
    final static String DRUGS_STORE_DATA = "drugsStoreData";
    final static String FIRST_RUN = "firstrun";
    public static int DRUGS = 1;
    public static int SICKNESS = 2;
    public static int HONEY = 3;
    public static int AVAREZ = 4;
    public static int TASHKHIS = 5;

    RelativeLayout rlt_drugs,rlt_sickness,rlt_honey,rlt_avarez,rlt_bmi,rlt_tashkhis;
    TextView txt_drugs_tedad,txt_sickness_tedad,txt_honey_tedad,txt_avarez_tedad,txt_tashkhis_tedad;
    DrawerLayout drawer_layout;
    Toolbar toolbar;
    NavigationView navi_view;
    ExplosionField explosionField;
    int has_new_data_honey,has_new_data_avarez,has_new_data_drugs,has_new_data_alayem,has_new_data_sickness;
    Intent intent;

    Spinner spn_fonts;
    TextView txt_show,txt_font;
    SeekBar seek_size,seek_space;
    Switch mySwitch;

    final String [] fontsList = {"BMitra","BMorvarid","BNarm","BNasimBold","BNazanin","BRoya","BSetarehBold","BShiraz","BTehran","BTitrTGEBold"};
    public static final String FONT_SIZE = "font_size";
    public static final String FONT = "font";
    public static final String SCREEN = "screen";
    public static final String LINE_SPACING= "LineSpacing";
    int font_size , line_spacing;
    String font;
    boolean isScreenOn;

//    Method to get information from SharedPreferences.
    public void getSharedpref(){
        sharedPreferences = getSharedPreferences(MainActivity.DRUGS_STORE_DATA,MODE_PRIVATE);
        editor = sharedPreferences.edit();
        first_run = sharedPreferences.getBoolean(FIRST_RUN,true);
        font_size = sharedPreferences.getInt(FONT_SIZE,25);
        line_spacing = sharedPreferences.getInt(LINE_SPACING,10);
        font = sharedPreferences.getString(FONT,fontsList[0]);
        isScreenOn = sharedPreferences.getBoolean(SCREEN,false);
    }
}
