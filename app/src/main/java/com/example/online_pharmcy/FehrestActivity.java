package com.example.online_pharmcy;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class FehrestActivity extends AppCompatActivity {
    RecyclerView rcl_show;
    TextView txt_title;
    EditText edt_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fehrest);
    }
//    this method is used to find and associate views in the application page.
    public void findViews(){
        rcl_show = findViewById(R.id.rcl_show);
        txt_title = findViewById(R.id.txt_title);
        edt_search = findViewById(R.id. edt_search);
    }
}