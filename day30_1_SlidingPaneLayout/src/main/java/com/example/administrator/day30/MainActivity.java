package com.example.administrator.day30;

import android.graphics.Color;
import android.nfc.Tag;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private SlidingPaneLayout layout;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initView();
        setPaneListener();

        // 设置菜单滑动过程当中，内容页部分上方覆盖的颜色
        layout.setSliderFadeColor(Color.TRANSPARENT);
        // 设置菜单和内容页部分过渡的阴影图片
        layout.setShadowResourceLeft(R.mipmap.ic_launcher);

    }

    private void setPaneListener() {
        layout.setPanelSlideListener(new SlidingPaneLayout.PanelSlideListener() {
            // 菜单移动过程中调用的方法
            @Override
            public void onPanelSlide(View panel, float slideOffset) {
                Log.i(TAG, "onPanelSlide: " + slideOffset);
            }

            // 菜单打开后调用的方法.
            @Override
            public void onPanelOpened(View panel) {
                Log.i(TAG, "onPanelOpened: ");
            }

            // 菜单关闭后调用的方法。
            @Override
            public void onPanelClosed(View panel) {
                Log.i(TAG, "onPanelClosed: ");
            }
        });
    }

    private void initView() {
        layout = (SlidingPaneLayout) findViewById(R.id.slidingpanelayout);
    }

    public void click(View view) {
        switch (view.getId()) {
            case R.id.btn_close:
                layout.closePane();
                break;
            case R.id.btn_content:
                layout.openPane();
                break;
        }
    }
}
