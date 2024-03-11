package com.example.online_pharmcy;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.SeekBar;

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
//  In general, this method is used to implement user interfaces that need to control and set various states and parameters.
    public void setEvents(){
//      Clicking event on spinner items.
//      This pseudocode is used to implement a user interface where the user can change the font of the text using the font spinner.
        spn_fonts.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/"+fontsList[position]+".ttf");
                txt_show.setTypeface(typeface);
                editor.putString(FONT,fontsList[position]).apply();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
//      In general, this pseudocode is used to implement user interfaces that require the use of a switch to store and manage the state of a particular setting.
        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                editor.putBoolean(SCREEN,b).apply();
            }
        });
//      Seekbar resizing event.
//      This pseudocode is used to implement user interfaces that need to set and change the value of a parameter (such as font size) using the SeekBar.
        seek_size.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                font_size = progress;
                txt_show.setTextSize(font_size);
                editor.putInt(FONT_SIZE,font_size).apply();
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
//      The event related to the request to change the line spacing.
//      This pseudocode is used to implement user interfaces that need to set and change the spacing between lines in text. For example, using this event and the SeekBar, the user can set line spacing and display text with the desired spacing.
        seek_space.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                line_spacing = progress;
                txt_show.setLineSpacing(line_spacing,1.0f);
                editor.putInt(LINE_SPACING,line_spacing).apply();
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }
}