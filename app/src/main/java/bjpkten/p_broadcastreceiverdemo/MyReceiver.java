package bjpkten.p_broadcastreceiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import kodulf.baselibs.utils.AppUtils;

/**
 * 简单的就是接收开机的广播，然后启动程序
 *
 * 0：首先是权限：
 *
 * <uses-permission android:name="android.permission.RECEIVE_BOOT_COMPLETED"/>
 * 1：然后是创建广播接受者;
 *
 * 要注意两点：安装包名，这个可以在清单文件中找到，
 *
 * <manifest xmlns:android="http://schemas.android.com/apk/res/android"
 *     xmlns:tools="http://schemas.android.com/tools"
 *     package="com.wbm.app.tvad">
 *
 * 还有就是启动的时候必须要设置一个Flag：不然会报错：
 * intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
 * package com.wbm.app.receiver;
 *
 * import android.content.BroadcastReceiver;
 * import android.content.ComponentName;
 * import android.content.Context;
 * import android.content.Intent;
 * import android.content.pm.PackageInfo;
 * import android.content.pm.PackageManager;
 * import android.content.pm.ResolveInfo;
 * import android.util.Log;
 * import android.view.View;
 * import android.widget.Toast;
 *
 * import com.wbm.app.tvad.LoginActivity;
 *
 * import java.util.List;
 *
 * public class TvStartReceiver extends BroadcastReceiver {
 *     public TvStartReceiver() {
 *     }
 *
 *     @Override
 *     public void onReceive(Context context, Intent intent) {
 *             // TODO: This method is called when the BroadcastReceiver is receiving
 *             // an Intent broadcast.
 *     //        throw new UnsupportedOperationException("Not yet implemented");
 *             Log.d("kodulf", "TV 启动了啊");
 *
 *         String action = intent.getAction();
 *         if("android.intent.action.BOOT_COMPLETED".equals(action)){
 *             Log.d("151217MY", "Started...");
 *             //Intent login = new Intent(context, LoginActivity.class);
 *             //service.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
 *             //context.startActivity(service);
 *             //context.startActivity(login);
 *             Toast.makeText(context,"启动了",Toast.LENGTH_LONG).show();
 *             openApp(context,"com.wbm.app.tvad");
 *         }
 *
 *
 *     }
 *
 *     private void openApp(Context context, String packageName) {
 *
 *         PackageInfo pi = null;
 *         PackageManager pm = context.getPackageManager();
 *         try {
 *             pi = pm.getPackageInfo(packageName, 0);
 *         } catch (PackageManager.NameNotFoundException e) {
 *             e.printStackTrace();
 *         }
 *
 *         Intent resolveIntent = new Intent(Intent.ACTION_MAIN, null);
 *         resolveIntent.addCategory(Intent.CATEGORY_LAUNCHER);
 *         resolveIntent.setPackage(pi.packageName);
 *
 *         List<ResolveInfo> apps = pm.queryIntentActivities(resolveIntent, 0);
 *
 *         ResolveInfo ri = apps.iterator().next();
 *         if (ri != null ) {
 *             packageName = ri.activityInfo.packageName;
 *             String className = ri.activityInfo.name;
 *
 *             Intent intent = new Intent(Intent.ACTION_MAIN);
 *             intent.addCategory(Intent.CATEGORY_LAUNCHER);
 *
 *             ComponentName cn = new ComponentName(packageName, className);
 *             intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
 *             intent.setComponent(cn);
 *             context.startActivity(intent);
 *         }
 *     }
 * }
 *
 * 清单文件中的设置：
 * <receiver
 *             android:name="com.wbm.app.receiver.TvStartReceiver"
 *             android:enabled="true"
 *             android:exported="true">
 *             <intent-filter>
 *                 <action android:name="android.intent.action.BOOT_COMPLETED"></action>
 *             </intent-filter>
 *
 *         </receiver>
 *
 *
 *
 * ---------------------
 * 作者：千雅爸爸
 * 来源：CSDN
 * 原文：https://blog.csdn.net/rodulf/article/details/52318195
 * 版权声明：本文为博主原创文章，转载请附上博文链接！
 */
public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.

        String action = intent.getAction();

        if(action.equals("android.intent.action.BOOT_COMPLETED")){
            try {
                AppUtils.openApp(context, "bjpkten.p_broadcastreceiverdemo");
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(context,"启动失败",Toast.LENGTH_LONG).show();
            }
        }
    }
}
