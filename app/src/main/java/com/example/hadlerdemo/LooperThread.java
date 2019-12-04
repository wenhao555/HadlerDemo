package com.example.hadlerdemo;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import androidx.annotation.NonNull;


public class LooperThread extends Thread
{
    public Handler handler;

    @SuppressLint("HandlerLeak")
    @Override
    public void run()
    {
        super.run();
        Looper.prepare();//初始化一个Looper对象
        handler = new Handler()
        {
            @Override
            public void handleMessage(@NonNull Message msg)
            {
                super.handleMessage(msg);
                Log.e("Looper", String.valueOf(msg.what));
            }
        };
        Message message = handler.obtainMessage();//获取一个消息
        message.what = 1;
        handler.sendMessage(message);//发送消息
        Looper.loop();//启动Looper，之后的代码不会执行
        handler.getLooper().quit();//结束Looper，此时之后的代码会执行
        Log.e("Looper", String.valueOf("结束"));
    }
}
