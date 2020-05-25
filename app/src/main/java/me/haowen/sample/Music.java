package me.haowen.sample;


import android.R.integer;
import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

import java.io.File;

public class Music extends Activity  implements OnClickListener,
        OnSeekBarChangeListener{

    private Button pause;
    private MediaPlayer player;
    private SeekBar mSeekBar;
    private boolean hadDestroy = false;
    private Handler mHandler = new Handler() {
        public void handleMessage(android.os.Message msg) {

            switch (msg.what) {
                case 0x01:

                    break;

                default:
                    break;
            }
        };
    };
    Runnable runnable = new Runnable() {

        @Override
        public void run() {

            if (!hadDestroy) {
                mHandler.postDelayed(this, 1000);
                int currentTime = Math
                        .round(player.getCurrentPosition() / 1000);
                String currentStr = String.format("%s%02d:%02d", "当前时间 ",
                        currentTime / 60, currentTime % 60);

                mSeekBar.setProgress(player.getCurrentPosition());
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pause = (Button) findViewById(R.id.pause);

        mSeekBar = (SeekBar) findViewById(R.id.seekbar);

        mSeekBar.setOnSeekBarChangeListener(this);

        pause.setOnClickListener(this);

        player = new MediaPlayer();
        initMediaplayer();

    }

    /**
     * 初始化播放器
     */
    private void initMediaplayer() {
        try {
           /* File file = new File(Environment.getExternalStorageDirectory()
                    + "/Download/", "aiqiu.mp3");
            player.setDataSource(file.getPath());*/
            //Log.e("播放器", file.toString());
            player = MediaPlayer.create(this,R.raw.cmj);
            // player.prepare();
            if (!player.isPlaying()) {
                player.start();
                int totalTime = Math.round(player.getDuration() / 1000);
                String str = String.format("%02d:%02d", totalTime / 60,
                        totalTime % 60);

                mSeekBar.setMax(player.getDuration());
                mHandler.postDelayed(runnable, 1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.pause:
                if (!player.isPlaying()) {
                    player.start();
                    int totalTime = Math.round(player.getDuration() / 1000);
                    String str = String.format("%02d:%02d", totalTime / 60,
                            totalTime % 60);

                    mSeekBar.setMax(player.getDuration());
                    mHandler.postDelayed(runnable, 1000);
                }
                else if (player.isPlaying()) {
                    player.pause();
                }

                break;


            default:
                break;
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress,
                                  boolean fromUser) {
        if (player != null) {
            player.seekTo(seekBar.getProgress());
        }

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        // TODO 自动生成的方法存根

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        // TODO 自动生成的方法存根
    }

    @Override
    protected void onDestroy() {
        // TODO 自动生成的方法存根
        super.onDestroy();
        if (player != null) {
            player.stop();
            hadDestroy = true;
            player.release();
        }
    }
}

