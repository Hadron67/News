package com.xiao.news;

/**
 * Created by cfy on 15-10-7.
 */
public interface MsgReceiveListener {
    public void OnMsgReceive(String msg);
    public void OnPushReceive(String msg);
    public void OnGetClientID(String id);
}
