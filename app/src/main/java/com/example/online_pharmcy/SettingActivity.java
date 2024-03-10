package com.example.online_pharmcy;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class SettingActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        findViews();
        settingAgain();
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
//  This method named "setting" is used for various settings and configurations in the program.
    private void settingAgain(){
//      Getting saved settings.
        getSharedpref();
//      Resetting saved settings.
        seek_size.setProgress(font_size);
        txt_show.setTextSize(font_size);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/"+font+".ttf");
        txt_show.setTypeface(typeface);
        mySwitch.setChecked(isScreenOn);
        txt_show.setLineSpacing(line_spacing,1.0f);
//      Setting the spinner adapter and connecting it to the spinner.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,fontsList);
        adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spn_fonts.setAdapter(adapter);
    }
}