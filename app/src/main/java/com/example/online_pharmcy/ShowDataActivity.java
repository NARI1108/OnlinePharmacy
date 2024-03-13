package com.example.online_pharmcy;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

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
        elements();
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
    public void btnsClick(View view){
       int id = view.getId();
       switch(id){
//           In general, this is the part of the code that, by clicking on an ImageView, places the desired text in the clipboard of the Android application and displays a small message to the user.
           case R.id.img_copy:
//               Add the desired text to the clipboard.
               ClipboardManager clipboardManager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
               clipboardManager.setPrimaryClip(ClipData.newPlainText("Text",text_share));
               Toast.makeText(this, R.string.adding_cilpboard,Toast.LENGTH_SHORT).show();
               break;
//           In general, this is a piece of code that, by clicking on an ImageView, changes the item's interest status (add or remove from the interest list) and displays a small message to the user.
           case R.id.img_fav:
               int fav;
               if(isFavorite == 0){
                   Toast.makeText(this,"به لیست علاقمندی ها اضافه شد",Toast.LENGTH_SHORT).show();
                   imgFav.setImageResource(R.drawable.heart_icon);
                   fav = 1;
                   isFavorite = 1;
               }else{
                   Toast.makeText(this,"از لیست علاقمندی ها حذف شد",Toast.LENGTH_SHORT).show();
                   fav = 0;
                   isFavorite = 0;
                   imgFav.setImageResource(R.drawable.heart_outline);
               }
               dataBaseManager.updateFavorite(id,fav,table_name);
               break;
//           In general, this is the part of the code that, by clicking on an ImageView, shares the desired text using other programs and displays a list of programs that can send the text to the user.
           case R.id.img_share:
//               Tap the desired text with all apps that have the ability to send text.
               Intent intent_share = new Intent(Intent.ACTION_SEND);
               intent_share.putExtra(Intent.EXTRA_TEXT,text_share);
               intent_share.setType("text/plain");
               startActivity(intent_share);
               break;
//          In general, this is the part of the code that, by clicking on an ImageView, sends the desired text using the SMS programs available on the device and displays a list of SMS programs to the user.
           case R.id.img_sms:
//               The method of sending a text via SMS.
               Intent intent_sms = new Intent(Intent.ACTION_VIEW);
               intent_sms.putExtra("sms_body",text_share);
               intent_sms.setData(Uri.parse("sms:"));
               startActivity(intent_sms);
               break;
       }
    }
    private void elements(){

        if (dataType== MainActivity.DRUGS){
            table_name = DataBaseManager.TABLE_NAME_DURGS;
            items = dataBaseManager.showDrugs(name);
            txt_Name.setText(name);
            txt_GroheDaro.setText(items.gorohedaro_Items);
            txt_MoredeMasraf.setText(items.moredemasraf_Items);
            txt_Mizanemasraf.setText(items.mizaneMasraf_Items);
            txt_tozihat.setText(items.tozihat_Items);
            text_share = name + "\n" + items.gorohedaro_Items + "\n" + items.moredemasraf_Items + "\n" + items.mizaneMasraf_Items + "\n" + items.tozihat_Items;

        }else if (dataType== MainActivity.SICKNESS || dataType== MainActivity.TASHKHIS){
            table_name = DataBaseManager.TABLE_NAME_SICKNESS;
            items = dataBaseManager.showSickness(name);
            txt_Name.setText(name);
            gorohedaro.setText(R.string.description_of_the_disease);
            txt_GroheDaro.setText(items.sharhebimari_Items);
            MoredeMasraf.setText(R.string.symptoms);
            txt_MoredeMasraf.setText(items.alyem_Items);
            txt_Mizanemasraf.setVisibility(View.GONE);
            txt_tozihat.setVisibility(View.GONE);
            layout3.setVisibility(View.GONE);
            layout4.setVisibility(View.GONE);
            Mizanemasraf.setVisibility(View.GONE);
            tozihat.setVisibility(View.GONE);
            text_share = name + "\n" + items.sharhebimari_Items + "\n" + items.alyem_Items;

        }else if (dataType== MainActivity.HONEY){
            table_name = DataBaseManager.TABLE_NAME_HONEY;
            items = dataBaseManager.showHoney(name);
            txt_Name.setText(name);
            txt_GroheDaro.setText(items.khavaseAsal_Items);
            txt_MoredeMasraf.setVisibility(View.GONE);
            txt_Mizanemasraf.setVisibility(View.GONE);
            txt_tozihat.setVisibility(View.GONE);
            layout1.setVisibility(View.GONE);
            layout2.setVisibility(View.GONE);
            layout3.setVisibility(View.GONE);
            layout4.setVisibility(View.GONE);
            gorohedaro.setVisibility(View.GONE);
            MoredeMasraf.setVisibility(View.GONE);
            Mizanemasraf.setVisibility(View.GONE);
            tozihat.setVisibility(View.GONE);
            text_share = name + "\n" + items.khavaseAsal_Items;

        }else if (dataType== MainActivity.AVAREZ){
            table_name = DataBaseManager.TABLE_NAME_AVAREZ;
            items = dataBaseManager.showAvarez(name);
            txt_Name.setText(name);
            txt_GroheDaro.setText(items.text_Items);
            txt_MoredeMasraf.setVisibility(View.GONE);
            txt_Mizanemasraf.setVisibility(View.GONE);
            txt_tozihat.setVisibility(View.GONE);
            layout1.setVisibility(View.GONE);
            layout2.setVisibility(View.GONE);
            layout3.setVisibility(View.GONE);
            layout4.setVisibility(View.GONE);
            gorohedaro.setVisibility(View.GONE);
            MoredeMasraf.setVisibility(View.GONE);
            Mizanemasraf.setVisibility(View.GONE);
            tozihat.setVisibility(View.GONE);
            text_share = name + "\n" + items.text_Items;
        }
    }
}