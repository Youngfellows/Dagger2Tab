package com.ssdj.dagger2tab;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ssdj.dagger2tab.adapter.FragmentAdapter;
import com.ssdj.dagger2tab.dagger.AppComponent;
import com.ssdj.dagger2tab.dagger.AppModule;
import com.ssdj.dagger2tab.dagger.DaggerAppComponent;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity
{
    @Inject
    FragmentAdapter fgAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findView(R.id.view_pager);
        TabLayout tabLayout = findView(R.id.tab_layout_navi);


        //传统写法
        //        String[] titles = new String[]{
        //                "聊天", "好友", "发现", "我的",
        //                "搜索", "新闻", "娱乐", "导航",
        //                "八卦", "天气", "旅游", "美食",
        //                "手机", "商城", "车票", "出行"};
        //
        //        List<Fragment> fragments = new ArrayList<>();
        //        for (int i = 0; i < titles.length; i++)
        //        {
        //            fragments.add(BaseFragment.newInstance(titles[i]));
        //        }
        //
        //        FragmentManager fg = getSupportFragmentManager();
        //        FragmentAdapter fgAdapter = new FragmentAdapter(this, fg, titles, fragments);
        //        viewPager.setAdapter(fgAdapter);
        //
        //        tabLayout.setupWithViewPager(viewPager);//TabLayout跟随ViewPager切换
        //        tabLayout.getTabAt(2).select();//默认选中

        //使用Dagger2来解耦
        AppComponent appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        appComponent.inject(this);

        viewPager.setAdapter(fgAdapter);
        tabLayout.setupWithViewPager(viewPager);//TabLayout跟随ViewPager切换
        tabLayout.getTabAt(2).select();//默认选中
    }

    public <T extends View> T findView(int id)
    {
        return (T) findViewById(id);
    }

}
