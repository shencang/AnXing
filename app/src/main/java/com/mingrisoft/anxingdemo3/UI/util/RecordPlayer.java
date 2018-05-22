package com.mingrisoft.anxingdemo3.UI.util;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.widget.Toast;

import java.io.File;

public class RecordPlayer {

    private static MediaPlayer mediaPlayer;

    private Context mContext;

    public RecordPlayer(Context mContext) {
        this.mContext = mContext;
    }

    //播放录音文件
    public void playRecordFile(File file) {
        if (file.exists() && file != null) {
            if (mediaPlayer == null) {
                Uri uri = Uri.fromFile(file);
                mediaPlayer = MediaPlayer.create(mContext, uri);
            }
            mediaPlayer.start();

            //监听MediaPlayer播放完成
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    Toast.makeText(mContext,"播放完成", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    // 暂停播放录音
    public void pausePlayer() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }

    // 停止播放录音
    public void stopPlayer() {
        // 这里不调用stop()，调用seekto(0),把播放进度还原到最开始
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            mediaPlayer.seekTo(0);
        }
    }
}
