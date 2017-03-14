package com.ssdj.dagger2tab.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import javax.inject.Inject;

/**
 * @author 陈  杰
 * @version $Rev$
 * @time 2017/2/20 16:10
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes ${TODO}
 */
public class FragmentAdapter extends FragmentPagerAdapter
{
    private Context context;
    private String[] titles;
    private List<Fragment> fragments;

    @Inject
    public FragmentAdapter(Context context, FragmentManager fm, String[] titles, List<Fragment> fragments)
    {
        super(fm);
        this.context = context;
        this.titles = titles;
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position)
    {
        return fragments.get(position);
    }

    @Override
    public int getCount()
    {
        if (fragments != null)
        {
            return fragments.size();
        } else
        {
            return 0;
        }
    }

    @Override
    public CharSequence getPageTitle(int position)
    {
        return titles[position];
    }
}
