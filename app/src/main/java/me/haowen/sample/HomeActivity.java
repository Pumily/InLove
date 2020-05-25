package me.haowen.sample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.VideoView;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{

    private CheckBox pause;
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

    private AlphaAnimation mHideAnimation	= null;
    private AlphaAnimation mShowAnimation	= null;
    private TextView mTv1;
    private TextView mTv2;
    private View mBgVideo;
    private RelativeLayout mText;
    int flag = 0;//定义标记变量
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        pause = (CheckBox) findViewById(R.id.pause);

        mSeekBar = (SeekBar) findViewById(R.id.seekbar);

        pause.setOnClickListener(this);

        player = new MediaPlayer();
        initMediaplayer();

        final VideoView videoview =findViewById(R.id.videoView);
        final String videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.p1).toString();
        videoview.setVideoPath(videoPath);
        videoview.start();
        videoview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
                mp.setLooping(true);
            }
        });
        videoview.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                videoview.setVideoPath(videoPath);
                videoview.start();
            }
        });

        mTv1 = findViewById(R.id.bg_tv1);
        mTv2 = findViewById(R.id.bg_tv2);
        mText = findViewById(R.id.bg_text);
        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/浮生未歇By：伊筠&阿影.ttf");
        Typeface customEN_font = Typeface.createFromAsset(getAssets(),  "fonts/American Scribe.ttf");
        mTv1.setTypeface(custom_font);
        mTv2.setTypeface(customEN_font);
        mBgVideo = findViewById(R.id.bg_video);
        mTv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag==0){
                    setShowAnimation(mText,2000);
                    mTv1.setText("你喜欢的歌我也有去听");
                    mTv2.setText("I also listen to your favorite songs");
                }
                else if (flag==1){
                    setShowAnimation(mText,2000);
                    mTv1.setText("你看的电影我也偷偷去看过");
                    mTv2.setText("Watch the movies you've seen");
                }else if (flag==2){
                    setShowAnimation(mText,2000);
                    mTv1.setText("其实，我喜欢你");
                    mTv2.setText("Actually, I like you");
                }else if (flag==3){
                    setHideAnimation(mBgVideo,2000);
                    Intent intent = new Intent(HomeActivity.this,MainActivity.class);
                    startActivity(intent);
                }
                flag=(flag+1)%4;
            }
        });
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

    /**
     * View渐隐动画效果
     */
    private void setHideAnimation( View view, int duration ){
        if( null == view || duration < 0 ){
            return;
        }
        if( null != mHideAnimation ){
            mHideAnimation.cancel( );
        }
        mHideAnimation = new AlphaAnimation(1.0f, 0.0f);
        mHideAnimation.setDuration( duration );
        mHideAnimation.setFillAfter( true );
        view.startAnimation( mHideAnimation );
    }

    /**
     * View渐现动画效果
     */
    private void setShowAnimation( View view, int duration ){
        if( null == view || duration < 0 ){
            return;
        }
        if( null != mShowAnimation ){
            mShowAnimation.cancel( );
        }
        mShowAnimation = new AlphaAnimation(0.0f, 1.0f);
        mShowAnimation.setDuration( duration );
        mShowAnimation.setFillAfter( true );
        view.startAnimation( mShowAnimation );
    }

    private void initMediaplayer() {
        try {
           /* File file = new File(Environment.getExternalStorageDirectory()
                    + "/Download/", "aiqiu.mp3");
            player.setDataSource(file.getPath());*/
            //Log.e("播放器", file.toString());
            player = MediaPlayer.create(this,R.raw.yhn);
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
