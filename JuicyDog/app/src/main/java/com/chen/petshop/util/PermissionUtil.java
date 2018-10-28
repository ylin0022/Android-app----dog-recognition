package com.chen.petshop.util;


import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;

import java.util.ArrayList;
import java.util.List;

public class PermissionUtil {

    public static void requestPermission(Activity context) {
        ArrayList list = new ArrayList<String>();
        // 版本判断。当手机系统大于 23 时，才有必要去判断权限是否获取
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkPermission(context, list, Manifest.permission.READ_EXTERNAL_STORAGE);
            if (list.size() != 0) {
                showDialogTipUserRequestPermission(context, (String[]) list.toArray(new String[list.size()]));
            }
        }
    }

    private static void checkPermission(Context context, List<String> list, String permission) {
        int state = ContextCompat.checkSelfPermission(context, permission);
        if (state != PackageManager.PERMISSION_GRANTED) {
            list.add(permission);
        }
    }


    // 提示用户该请求权限的弹出框
    private static void showDialogTipUserRequestPermission(final Activity activity, final String permission[]) {
        new AlertDialog.Builder(activity)
                .setTitle("存储权限不可用")
                .setMessage("由于软件需要获取您的相册,需要读取权限；\n否则，您将无法正常使用本软件")
                .setPositiveButton("立即开启", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ActivityCompat.requestPermissions(activity, permission, 321);
                    }
                })
                .setNegativeButton("取消", null)
                .setCancelable(false)
                .show();
    }

    // 提示用户去应用设置界面手动开启权限

    public static void showDialogTipUserGoToAppSettting(final Activity context) {

       new AlertDialog.Builder(context)
                .setTitle("存储权限不可用")
                .setMessage("请在-应用设置-权限-中，允许软件使用读取权限")
                .setPositiveButton("立即开启", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 跳转到应用设置界面
                        goToAppSetting(context);
                    }
                })
                .setNegativeButton("取消", null).setCancelable(false).show();
    }

    // 跳转到当前应用的设置界面
    private static void goToAppSetting(Activity activity) {
        Intent intent = new Intent();

        intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", activity.getPackageName(), null);
        intent.setData(uri);

        activity.startActivityForResult(intent, 123);
    }
}
