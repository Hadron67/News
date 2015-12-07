package com.xiao.news;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.igexin.sdk.PushManager;
//import android.support.v4.*;
/**
 * Created by cfy on 15-8-24.
 */
public class MainActivity2 extends Activity implements MsgReceiveListener
{
    private TextView tView= null;
    private EditText tLogView = null;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        PushManager.getInstance().initialize(this.getApplicationContext());
        this.setContentView(R.layout.tab_notice);
        tView = (TextView) findViewById(R.id.text1);
        tLogView = (EditText) findViewById(R.id.edittext1);
        getActionBar().setBackgroundDrawable(new ColorDrawable(Color.argb(255, 60, 179, 113)));
        PushManager.getInstance().initialize(this.getApplicationContext());
        PushReceiver.setMsgReceiveListener(this);
        if (PushReceiver.payloadData != null)
        {
            tLogView.append(PushReceiver.payloadData);

        }
    }
    public void onMsgReceive(String msg)
    {
        this.tLogView.append(msg);
    }
    public void onPushReceive(String msg)
    {

    }
    public void onGetClientID(String id)
    {
        this.tView.setText(id);
    }
}
