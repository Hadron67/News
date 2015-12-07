package com.xiao.news;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by cfy on 15-11-22.
 */
public class MainActivity extends FragmentActivity implements MsgReceiveListener{
    private FragmentTabHost mTabHost = null;
    private View indicator = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.layout_fragment);
        getActionBar().setBackgroundDrawable(new ColorDrawable(Color.argb(255, 60, 179, 113)));
        this.mTabHost = (FragmentTabHost) findViewById(R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.tabcontent);
        mTabHost.addTab(mTabHost.newTabSpec("tab1").setIndicator("Notice"), fragment1.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("tab2").setIndicator("Everday"),fragment2.class,null);
        mTabHost.addTab(mTabHost.newTabSpec("tab3").setIndicator("With"),fragment1.class,null);
        mTabHost.addTab(mTabHost.newTabSpec("tab4").setIndicator("Style"),fragment1.class,null);
    }

    @Override
    public void onMsgReceive(String msg) {

    }

    @Override
    public void onPushReceive(String msg) {

    }

    @Override
    public void onGetClientID(String id) {

    }
    private View $(int id){
        return findViewById(id);
    }

    public static class fragment1 extends android.support.v4.app.Fragment{
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.tab_notice,container,false);
            return v;
        }
    }
    public static class fragment2 extends android.support.v4.app.Fragment{
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.tab_everyday,container,false);
        }
    }

}
