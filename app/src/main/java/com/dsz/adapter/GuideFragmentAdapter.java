package com.dsz.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.dsz.fragments.Monitor1Fragment;
import com.dsz.fragments.Monitor2Fragment;
import com.dsz.fragments.Monitor3Fragment;
import com.dsz.fragments.Monitor4Fragment;
import com.dsz.fragments.QiTaFragment;

/**
 * Created by Administrator on 2016/10/12.
 */
public class GuideFragmentAdapter extends FragmentPagerAdapter {
    private Fragment[] fragments = new Fragment[]{new Monitor1Fragment(),
            new Monitor2Fragment(), new Monitor3Fragment(), new Monitor4Fragment(), new QiTaFragment()};

    public GuideFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }
}
