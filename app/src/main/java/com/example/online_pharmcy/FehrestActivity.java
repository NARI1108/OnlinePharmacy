package com.example.online_pharmcy;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FehrestActivity extends AppCompatActivity {
    RecyclerView rcl_show;
    TextView txt_title;
    EditText edt_search;
    DataBaseManager dataBaseManager;
    int dataType;
    String activity;
    ArrayList<String> names_list;
    Adapter  adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fehrest);
        findViews();
        request_Catch();
        adapter();
    }
//    this method is used to find and associate views in the application page.
    public void findViews(){
        rcl_show = findViewById(R.id.rcl_show);
        txt_title = findViewById(R.id.txt_title);
        edt_search = findViewById(R.id. edt_search);
    }
//In short, this method is used to get the required information from the database based on the values received from the previous activity.
    private void request_Catch(){
//      With the first variable, we specify which topic information should be taken, and with the second variable, we specify whether it came to this page from the main activity or from the interests.
        dataType = getIntent().getIntExtra("datatype",0);
        activity = getIntent().getStringExtra("activity");

        dataBaseManager = new DataBaseManager(this);
//       We made a condition that according to the desired subject, the request will be made to the database and the required information will be obtained
        if (dataType== MainActivity.DRUGS){
            if (activity.equals("main")){names_list = dataBaseManager.showNames(DataBaseManager.TABLE_NAME_DURGS);}else {
                names_list = dataBaseManager.showFavorite(DataBaseManager.TABLE_NAME_DURGS);}
            txt_title.setVisibility(View.VISIBLE);
            txt_title.setText(R.string.searchText_drugs);
        }else if (dataType== MainActivity.SICKNESS){
            if (activity.equals("main")){names_list = dataBaseManager.showNames(DataBaseManager.TABLE_NAME_SICKNESS);}else {
                names_list = dataBaseManager.showFavorite(DataBaseManager.TABLE_NAME_SICKNESS);}
            txt_title.setVisibility(View.VISIBLE);
            txt_title.setText(R.string.searchText_Sickness);
        }else if (dataType== MainActivity.HONEY){
            if (activity.equals("main")){names_list = dataBaseManager.showNames(DataBaseManager.TABLE_NAME_HONEY);}else {
                names_list = dataBaseManager.showFavorite(DataBaseManager.TABLE_NAME_HONEY);}
        }else if (dataType== MainActivity.AVAREZ){
            if (activity.equals("main")){names_list = dataBaseManager.showNames(DataBaseManager.TABLE_NAME_AVAREZ);}else {
                names_list = dataBaseManager.showFavorite(DataBaseManager.TABLE_NAME_AVAREZ);}
        }else if (dataType== MainActivity.TASHKHIS){
            names_list = dataBaseManager.showNames(DataBaseManager.TABLE_NAME_ALAYEM);
            txt_title.setVisibility(View.VISIBLE);
            txt_title.setText(R.string.searchText_Tashkhis);
            rcl_show.setVisibility(View.GONE);
        }
    }
//    Setting the adapter and connecting it to the recycler view.
    private void adapter(){
        adapter = new Adapter(this,names_list);
        rcl_show.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        rcl_show.setAdapter(adapter);
    }
}