package com.example.mymusic.ui.act;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.example.mymusic.R;
import com.example.mymusic.mode.ZhuModule;
import com.example.mymusic.presonte.DaggerZhuCompontent;
import com.example.mymusic.ui.fragment.BaseFragment;
import com.example.mymusic.ui.fragment.LiveFragment;
import com.example.mymusic.ui.fragment.MusicFragment;
import com.example.mymusic.ui.fragment.VideoFragment;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 全是小仙女 on 2017/7/4 0004.
 */

public class ZhuActivity extends AppCompatActivity {

    @BindView(R.id.main_tab)
    TabLayout mainTab;
    @BindView(R.id.main_viewpager)
    ViewPager mainViewpager;
    private ArrayList<BaseFragment> fragments = new ArrayList<>();
    @Inject
    MusicFragment musicFragment;
    @Inject
    VideoFragment videoFragment;
    @Inject
    LiveFragment liveFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //判断设备版本是否大于4.4  api19
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
        }
        setContentView(R.layout.zhu_activity);
        DaggerZhuCompontent
        .builder()
                .zhuModule(new ZhuModule())
                .build()
                .inject(this);
        ButterKnife.bind(this);

        //添加fragment到集合中
        addFragment();

        // 设置viewpager
        setViewpager();
    }

    // 设置状态栏透明状态
    private void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

    private void setViewpager() {
        // 初始化 适配器
        FragmentPagerAdapter fragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            //设置pager标题
            @Override
            public CharSequence getPageTitle(int position) {
                // 获取 string.xml中的 StringArray的值
                return getResources().getStringArray(R.array.fragment_list)[position];
            }
        };
        // 给viewpager设置适配器
        mainViewpager.setAdapter(fragmentPagerAdapter);
        // 设置 tablayout和viewpager联动
        mainTab.setupWithViewPager(mainViewpager);
    }

    private void addFragment() {
        fragments.add(musicFragment);
        fragments.add(videoFragment);
        fragments.add(liveFragment);
    }
}
