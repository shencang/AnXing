package com.mingrisoft.anxingdemo3.UI.activity;

import android.media.MediaRecorder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mingrisoft.anxingdemo3.R;
import com.mingrisoft.anxingdemo3.UI.util.RecordPlayer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

public class VoiceMonitorActivity extends AppCompatActivity {
    String TAG = "VoiceMonitorActivity";
    EditText voiceMonitor;
    Date date;

    //录音类
    private MediaRecorder mediaRecorder;
    //以文件的形式保存
    private File recordFile;

    private RecordPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice_monitor);

        initDate();
        startRecording();
    }

    private void initDate() {
        voiceMonitor = (EditText) findViewById(R.id.voice_monitor_btn);
        date = new Date();
        recordFile = new File("/mnt/sdcard", date.toString() + ".mp3");
    }

    private void startRecording() {
        voiceMonitor.setText("录音开始！");
        mediaRecorder = new MediaRecorder();
//         判断，若当前文件已存在，则删除
        if (recordFile.exists()) {
            recordFile.delete();
        }
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.DEFAULT);
        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);
        mediaRecorder.setOutputFile(recordFile.getAbsolutePath());

        try {
            // 准备好开始录音
            mediaRecorder.prepare();

            mediaRecorder.start();
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (recordFile != null) {
            mediaRecorder.stop();
            mediaRecorder.release();
        }
    }
}
