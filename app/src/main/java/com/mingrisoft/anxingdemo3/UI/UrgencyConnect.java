package com.mingrisoft.anxingdemo3.UI;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.mingrisoft.anxingdemo3.R;

public class UrgencyConnect extends AppCompatActivity {

    private TextView firsturgencyconnecter;
    private Button addurgencyconnecter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.urgencyconnecter);
        initView();
    }
    /*
    time:2018.5.13
    editer:书豪
    mean：初始按钮
   */
    private void initView()
    {
        firsturgencyconnecter = findViewById(R.id.firstconnecter);
        addurgencyconnecter = findViewById(R.id.addurgencyconnecter);
    }
}
