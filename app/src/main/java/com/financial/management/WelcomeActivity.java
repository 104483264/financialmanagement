package com.financial.management;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main111);
    }


    public void onClick(View view){
        switch (view.getId()){
            case R.id.main_iv_search:

                break;

            case R.id.main_btn_edit:
                Intent intent1 = new Intent(getApplicationContext(), RecordActivity.class);//跳转界面
                startActivity(intent1);
                break;

            case R.id.main_btn_more:
                break;

        }
    }




}
