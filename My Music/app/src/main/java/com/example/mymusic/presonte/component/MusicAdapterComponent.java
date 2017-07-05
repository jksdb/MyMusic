package com.example.mymusic.presonte.component;

import com.example.mymusic.mode.MusicAdapterModule;
import com.example.mymusic.ui.fragment.MusicFragment;

import dagger.Component;

/**
 * Created by 全是小仙女 on 2017/7/4 0004.
 */

@Component(modules = MusicAdapterModule.class)
public interface MusicAdapterComponent {
    void inject(MusicFragment activity);
}
