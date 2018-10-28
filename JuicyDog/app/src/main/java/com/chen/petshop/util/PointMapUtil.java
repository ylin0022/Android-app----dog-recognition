package com.chen.petshop.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.widget.Toast;

import com.chen.petshop.domain.StoreBean;

import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with Android Studio
 * Author:Chen·ZD
 * Date:2018/10/24
 */

public class PointMapUtil {


    public static boolean isAvilible(Context context, String packageName) {
        //获取packagemanager
        final PackageManager packageManager = context.getPackageManager();
        //获取所有已安装程序的包信息
        List<PackageInfo> packageInfos = packageManager.getInstalledPackages(0);
        //用于存储所有已安装程序的包名
        List<String> packageNames = new ArrayList<String>();
        //从pinfo中将包名字逐一取出，压入pName list中
        if (packageInfos != null) {
            for (int i = 0; i < packageInfos.size(); i++) {
                String packName = packageInfos.get(i).packageName;
                packageNames.add(packName);
            }
        }
        //判断packageNames中是否有目标程序的包名，有TRUE，没有FALSE
        return packageNames.contains(packageName);
    }

    /***
     * 是否安装腾讯地图
     * @return
     */
    public boolean isHaveTencentMap() {
        try {
            if (!new File("/data/data/" + "com.tencent.map").exists()) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }


    public static void openBaiduMap(Context context, StoreBean bean) {
        if (isAvilible(context, "com.baidu.BaiduMap")) {//传入指定应用包名

            Intent intent = new Intent();
            String url = String.format("baidumap://map/marker?location=%s,%s&title=%s&content=%s&traffic=on&src=andr.baidu.openAPIdemo",
                    bean.getX(), bean.getY(), bean.getAddress(), bean.getName());
            intent.setData(Uri.parse(url));
            context.startActivity(intent); //启动调用
        } else {//未安装
            //market为路径，id为包名
            //显示手机上所有的market商店
            Toast.makeText(context, "This map is not installed", Toast.LENGTH_LONG).show();
            Uri uri = Uri.parse("market://details?id=com.baidu.BaiduMap");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            context.startActivity(intent);
        }
    }


    public static void openGaoDeMap(Context context, StoreBean bean) {
        Intent intent;
        if (isAvilible(context, "com.autonavi.minimap")) {
            try {
                intent = Intent.getIntent(String.format("androidamap://viewMap?sourceApplication=appname&poiname=%s&lat=%s&lon=%s&dev=0", bean.getName(), bean.getX(), bean.getY()));
                context.startActivity(intent);
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        } else {
            Toast.makeText(context, "This map is not installed", Toast.LENGTH_LONG).show();
            Uri uri = Uri.parse("market://details?id=com.autonavi.minimap");
            intent = new Intent(Intent.ACTION_VIEW, uri);
            context.startActivity(intent);
        }

    }


    public static void openGoogleMap(Context context, StoreBean bean) {
        Intent intent;
        if (isAvilible(context, "com.google.android.apps.maps")) {
            Uri gmmIntentUri = Uri.parse(String.format("google.navigation:q=%s,%s", bean.getX(), bean.getY()));
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            context.startActivity(mapIntent);
        } else {
            Toast.makeText(context, "This map is not installed", Toast.LENGTH_LONG).show();

            Uri uri = Uri.parse("market://details?id=com.google.android.apps.maps");
            intent = new Intent(Intent.ACTION_VIEW, uri);
            context.startActivity(intent);
        }

    }

}
