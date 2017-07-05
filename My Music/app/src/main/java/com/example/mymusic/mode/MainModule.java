package com.example.mymusic.mode;

import com.example.mymusic.presonte.component.IInterface;
import com.example.mymusic.presonte.impl.InterfaceImpl;
import com.example.mymusic.ui.act.IMain;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by 全是小仙女 on 2017/7/4 0004.
 */
@Module
public class MainModule {
  InterfaceImpl anInterface;

    public MainModule(IMain iMain) {
        this.anInterface =new InterfaceImpl(iMain);
    }

    @Provides
    @Singleton
    IInterface iInterface () {
        return anInterface;
    }
}
