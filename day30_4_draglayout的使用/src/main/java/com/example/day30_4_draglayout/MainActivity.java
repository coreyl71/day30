package com.example.day30_4_draglayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bluemor.reddotface.view.DragLayout;

public class MainActivity extends AppCompatActivity {

    private DragLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        setListener();
    }

    private void setListener() {
        layout.setDragListener(new DragLayout.DragListener() {
            @Override
            public void onOpen() {

            }

            @Override
            public void onClose() {

            }

            @Override
            public void onDrag(float percent) {

            }
        });
    }

    private void initView() {
        layout = (DragLayout) findViewById(R.id.draglayout);
    }
}
