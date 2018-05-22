package com.mingrisoft.anxingdemo3.UI.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.mingrisoft.anxingdemo3.R;
import com.mingrisoft.anxingdemo3.UI.activity.ActivityOnline;


public class FragmentFirstPage extends android.support.v4.app.Fragment implements View.OnClickListener{
    private ImageView firstFgVoiceImg;
    private Button firstStartBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentfirsefage, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        firstFgVoiceImg = view.findViewById(R.id.first_voice_img);
        firstStartBtn = view.findViewById(R.id.startprotect);
        firstStartBtn.setOnClickListener(this);
        Glide.with(getContext()).load(R.drawable.voiceclick).into(firstFgVoiceImg);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.startprotect:
                startActivity(new Intent(getContext(),ActivityOnline.class));
//                startVoice();
                break;
        }
    }

    private void startVoice() {

    }


}
