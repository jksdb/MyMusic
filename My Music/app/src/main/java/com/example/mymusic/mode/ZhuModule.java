package com.example.mymusic.mode;

import com.example.mymusic.ui.fragment.LiveFragment;
import com.example.mymusic.ui.fragment.MusicFragment;
import com.example.mymusic.ui.fragment.VideoFragment;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by 全是小仙女 on 2017/7/4 0004.
 */
@Module
public class ZhuModule {

    @Provides
    @Singleton
    MusicFragment providesMainFragment() {
        return new MusicFragment();
    }

    @Provides
    @Singleton
  VideoFragment providesMainVideoFragment() {
        return new VideoFragment();
    }

    @Provides
    @Singleton
   LiveFragment providesMainLiveFragment() {
        return new LiveFragment();
    }
}
