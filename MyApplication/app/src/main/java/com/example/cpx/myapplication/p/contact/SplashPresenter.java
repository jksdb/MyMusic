package com.example.cpx.myapplication.p.contact;

import android.os.Handler;
import android.os.Message;

import com.example.cpx.myapplication.p.impl.ISplashPresenter;



/**
 * Created by CPX on 2017/6/28 0028.
 */

public class SplashPresenter implements ISplashPresenter.presenterContact {
    private ISplashPresenter.SplashClick splashCilck;
private Handler handler=new Handler(){
    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        splashCilck.inToMain();
    }
};
    public SplashPresenter(ISplashPresenter.SplashClick splashCilck) {
        this.splashCilck = splashCilck;
    }

    @Override
    public void Timer() {
        handler.sendEmptyMessageDelayed(1,3000);
    }

    @Override
    public void onClick() {
        handler.removeMessages(1);
        splashCilck.inToMain();
    }


}
