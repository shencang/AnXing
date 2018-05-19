package com.mingrisoft.anxingdemo3.UI;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.mingrisoft.anxingdemo3.R;

public class Userinfo extends AppCompatActivity {

    private TextView nametext;
    private TextView teltext;
    private TextView agetext;
    private TextView sextext;
    private Button exitd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.userinfo);
        initView();
    }

    /*
    time:2018.5.13
    editer:书豪
    mean：初始化按钮
   */
    @SuppressLint("WrongViewCast")
    private void initView()
    {
        nametext = findViewById(R.id.nametext);
        teltext = findViewById(R.id.teltext);
        agetext = findViewById(R.id.agetext);
        sextext =findViewById(R.id.sextext);
        exitd = findViewById(R.id.exit);
    }
}
