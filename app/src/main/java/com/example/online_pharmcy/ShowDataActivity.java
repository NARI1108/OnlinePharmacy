package com.example.online_pharmcy;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class ShowDataActivity extends BaseActivity {
    TextView txt_Name, txt_GroheDaro, txt_MoredeMasraf, txt_Mizanemasraf, txt_tozihat,gorohedaro,MoredeMasraf, Mizanemasraf, tozihat;
    View layout1,layout2,layout3,layout4;
    ImageView imgCopy,imgShare,imgSms,imgFav;
    SeekBar seek_size;
    int dataType, isFavorite,id;
    String name, table_name, text_share="";
    DataBaseManager dataBaseManager;
    Items items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);
        findViews();
    }
//    this method is used to find and associate views in the application page.
    private void findViews(){
        txt_Name =findViewById(R.id.txt_Name);
        txt_GroheDaro =findViewById(R.id.txt_grohedaro);
        txt_MoredeMasraf =findViewById(R.id.txt_moredemasraf);
        txt_Mizanemasraf =findViewById(R.id.txt_mizanemasraf);
        txt_tozihat =findViewById(R.id.txt_tozihat);
        seek_size = findViewById(R.id.seekbar_size);
        gorohedaro =findViewById(R.id.gorohedaro);
        MoredeMasraf =findViewById(R.id.moredemasraf);
        Mizanemasraf =findViewById(R.id.mizanemasraf);
        tozihat =findViewById(R.id.tozihat);
        imgCopy = findViewById(R.id.img_copy);
        imgShare = findViewById(R.id.img_share);
        imgSms = findViewById(R.id.img_sms);
        imgFav = findViewById(R.id.img_fav);
        layout1 =  findViewById(R.id.layout1);
        layout2 =  findViewById(R.id.layout2);
        layout3 =  findViewById(R.id.layout3);
        layout4 =  findViewById(R.id.layout4);
    }
}