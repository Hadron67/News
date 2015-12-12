package com.xiao.news;

import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiEnterpriseConfig;
import android.net.wifi.p2p.WifiP2pDevice;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by cfy on 15-12-7.
 */
public class NoticeFragment extends android.support.v4.app.Fragment implements MsgReceiveListener {

    private static PushItemAdapter pia = null;

    private static SimpleDateFormat format = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_notice,container,false);
        ListView pushlist = (ListView) v.findViewById(R.id.list_pushitems);
        if(pia == null) pia = new PushItemAdapter(getActivity());
        if(format == null) format = new SimpleDateFormat("HH:mm:ss");

        pushlist.setAdapter(pia);

        PushReceiver.setMsgReceiveListener(this);
        return v;
    }

    @Override
    public void OnMsgReceive(String msg) {
        pia.addItem(new PushData(format.format(new Date(System.currentTimeMillis())),msg));
        pia.notifyDataSetChanged();
    }

    @Override
    public void OnPushReceive(String msg) {

    }

    @Override
    public void OnGetClientID(String id) {

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }
}
