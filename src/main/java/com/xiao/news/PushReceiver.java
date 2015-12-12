package com.xiao.news;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.igexin.sdk.PushConsts;
import com.igexin.sdk.PushManager;

public class PushReceiver extends BroadcastReceiver {


    public static StringBuilder payloadData = new StringBuilder();
    private static MsgReceiveListener mReceiver = null;
    public static void setMsgReceiveListener(MsgReceiveListener lm) {
        mReceiver = lm;
    }
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        Log.d("GetuiSdkDemo", "onReceive() action=" + bundle.getInt("action"));

        switch (bundle.getInt(PushConsts.CMD_ACTION)) {
            case PushConsts.GET_MSG_DATA:
                byte[] payload = bundle.getByteArray("payload");

                String taskid = bundle.getString("taskid");
                String messageid = bundle.getString("messageid");

                boolean result = PushManager.getInstance().sendFeedbackMessage(context, taskid, messageid, 90001);

                if (payload != null) {
                    String data = new String(payload);

                    Log.d("GetuiSdkDemo", "receiver payload : " + data);

                    payloadData.append(data);
                    payloadData.append("\n");
                    if(mReceiver != null) {
                        mReceiver.OnMsgReceive(data + "\n");
                    }
                }
                break;

            case PushConsts.GET_CLIENTID:
                String cid = bundle.getString("clientid");
                if(mReceiver != null)
                {
                    mReceiver.OnGetClientID(cid);
                }
                break;

            case PushConsts.THIRDPART_FEEDBACK:

//                  String appid = bundle.getString("appid"); String taskid =
//                  bundle.getString("taskid"); String actionid = bundle.getString("actionid");
//                  String result = bundle.getString("result"); long timestamp =
//                  bundle.getLong("timestamp");
//
//                  Log.d("GetuiSdkDemo", "appid = " + appid); Log.d("GetuiSdkDemo", "taskid = " +
//                  taskid); Log.d("GetuiSdkDemo", "actionid = " + actionid); Log.d("GetuiSdkDemo",
//                  "result = " + result); Log.d("GetuiSdkDemo", "timestamp = " + timestamp);

                break;

            default:
                break;
        }
    }
}