package me.haowen.sample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import me.haowen.sample.adapter.TestAdapter;
import me.haowen.planet.view.PlanetsView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PlanetsView soulPlanet = findViewById(R.id.soulPlanetView);
        soulPlanet.setAdapter(new TestAdapter());

        soulPlanet.setOnTagClickListener(new PlanetsView.OnTagClickListener() {
            @Override
            public void onItemClick(ViewGroup parent, View view, int position) {
                //Toast.makeText(MainActivity.this, String.valueOf(position), Toast.LENGTH_SHORT).show();
                DiyDialog1(position);

            }
        });

    }

    /**
     * 自定义1 控制普通的dialog的位置，大小，透明度
     * 在普通的dialog.show下面添加东西
     */
    private void DiyDialog1(int position){
        View view = LayoutInflater.from(this).inflate(R.layout.alert, null);
        AlertDialog.Builder alterDiaglog = new AlertDialog.Builder(MainActivity.this).setView(view);
        alterDiaglog.setIcon(R.mipmap.tq1);//图标
        final TextView tv_text=view.findViewById(R.id.tv_text);//获取内容
        final ImageView iv_image=view.findViewById(R.id.iv_image);//获取图片

            //position 范围0-29
        switch (position){
            case 0:
                alterDiaglog.setTitle("2018-2-12");//标题文字
                tv_text.setText("  和你说话的时候闻到了你洗发水的香味，觉得好好闻，然后放学一个人跑去超市一样一样的闻终于买到了同款，哈哈。  ");
                iv_image.setImageResource(R.mipmap.cs);
                break;
            case 1:
                alterDiaglog.setTitle("2018-3-1");//标题文字
                tv_text.setText("  收能量的时候发现你的小鸡跑到了我这偷吃饲料，暗自决定了以后每天攒饲料。  ");
                iv_image.setImageResource(R.mipmap.my);
                break;
            case 2:
                alterDiaglog.setTitle("2018-1-26");//标题文字
                tv_text.setText("  你收拾书包特别慢，以前我总是放学第一个冲出教室，后来学会了磨磨蹭蹭跟在你身后看着你的背影。 ");
                iv_image.setImageResource(R.mipmap.by);
                break;
            case 3:
                alterDiaglog.setTitle("2018-1-17");//标题文字
                tv_text.setText("  不经意发现你在教室睡着啦，一瞬间的冲动好想摸摸你的头，但最后也只是看了看自己不敢伸出去的手。 ");
                iv_image.setImageResource(R.mipmap.mt);
                break;
            case 4:
                alterDiaglog.setTitle("2018-1-26");//标题文字
                tv_text.setText("  在打球的时候，突然胃疼，蹲在地上很难受，其他人都是低着头和我说话，只有你蹲了下来。 ");
                iv_image.setImageResource(R.mipmap.dx);
                break;
            case 5:
                alterDiaglog.setTitle("2018-2-6");//标题文字
                tv_text.setText("  趴在教室窗台上发呆，你路过，然后递给了我一颗糖问我吃不吃。 ");
                iv_image.setImageResource(R.mipmap.tg);
                break;
            case 6:
                alterDiaglog.setTitle("2018-1-26");//标题文字
                tv_text.setText("  你收拾书包特别慢，以前我总是放学第一个冲出教室，后来学会了磨磨蹭蹭跟在你身后看着你的背影。");
                iv_image.setImageResource(R.mipmap.by);
                break;
            case 7:
                alterDiaglog.setTitle("2018-5-4");//标题文字
                tv_text.setText("  每次我很丧的时候去找你，虽然都是一些吐槽的负能量，但是你都不会烦我，真好。 ");
                iv_image.setImageResource(R.mipmap.qt);
                break;

            case 8:
                alterDiaglog.setTitle("2018-3-22");//标题文字
                tv_text.setText("  看到你发朋友圈问有没有人想去看那部刚上映的动画电影，本来约好了和兄弟一起打游戏的我点开和你的对话框打了句“好巧啊我也想去看这个”。 ");
                iv_image.setImageResource(R.mipmap.dy);
                break;
            case 9:
                alterDiaglog.setTitle("2018-4-9");//标题文字
                tv_text.setText("  拉你打游戏，你每次都会把捡到的好东西给我，问你为啥不要你只是说你太菜了死的太快...你傻啊，我可以保护你啊。 ");
                iv_image.setImageResource(R.mipmap.cj);
                break;
            case 10:
                alterDiaglog.setTitle("2018-2-7");//标题文字
                tv_text.setText("  你问我，“今天是不是你生日？” ");
                iv_image.setImageResource(R.mipmap.sr);
                break;
            case 11:
                alterDiaglog.setTitle("2018-5-11");//标题文字
                tv_text.setText("  学校搞活动，去的晚了找不着班级在哪儿，然后就看到了你隔着两层楼向我招手。 ");
                iv_image.setImageResource(R.mipmap.hs);
                break;
            case 12:
                alterDiaglog.setTitle("2018-5-27");//标题文字
                tv_text.setText("  在食堂的时候，看到你开了门之后回头看了看后面的人，耐心的等他们进门后才轻轻的把门带上。 ");
                iv_image.setImageResource(R.mipmap.tm);
                break;
            case 13:
                alterDiaglog.setTitle("2018-3-27");//标题文字
                tv_text.setText("  在学校球场上打球的时候看见了你，你穿着一条之前没穿过的红裙子，跟着你朋友一起说着话走了过去，不知道为什么，突然就不想打球了。 ");
                iv_image.setImageResource(R.mipmap.qz);
                break;
            case 14:
                alterDiaglog.setTitle("2018-4-7");//标题文字
                tv_text.setText("  下课回家的时候被人拽住了衣角，回头一看，是你作业没写好向我求助，原来女生力气那么大啊，不过你紧张的样子挺可爱的 ");
                iv_image.setImageResource(R.mipmap.yj);
                break;
            case 15:
                alterDiaglog.setTitle("2018-5-11");//标题文字
                tv_text.setText("  在去教室上课的路上，我一个人走着，你从身后拍了一下我的肩膀，我回过头的时候，你已经跳到了我的面前，冲着我甜甜的笑了一下。我承认我呆了那么几秒 ");
                iv_image.setImageResource(R.mipmap.wx);
                break;
            case 16:
                alterDiaglog.setTitle("2018-1-21");//标题文字
                tv_text.setText("   在图书馆遇见了你，本想和你打个招呼，想想算了。结果是看了一下午的书什么也没看进去 ");
                iv_image.setImageResource(R.mipmap.ds);
                break;
            case 17:
                alterDiaglog.setTitle("2018-1-26");//标题文字
                tv_text.setText("  你收拾书包特别慢，以前我总是放学第一个冲出教室，后来学会了磨磨蹭蹭跟在你身后看着你的背影。");
                iv_image.setImageResource(R.mipmap.by);
                break;
            case 18:
                alterDiaglog.setTitle("2018-5-4");//标题文字
                tv_text.setText("  每次我很丧的时候去找你，虽然都是一些吐槽的负能量，但是你都不会烦我，真好。");
                iv_image.setImageResource(R.mipmap.qt);
                break;
            case 19:
                alterDiaglog.setTitle("2018-3-22");//标题文字
                tv_text.setText("  看到你发朋友圈问有没有人想去看那部刚上映的动画电影，本来约好了和兄弟一起打游戏的我点开和你的对话框打了句“好巧啊我也想去看这个”。 ");
                iv_image.setImageResource(R.mipmap.dy);
                break;
            case 20:
                alterDiaglog.setTitle("2018-4-9");//标题文字
                tv_text.setText("  拉你打游戏，你每次都会把捡到的好东西给我，问你为啥不要你只是说你太菜了死的太快...你傻啊，我可以保护你啊。 ");
                iv_image.setImageResource(R.mipmap.cj);
            case 21:
                alterDiaglog.setTitle("2018-2-12");//标题文字
                tv_text.setText("  和你说话的时候闻到了你洗发水的香味，觉得好好闻，然后放学一个人跑去超市一样一样的闻终于买到了同款，哈哈。  ");
                iv_image.setImageResource(R.mipmap.cs);
                break;
            case 22:
                alterDiaglog.setTitle("2018-1-26");//标题文字
                tv_text.setText("  你收拾书包特别慢，以前我总是放学第一个冲出教室，后来学会了磨磨蹭蹭跟在你身后看着你的背影。");
                iv_image.setImageResource(R.mipmap.by);
                break;
            case 23:
                alterDiaglog.setTitle("2018-4-29");//标题文字
                tv_text.setText("  等红灯的时候拍到了一对亲昵耳语的情侣，不知道为什么，看着这照片就不自觉的开始笑，然后就想到了你. ");
                iv_image.setImageResource(R.mipmap.ml);
                break;
            case 24:
                alterDiaglog.setTitle("2018-5-21");//标题文字
                tv_text.setText("  在打球的时候，突然胃疼，蹲在地上很难受，其他人都是低着头和我说话，只有你蹲了下来。 ");
                iv_image.setImageResource(R.mipmap.dx);
                break;
            case 25:
                alterDiaglog.setTitle("2018-4-29");//标题文字
                tv_text.setText("  等红灯的时候拍到了一对亲昵耳语的情侣，不知道为什么，看着这照片就不自觉的开始笑，然后就想到了你. ");
                iv_image.setImageResource(R.mipmap.ml);
                break;
            case 26:
                alterDiaglog.setTitle("2018-3-27");//标题文字
                tv_text.setText("  在学校球场上打球的时候看见了你，你穿着一条之前没穿过的红裙子，跟着你朋友一起说着话走了过去，不知道为什么，突然就不想打球了。 ");
                iv_image.setImageResource(R.mipmap.qz);
                break;
            case 27:
                alterDiaglog.setTitle("2018-4-7");//标题文字
                tv_text.setText("  下课回家的时候被人拽住了衣角，回头一看，是你作业没写好向我求助，原来女生力气那么大啊，不过你紧张的样子挺可爱的 ");
                iv_image.setImageResource(R.mipmap.yj);
                break;
            case 28:
                alterDiaglog.setTitle("2018-5-11");//标题文字
                tv_text.setText("  在去教室上课的路上，我一个人走着，你从身后拍了一下我的肩膀，我回过头的时候，你已经跳到了我的面前，冲着我甜甜的笑了一下。我承认我呆了那么几秒 ");
                iv_image.setImageResource(R.mipmap.wx);
                break;
            case 29:
                alterDiaglog.setTitle("2018-1-21");//标题文字
                tv_text.setText("   在图书馆遇见了你，本想和你打个招呼，想想算了。结果是看了一下午的书什么也没看进去 ");
                iv_image.setImageResource(R.mipmap.ds);
                break;
            case 30:
                alterDiaglog.setTitle("2018-1-26");//标题文字
                tv_text.setText("  你收拾书包特别慢，以前我总是放学第一个冲出教室，后来学会了磨磨蹭蹭跟在你身后看着你的背影。");
                iv_image.setImageResource(R.mipmap.by);
                break;
            case 31:
                alterDiaglog.setTitle("2018-5-4");//标题文字
                tv_text.setText("  每次我很丧的时候去找你，虽然都是一些吐槽的负能量，但是你都不会烦我，真好。 ");
                iv_image.setImageResource(R.mipmap.qt);
                break;
            case 32:
                alterDiaglog.setTitle("2018-4-9");//标题文字
                tv_text.setText("  拉你打游戏，你每次都会把捡到的好东西给我，问你为啥不要你只是说你太菜了死的太快...你傻啊，我可以保护你啊。 ");
                iv_image.setImageResource(R.mipmap.cj);
            case 33:
                alterDiaglog.setTitle("2018-5-11");//标题文字
                tv_text.setText("  学校搞活动，去的晚了找不着班级在哪儿，然后就看到了你隔着两层楼向我招手。 ");
                iv_image.setImageResource(R.mipmap.hs);
                break;
            case 34:
                alterDiaglog.setTitle("2018-2-7");//标题文字
                tv_text.setText("  你问我，“今天是不是你生日？” ");
                iv_image.setImageResource(R.mipmap.sr);
                break;
            case 35:
                alterDiaglog.setTitle("2018-2-6");//标题文字
                tv_text.setText("  趴在教室窗台上发呆，你路过，然后递给了我一颗糖问我吃不吃。");
                iv_image.setImageResource(R.mipmap.tg);
                break;
            case 36:
                alterDiaglog.setTitle("2018-5-27");//标题文字
                alterDiaglog.setIcon(R.mipmap.tq1);
                tv_text.setText("  在食堂的时候，看到你开了门之后回头看了看后面的人，耐心的等他们进门后才轻轻的把门带上。 ");
                iv_image.setImageResource(R.mipmap.tm);
                break;
            case 38:
                alterDiaglog.setIcon(R.mipmap.sunny);
                alterDiaglog.setTitle("内个……");//标题文字
                tv_text.setText(" 让我们挑个好日子就开始，好么？");
                iv_image.setImageResource(R.mipmap.kaishiba);
                break;
                default:
                    alterDiaglog.setTitle("未来的某一天" );//标题文字
                    tv_text.setText("  我喜欢你，我想留给你什么更聪明的话，但是我只知道这一句 ");
                    iv_image.setImageResource(R.mipmap.bx);
                    break;

        }
        alterDiaglog.setNegativeButton("返回", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               // Toast.makeText(MainActivity.this,"返回",Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog dialog = alterDiaglog.create();

        //显示
        dialog.show();
        //自定义的东西
        //放在show()之后，不然有些属性是没有效果的，比如height和width
        Window dialogWindow = dialog.getWindow();
        WindowManager m = getWindowManager();
        Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
        WindowManager.LayoutParams p = dialogWindow.getAttributes(); // 获取对话框当前的参数值
        // 设置高度和宽度
        // p.height = (int) (d.getHeight() * 0.9); // 高度设置为屏幕的0.9
        p.width = (int) (d.getWidth() * 0.9); // 宽度设置为屏幕的0.9
        p.windowAnimations=R.style.dialogStyle;
        p.gravity = Gravity.CENTER;//设置位置

        p.alpha = 0.9f;//设置透明度
        dialogWindow.setAttributes(p);
    }
}
