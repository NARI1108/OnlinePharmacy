package com.example.online_pharmcy;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
    Adapter adapter;
    boolean isSearching = false, foundSickness = false;
    ArrayList<String> search_list = new ArrayList<>();
    ArrayList<String> sickness_names_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fehrest);
        findViews();
        request_Catch();
        adapter();
        setEdt_search();
        setRcl_show();
    }

    //    this method is used to find and associate views in the application page.
    public void findViews() {
        rcl_show = findViewById(R.id.rcl_show);
        txt_title = findViewById(R.id.txt_title);
        edt_search = findViewById(R.id.edt_search);
    }
    //In short, this method is used to get the required information from the database based on the values received from the previous activity.
    private void request_Catch() {
//      With the first variable, we specify which topic information should be taken, and with the second variable, we specify whether it came to this page from the main activity or from the interests.
        dataType = getIntent().getIntExtra("datatype", 0);
        activity = getIntent().getStringExtra("activity");

        dataBaseManager = new DataBaseManager(this);
//       We made a condition that according to the desired subject, the request will be made to the database and the required information will be obtained
        if (dataType == MainActivity.DRUGS) {
            if (activity.equals("main")) {
                names_list = dataBaseManager.showNames(DataBaseManager.TABLE_NAME_DURGS);
            } else {
                names_list = dataBaseManager.showFavorite(DataBaseManager.TABLE_NAME_DURGS);
            }
            txt_title.setVisibility(View.VISIBLE);
            txt_title.setText(R.string.searchText_drugs);
        } else if (dataType == MainActivity.SICKNESS) {
            if (activity.equals("main")) {
                names_list = dataBaseManager.showNames(DataBaseManager.TABLE_NAME_SICKNESS);
            } else {
                names_list = dataBaseManager.showFavorite(DataBaseManager.TABLE_NAME_SICKNESS);
            }
            txt_title.setVisibility(View.VISIBLE);
            txt_title.setText(R.string.searchText_Sickness);
        } else if (dataType == MainActivity.HONEY) {
            if (activity.equals("main")) {
                names_list = dataBaseManager.showNames(DataBaseManager.TABLE_NAME_HONEY);
            } else {
                names_list = dataBaseManager.showFavorite(DataBaseManager.TABLE_NAME_HONEY);
            }
        } else if (dataType == MainActivity.AVAREZ) {
            if (activity.equals("main")) {
                names_list = dataBaseManager.showNames(DataBaseManager.TABLE_NAME_AVAREZ);
            } else {
                names_list = dataBaseManager.showFavorite(DataBaseManager.TABLE_NAME_AVAREZ);
            }
        } else if (dataType == MainActivity.TASHKHIS) {
            names_list = dataBaseManager.showNames(DataBaseManager.TABLE_NAME_ALAYEM);
            txt_title.setVisibility(View.VISIBLE);
            txt_title.setText(R.string.searchText_Tashkhis);
            rcl_show.setVisibility(View.GONE);
        }
    }
    //    Setting the adapter and connecting it to the recycler view.
    private void adapter() {
        adapter = new Adapter(this, names_list);
        rcl_show.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rcl_show.setAdapter(adapter);
    }
    //    This method is used to set events related to text changes in a text field (EditText). This method adds information to the text field that defines a listener for field text changes.
    private void setEdt_search() {
        edt_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void afterTextChanged(Editable editable) {
                foundSickness = false;
                searchName(editable.toString());
                if (editable.toString().trim().length() == 0) {
                    isSearching = false;
                } else {
                    isSearching = true;
                }
                if (dataType == MainActivity.TASHKHIS) txt_title.setVisibility(View.GONE);
            }
        });
    }
//    This method is used to set events for clicking on items in a list displayed using a RecyclerView.
    private void setRcl_show() {
        rcl_show.addOnItemTouchListener(new RecyclerItemClick(this, new RecyclerItemClick.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                if (dataType != MainActivity.TASHKHIS) {
                    String name;
                    if (isSearching) name = search_list.get(position);
                    else name = names_list.get(position);
                    Intent intent = new Intent(FehrestActivity.this, ShowDataActivity.class);
                    intent.putExtra("datatype", dataType);
                    intent.putExtra("name", name);
                    startActivity(intent);
                }
                if (dataType == MainActivity.TASHKHIS && foundSickness) {
                    Intent intent = new Intent(FehrestActivity.this, ShowDataActivity.class);
                    intent.putExtra("datatype", dataType);
                    intent.putExtra("name", sickness_names_list.get(position));
                    startActivity(intent);
                } else if (dataType == MainActivity.TASHKHIS && !foundSickness) {
                    if (sickness_names_list != null) sickness_names_list.clear();
                    sickness_names_list = dataBaseManager.searchSickness(search_list.get(position));
                    adapter = new Adapter(FehrestActivity.this, sickness_names_list);
                    rcl_show.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                    foundSickness = true;
                    txt_title.setVisibility(View.VISIBLE);
                    txt_title.setText(getString(R.string.List_sickness) + search_list.get(position) + getString(R.string.display));
                }
            }
        }));
    }
//    This onResume() method is used in an Activity and is called when the desired activity returns to the foreground and comes to the front of the screen again.
    @Override
    protected void onResume() {
//      We made a condition that if it was in the mode of displaying the interested ones, the list will be created every time you come to the activity, so that the items that are removed from the list will not be displayed.
        if (activity.equals("fav")) {
            if (dataType == MainActivity.DRUGS) {

                names_list = dataBaseManager.showFavorite(DataBaseManager.TABLE_NAME_DURGS);
                txt_title.setVisibility(View.VISIBLE);
                txt_title.setText(R.string.searchText_drugs);

            } else if (dataType == MainActivity.SICKNESS) {

                names_list = dataBaseManager.showFavorite(DataBaseManager.TABLE_NAME_SICKNESS);
                txt_title.setVisibility(View.VISIBLE);
                txt_title.setText(R.string.searchText_Sickness);

            } else if (dataType == MainActivity.HONEY) {

                names_list = dataBaseManager.showFavorite(DataBaseManager.TABLE_NAME_HONEY);

            } else if (dataType == MainActivity.AVAREZ) {

                names_list = dataBaseManager.showFavorite(DataBaseManager.TABLE_NAME_AVAREZ);
            }
            adapter = new Adapter(this, names_list);
            rcl_show.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            rcl_show.setAdapter(adapter);
        }
        super.onResume();
    }

}