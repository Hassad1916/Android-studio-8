package com.example.bmi2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        bmi_Answer();
    }
    //返回上一頁
    public void Back(View v){
        finish();
    }
    private void bmi_Answer(){

        double height;
        double weight;
        double bmi ;
        Bundle bundle = this.getIntent().getExtras();
        if (bundle != null){
            DecimalFormat nf = new DecimalFormat("0.00");
            height = Double.parseDouble(bundle.getString("Height")) / 100;
            weight = Double.parseDouble(bundle.getString("Weight"));

            bmi = weight / (height * height);

            TextView X = (TextView)findViewById(R.id.textView8);
            X.setText(nf.format(bmi));
            TextView Y = (TextView)findViewById(R.id.textView7);

            if (bmi < 18){
                Y.setText("體重過輕");
            }
            else if (bmi > 24){
                Y.setText("體重過重");
            }
            else
                Y.setText("體重正常");
        }
    }
}