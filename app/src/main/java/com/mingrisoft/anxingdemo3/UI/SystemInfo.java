package com.mingrisoft.anxingdemo3.UI;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mingrisoft.anxingdemo3.R;
import com.mingrisoft.anxingdemo3.UI.baidu.OnlineSetting;

public class SystemInfo extends AppCompatActivity implements View.OnClickListener{
    Button setVoiceBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.systeminfo);

        initView();
    }

    private void initView() {
        setVoiceBtn = (Button) findViewById(R.id.setvoice_btn);
        setVoiceBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.setvoice_btn:
                startActivity(new Intent(this, OnlineSetting.class));
        }
    }
}
