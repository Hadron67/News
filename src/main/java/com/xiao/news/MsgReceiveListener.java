package com.xiao.news;

/**
 * Created by cfy on 15-10-7.
 */
public interface MsgReceiveListener {
    public void onMsgReceive(String msg);
    public void onPushReceive(String msg);
    public void onGetClientID(String id);
}
