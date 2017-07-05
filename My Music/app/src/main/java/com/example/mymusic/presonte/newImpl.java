package com.example.mymusic.presonte;

import com.example.mymusic.mode.MainModule;
import com.example.mymusic.presonte.impl.InterfaceImpl;
import com.example.mymusic.ui.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by 全是小仙女 on 2017/7/4 0004.
 */
@Singleton
@Component(modules = MainModule.class)
public interface newImpl {
    void inject(MainActivity mainActivity);
}
