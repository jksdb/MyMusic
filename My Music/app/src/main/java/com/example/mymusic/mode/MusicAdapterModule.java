package com.example.mymusic.mode;

import android.content.Context;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

/**
 * Created by 全是小仙女 on 2017/7/4 0004.
 */


@Module
public class MusicAdapterModule {
    Context context;
    ArrayList<String> list;

    public MusicAdapterModule(Context context, ArrayList<String> list) {
        this.context = context;
        this.list = list;
    }

    @Provides
    Context providesContext() {
        return context;
    }

    @Provides
    ArrayList<String> providesArrayList() {
        return list;
    }
}
