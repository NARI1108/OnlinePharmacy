package com.example.online_pharmcy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.GravityCompat;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        animation();
        setVisibility();
        actionBarDrawerToggle();
//       (Drop down menu) Set the click event on navigation view items
        navi_view.setNavigationItemSelectedListener(MainActivity.this);
//       Set the desired toolbar as an action bar
        setSupportActionBar(toolbar);
//       The value of the object related to the explosion animation.
        exploionField = ExploionField.attach2Window(MainActivity.this);
        dataBaseManager = new DataBaseManager(MainActivity.this);
    }
//    This method actually connects views and layers from an XML layer to this layer.
    public void findViews(){
//       The ID related to the RelativeLayout.
        rlt_drugs = findViewById(R.id.rlt_drugs);
        rlt_sickness = findViewById(R.id.rlt_sickness);
        rlt_honey = findViewById(R.id.rlt_honey);
        rlt_avarez = findViewById(R.id.rlt_avarez);
        rlt_bmi = findViewById(R.id.rlt_bmi);
        rlt_tashkhis = findViewById(R.id.rlt_tashkhis);
//       The ID related to the TextView.
        txt_drugs_tedad = findViewById(R.id.txt_drugs_tedad);
        txt_sickness_tedad = findViewById(R.id.txt_sickness_tedad);
        txt_honey_tedad = findViewById(R.id.txt_honey_tedad);
        txt_avarez_tedad = findViewById(R.id.txt_avarez_tedad);
        txt_tashkhis_tedad = findViewById(R.id.txt_tashkhis_tedad);
//       The ID related to the DrawerLayout.
        drawer_layout = findViewById(R.id.drawer_layout);
//       The ID related to the Toolbar.
        toolbar = findViewById(R.id.toolbar);
//        The ID related to the NavigationView.
        navi_view = findViewById(R.id.navi_view);
    }
//  In other words, using this method, you can make components disappear or become visible again, depending on what you need at runtime.
    public void setVisibility(){
        txt_drugs_tedad.setVisibility(View.GONE);
        txt_avarez_tedad.setVisibility(View.GONE);
        txt_honey_tedad.setVisibility(View.GONE);
        txt_sickness_tedad.setVisibility(View.GONE);
        txt_tashkhis_tedad.setVisibility(View.GONE);
    }
//  In short, this method is used to perform operations related to navigation menu items, such as starting an Activity, displaying messages, and closing the navigation menu.
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int Ids = item.getItemId();
        switch (Ids) {
            case R.id.favorite:
                startActivity(new Intent(MainActivity.this,FavoriteActivity.class));
                break;
            case R.id.settings:
                startActivity(new Intent(MainActivity.this,SettingActivity.class));
                break;
            case R.id.About:
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle(R.string.about_us)
                        .setMessage(R.string.About_us)
                        .show();
                break;
            case R.id.resource:
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle(R.string.resources)
                        .setMessage(R.string.Resource)
                        .show();
                break;
            case R.id.exit:
                finish();
                break;
        }
        drawer_layout.closeDrawer(GravityCompat.START);
        return true;
    }
//  The corresponding components move and change shape using the loaded animations.
    public void animation(){
//       Setting the button display animation.
        Animation animation1 = AnimationUtils.loadAnimation(MainActivity.this,R.anim.anim_trans1);
        Animation animation2 = AnimationUtils.loadAnimation(MainActivity.this,R.anim.anim_trans2);

        rlt_drugs.setAnimation(animation1);
        rlt_sickness.setAnimation(animation2);
        rlt_honey.setAnimation(animation1);
        rlt_avarez.setAnimation(animation2);
        rlt_bmi.setAnimation(animation1);
        rlt_tashkhis.setAnimation(animation2);
    }
//    In short, using this method, an ActionBarDrawerToggle is created and added to the DrawerLayout to handle drawer opening and closing interactions in the ActionBar.
    public void actionBarDrawerToggle(){
       ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(MainActivity.this,drawer_layout, toolbar,R.string.open,R.string.close);
       drawer_layout.addDrawerListener(actionBarDrawerToggle);
       actionBarDrawerToggle.syncState();
    }
    @Override
    protected void onResume() {
//      We made a condition that if the program was not executed first, the number of data would be taken from the database and server to check whether there is new data or not.
        if(!first_run){
            tedad_alayem_database = dataBaseManager.count(DataBaseManager.TABLE_NAME_ALAYEM);
            tedad_honey_database = dataBaseManager.count(DataBaseManager.TABLE_NAME_HONEY);
            tedad_avarez_database = dataBaseManager.count(DataBaseManager.TABLE_NAME_AVAREZ);
            tedad_drugs_database = dataBaseManager.count(DataBaseManager.TABLE_NAME_DURGS);
            tedad_sickness_database = dataBaseManager.count(DataBaseManager.TABLE_NAME_SICKNESS);
            new GetTedadServer(this).execute();
        }
        super.onResume();
    }
}