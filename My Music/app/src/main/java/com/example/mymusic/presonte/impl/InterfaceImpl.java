package com.example.mymusic.presonte.impl;

import android.os.Handler;
import android.os.Message;

import com.example.mymusic.presonte.component.IInterface;
import com.example.mymusic.ui.act.IMain;

/**
 * Created by 全是小仙女 on 2017/7/4 0004.
 */
public class InterfaceImpl  implements IInterface {
    private IMain iMain;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    iMain.tiao();
                    break;
            }
        }
    };


    public InterfaceImpl(IMain iMain) {
        this.iMain = iMain;
    }

    @Override
    public void timer() {
        handler.sendEmptyMessageDelayed(1, 3000);
    }


    @Override
    public void tiaoP() {
        handler.removeMessages(1);
        iMain.tiao();
    }
}
