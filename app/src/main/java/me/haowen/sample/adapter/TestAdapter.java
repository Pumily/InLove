package me.haowen.sample.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Random;

import me.haowen.planet.adapter.PlanetAdapter;
import me.haowen.planet.utils.SizeUtils;
import me.haowen.planet.view.PlanetView;

public class TestAdapter extends PlanetAdapter {

    @Override
    public int getCount() {
        return 39;
    }

    @Override
    public View getView(Context context, int position, ViewGroup parent) {
        PlanetView planetView = new PlanetView(context);
        planetView.setSign(getRandomNick());

        int starColor = position % 2 == 0 ? PlanetView.COLOR_FEMALE : PlanetView.COLOR_MALE;
        boolean hasShadow = false;

        hasShadow=true;
        planetView.setStarColor(starColor);
        planetView.setHasShadow(hasShadow);
        if (hasShadow) {
            planetView.setMatchColor(starColor);
        } else {
            planetView.setMatchColor(PlanetView.COLOR_MOST_ACTIVE);
        }
        int starWidth = SizeUtils.dp2px(context, 50.0f);
        int starHeight = SizeUtils.dp2px(context, 85.0f);
        int starPaddingTop = SizeUtils.dp2px(context, 20.0f);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(starWidth, starHeight);
        planetView.setPadding(0, starPaddingTop, 0, 0);
        planetView.setLayoutParams(layoutParams);
        return planetView;
    }

    @Override
    public View getSpecialView(Context context, ViewGroup parent) {
        PlanetView planetView = new PlanetView(context);
        planetView.setSign("我……");
        planetView.setStarColor(PlanetView.COLOR_Special_Words);
        planetView.setHasShadow(true);
        planetView.setMatchColor(PlanetView.COLOR_Special_Words);
        int starWidth = SizeUtils.dp2px(context, 50.0f);
        int starHeight = SizeUtils.dp2px(context, 85.0f);
        int starPaddingTop = SizeUtils.dp2px(context, 20.0f);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(starWidth, starHeight);
        planetView.setPadding(0, starPaddingTop, 0, 0);
        planetView.setLayoutParams(layoutParams);
        return planetView;
    }

    /**
     * 获取语言表白
     *
     * @return 语言表白
     */
    private String getRandomNick() {
//        Random random = new Random();
//        int len = random.nextInt(12) + 1;
//        StringBuilder builder = new StringBuilder();
//        for (int i = 0; i < len; i++) {
//            builder.append(getRandomSingleCharacter());
//        }
        String str = getRandomString();
        return str;
    }

    /**
     * 获取随机单个汉字
     *
     * @return 随机单个汉字
     */
    private String getRandomSingleCharacter() {
        String str = "";
        int heightPos;
        int lowPos;
        Random rd = new Random();
        heightPos = 176 + Math.abs(rd.nextInt(39));
        lowPos = 161 + Math.abs(rd.nextInt(93));
        byte[] bt = new byte[2];
        bt[0] = Integer.valueOf(heightPos).byteValue();
        bt[1] = Integer.valueOf(lowPos).byteValue();
        try {
            str = new String(bt, "GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return str;
    }

    /**
     * 获取随机字符串
     * @return 返回获取到的随机字符串
     */
    protected String getRandomString(){
        String str = "";
        int randomNum=0;
        String randomChar;
        Random random = new Random();
        //字符串
        ArrayList<String> list = new ArrayList<>();
        list.add("我爱你");
        list.add("I love you");
        list.add("je t'aime");
        list.add("사랑해 ");
        list.add("ich liebe dich");
        list.add("Ti Amo");
        list.add("爱している");
        list.add("ik hou van jou");
        list.add("te amo vos amo");
        list.add("milujite");
        list.add("chit pade");
        randomNum = random.nextInt(list.size());
        randomChar = list.get(randomNum);
        return randomChar;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public int getPopularity(int position) {
        return position % 10;
    }

    @Override
    public void onThemeColorChanged(View view, int themeColor) {

    }
}