package com.example.mymusic.presonte;

import com.example.mymusic.mode.ZhuModule;
import com.example.mymusic.ui.act.ZhuActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by 全是小仙女 on 2017/7/4 0004.
 */
@Singleton
@Component(modules = ZhuModule.class)
public interface ZhuCompontent {
    void inject(ZhuActivity activity);
}
