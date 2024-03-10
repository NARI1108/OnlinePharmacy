package com.example.online_pharmcy;

import android.os.Bundle;

public class SettingActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        findViews();
    }
//     this method is used to find and associate views in the application page.
    private void findViews(){
        spn_fonts = findViewById(R.id.spn_fonts);
        txt_show =  findViewById(R.id.txt_show);
        txt_font =  findViewById(R.id.txt_font);
        seek_size = findViewById(R.id.seekbar_size);
        seek_space = findViewById(R.id.seekbar_space);
        mySwitch = findViewById(R.id.mySwitch);
    }
}