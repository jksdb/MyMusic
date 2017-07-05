package com.example.mymusic.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mymusic.R;
import com.example.mymusic.mode.MainModule;
import com.example.mymusic.presonte.DaggernewImpl;
import com.example.mymusic.presonte.component.IInterface;
import com.example.mymusic.ui.act.IMain;
import com.example.mymusic.ui.act.ZhuActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements IMain {

    @BindView(R.id.main_imageview)
    ImageView mainImageview;
    @BindView(R.id.main_textview_tiaoguo)
    TextView mainTextviewTiaoguo;
    @Inject
    IInterface iInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去掉标题栏和状态栏
//      requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        DaggernewImpl.builder().mainModule(new MainModule(this)).build().inject(this);

        iInterface.timer();
    }

    @OnClick({R.id.main_imageview, R.id.main_textview_tiaoguo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.main_imageview:
                iInterface.tiaoP();
                break;
            case R.id.main_textview_tiaoguo:
                iInterface.tiaoP();
                break;
        }
    }

    @Override
    public void tiao() {
        startActivity(new Intent(this, ZhuActivity.class));
        finish();
    }

    @Override
    public void onBackPressed() {
    }
}
