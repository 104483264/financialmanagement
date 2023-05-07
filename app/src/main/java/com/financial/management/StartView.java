package com.financial.management;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class StartView extends AppCompatActivity {
    private Button btn_jump;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        btn_jump = findViewById(R.id.btn_jump);
        InitEvent();//初始化触发事件
        btn_jump.setOnClickListener(v -> handler.sendEmptyMessage(10));
    }

    private void InitEvent() {
        handler.sendEmptyMessageDelayed(2, 1000);
    }

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {//添加handler的消息等待方法来实现倒计时的显示
            super.handleMessage(msg);
            if (msg.what == 2) {
                btn_jump.setText("跳过(2)");
                handler.sendEmptyMessageDelayed(1, 1000);
            } else if (msg.what == 1) {
                btn_jump.setText("跳过(1)");
                handler.sendEmptyMessageDelayed(0, 1000);
            } else if (msg.what == 0) {
                btn_jump.setText("跳过(0)");
                handler.sendEmptyMessageDelayed(10, 1000);
            } else if (msg.what == 10) {
                Intent intent = new Intent(StartView.this, MainActivity.class);
                startActivity(intent);
                finish();
            }

        }
    };

    //这是一个权限申请
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        InitEvent();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeMessages(2);
        handler.removeMessages(1);
        handler.removeMessages(0);
    }



    }


