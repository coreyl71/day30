package com.example.day30_3_slidingmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

public class MainActivity extends AppCompatActivity {

    private SlidingMenu menu;
    private Button leftButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 初始化菜单显示
        initMenu();
    }

    private void initMenu() {
        // 创建slidingmenu对象
        menu = new SlidingMenu(this);
        // 指定菜单模式，（左侧菜单、右侧菜单或者双侧菜单）
        menu.setMode(SlidingMenu.LEFT_RIGHT);
        // 指定菜单中的显示内容
        menu.setMenu(R.layout.menu_left);
        // 用于设置双侧菜单中右侧菜单的显示内容
        menu.setSecondaryMenu(R.layout.menu_right);

        // 设置菜单的宽度
        menu.setBehindWidth(300);

        // 当菜单关闭时触摸的起始位置
        menu.setTouchModeBehind(SlidingMenu.TOUCHMODE_NONE);

        // 将菜单添加到页面中显示
        menu.attachToActivity(this, SlidingMenu.SLIDING_WINDOW);
    }

    public void click(View view) {
        switch (view.getId()) {
            case R.id.btn_left:
                menu.toggle();
                break;
            case R.id.btn_right:
                if(menu.isSecondaryMenuShowing()) {
                    menu.showContent();
                } else {
                    menu.showSecondaryMenu();
                }
                break;
        }
    }
}
