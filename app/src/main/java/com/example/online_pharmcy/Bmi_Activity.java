package com.example.online_pharmcy;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Bmi_Activity extends AppCompatActivity {
    Button btnResult;
    EditText edtName, edtvazn, edtqad;
    TextView txtResult;
    RadioButton rdoMan,rdoWomen;
    String name;
    int vazn, qadCM;
    float natije;
    int vazneMonaseb, vazneMonaseb2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        findViews();
        setBtnResult();
    }
//    this method is used to find and associate views in the application page.
    private void findViews(){
        btnResult =  findViewById(R.id.btn_Result);
        txtResult =  findViewById(R.id.txt_Result);
        edtName =  findViewById(R.id.edt_name);
        edtqad =  findViewById(R.id.edt_qad);
        edtvazn =  findViewById(R.id.edt_wazn);
        rdoMan =  findViewById(R.id.rdo_man);
        rdoWomen =  findViewById(R.id.rdo_women);
    }
//  In the android application Bmi_Activity, this method is used for the behavior of the "btnResult" button; It checks inputs,
//  calculates BMI and related values, and performs other functions.
    private void setBtnResult(){
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               name = edtName.getText().toString();

               String vaznr = edtvazn.getText().toString();
               String qadCMr= edtqad.getText().toString();

               if(TextUtils.isEmpty(qadCMr) || TextUtils.isEmpty(vaznr) || TextUtils.isEmpty(name)){
                   Toast.makeText(Bmi_Activity.this, R.string.Information,Toast.LENGTH_LONG).show();
               }else{
                   vazn = Integer.parseInt(edtvazn.getText().toString());
                   qadCM = Integer.parseInt(edtqad.getText().toString());

                   float qadM = (float) qadCM / 100;
                   qadM = (float)Math.pow(qadM,2);

                   natije = qadM/vazn;
                   int vazneM = (int) (24 * qadM);
                    vazneMonaseb = vazn - vazneM;
                    vazneMonaseb2 = vazneM - vazn;
                   if(rdoWomen.isChecked()){
                       natije = natije - 1;
                   }
                   scaleWeight();

               }
            }
        });
    }
//    This method is suitable for calculating weight.
    private void scaleWeight(){
        if (natije < 16.5) {

            txtResult.setText(name + getString(R.string.very_underWeight) + vazneMonaseb2 +getString(R.string.Underweight));

        } else if (natije < 18.4 && natije >= 16) {

            txtResult.setText(name +getString(R.string.about) + vazneMonaseb2 + getString(R.string.Underweight));

        } else if (natije < 25 && natije >= 18.4) {

            txtResult.setText(name + getString(R.string.weight_tall_suitable));

        } else if (natije < 30 && natije >= 25) {

            txtResult.setText(name + getString(R.string.about) + vazneMonaseb + getString(R.string.ExtraFit_kg));

        } else if (natije < 35 && natije >= 30) {

            txtResult.setText(name + getString(R.string.Type1fit) + vazneMonaseb + getString(R.string.ExtraFit_kg));

        } else if (natije < 40 && natije >= 35) {

            txtResult.setText(name + getString(R.string.Type2fit) + vazneMonaseb + getString(R.string.ExtraFit_kg));

        } else if (natije > 40) {

            txtResult.setText(name + getString(R.string.Type3fit) + vazneMonaseb + getString(R.string.ExtraFit_kg));
        }
    }
//  This method is so that when the user presses the back button, the app goes to the main activity.
    @Override
    public void onBackPressed() {
        startActivity(new Intent(Bmi_Activity.this,MainActivity.class));
        super.onBackPressed();
    }
}