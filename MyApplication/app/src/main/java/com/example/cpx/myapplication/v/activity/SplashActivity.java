package com.example.cpx.myapplication.v.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cpx.myapplication.MainActivity;
import com.example.cpx.myapplication.R;
import com.example.cpx.myapplication.p.contact.SplashPresenter;
import com.example.cpx.myapplication.p.impl.ISplashPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by CPX on 2017/6/28 0028.
 */

public class SplashActivity extends BaseActivity implements ISplashPresenter.SplashClick {

    private ISplashPresenter.presenterContact presenterContact;
    @BindView(R.id.guanggao)
    ImageView guanggao;
    @BindView(R.id.tiaoguo)
    TextView tiaoguo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //取消标题
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
//取消状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        presenterContact = new SplashPresenter(this);
        presenterContact.Timer();

        ButterKnife.bind(this);
    }

    @Override
    public void inToMain() {
        startActivity(new Intent(SplashActivity.this, MainActivity.class));
        finish();
    }


    @OnClick({R.id.guanggao, R.id.tiaoguo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.guanggao:
                presenterContact.onClick();
                break;
            case R.id.tiaoguo:
                presenterContact.onClick();
                break;
        }
    }
}
