package com.ssdj.dagger2tab.dagger;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.ssdj.dagger2tab.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;

/**
 * @author 陈  杰
 * @version $Rev$
 * @time 2017/2/20 16:43
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes ${TODO}
 */
@Module
public class AppModule
{
    private AppCompatActivity activity;

    public AppModule(AppCompatActivity activity)
    {
        this.activity = activity;
    }


    @Provides
    public FragmentManager provideFragmentManager()
    {
        FragmentManager fg = activity.getSupportFragmentManager();
        return fg;
    }

    @Provides
    public Context provideContext()
    {
        return activity;
    }

    @Provides
    public String[] provideTitles()
    {
        String[] titles = new String[]{
                "聊天", "好友", "发现", "我的",
                "搜索", "新闻", "娱乐", "导航",
                "八卦", "天气", "旅游", "美食",
                "手机", "商城", "车票", "出行"};
        return titles;
    }

    @Provides
    public List<Fragment> provideFragmens(String[] titles)
    {
        List<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < titles.length; i++)
        {
            fragments.add(BaseFragment.newInstance(titles[i]));
        }
        return fragments;
    }
}
