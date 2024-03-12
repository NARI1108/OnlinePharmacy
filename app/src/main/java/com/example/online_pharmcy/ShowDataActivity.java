package com.example.online_pharmcy;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
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
        restoreSetting();
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
//    This method is used to restore and reset the page.
    private void restoreSetting(){
        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/"+font+".ttf");
        txt_Name.setTypeface(typeface);
        txt_GroheDaro.setTypeface(typeface);
        txt_MoredeMasraf.setTypeface(typeface);
        txt_Mizanemasraf.setTypeface(typeface);
        txt_tozihat.setTypeface(typeface);
        gorohedaro.setTypeface(typeface);
        MoredeMasraf.setTypeface(typeface);
        Mizanemasraf.setTypeface(typeface);
        tozihat.setTypeface(typeface);

        txt_GroheDaro.setTextSize(font_size);
        txt_MoredeMasraf.setTextSize(font_size);
        txt_Mizanemasraf.setTextSize(font_size);
        txt_tozihat.setTextSize(font_size);


        txt_GroheDaro.setLineSpacing(line_spacing,1.0f);
        txt_MoredeMasraf.setLineSpacing(line_spacing,1.0f);
        txt_Mizanemasraf.setLineSpacing(line_spacing,1.0f);
        txt_tozihat.setLineSpacing(line_spacing,1.0f);
//      Keeping the screen on
//      if isScreenOn is set to true, the FLAG_KEEP_SCREEN_ON flag will be added to the current window to keep the screen on (without auto-shutdown).
        if(isScreenOn){getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);}
    }
}