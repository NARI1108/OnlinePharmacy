package com.example.online_pharmcy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
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
//  In short, this method is used to perform operations related to
//  navigation menu items, such as starting an Activity, displaying
//  messages, and closing the navigation menu.
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
                        .setTitle("درباره مـــا")
                        .setMessage(R.string.About_us)
                        .show();
                break;
            case R.id.resource:
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("منــابــع")
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
}