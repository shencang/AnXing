package com.mingrisoft.anxingdemo3.UI.service;

import android.app.IntentService;
import android.content.Intent;
import android.media.MediaRecorder;
import android.widget.Toast;

import com.mingrisoft.anxingdemo3.UI.util.RecordPlayer;

import java.io.File;
import java.io.IOException;

public class soundrecording extends IntentService {
    //录音类
    private MediaRecorder mediaRecorder;
    //以文件的形式保存
    private File recordFile;

    private RecordPlayer player;

    public soundrecording() {
        super("soundrecording");
    }

    @Override
    public void onCreate() {
        recordFile = new File("/mnt/sdcard","kk.mp3");
        super.onCreate();
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        //
        Toast.makeText(this, "server open succees!", Toast.LENGTH_SHORT).show();
        startRecording();
    }

    private void startRecording() {
        mediaRecorder = new MediaRecorder();
        // 判断，若当前文件已存在，则删除
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
