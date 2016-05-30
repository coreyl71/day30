package com.example.day30_2_slidingpanelayout;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import fragment.ContentFragment;
import fragment.MenuFragment;

public class MainActivity extends AppCompatActivity implements ContentFragment.ButtonClickCallback, MenuFragment.ListItemClickCallback{

    private FragmentManager manager;
    private SlidingPaneLayout layout;
    private ContentFragment cf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initFragment();
    }

    private void initFragment() {
        manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.add(R.id.menu_layout, new MenuFragment());
        cf = new ContentFragment();
        ft.add(R.id.contentlayout, cf);
        ft.commit();
    }

    private void initView() {
        layout = (SlidingPaneLayout) findViewById(R.id.slidinglayout);
    }

    // 当ContentFragment中Button被点击时调用此方法
    @Override
    public void buttonClick() {
        layout.openPane();
    }

    // 当MenuFragment中列表的item被点击时运行此方法
    @Override
    public void itemClick(String str) {
        cf.changeText(str);
        layout.closePane();
    }
}
