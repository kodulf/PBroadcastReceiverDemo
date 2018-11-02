package bjpkten.p_broadcastreceiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import kodulf.baselibs.utils.AppUtils;

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
