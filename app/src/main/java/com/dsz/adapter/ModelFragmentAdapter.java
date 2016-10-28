package com.dsz.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.dsz.fragments.ModelLivingFragment;
import com.dsz.fragments.ModelMasterRoomFragment;
import com.dsz.fragments.Monitor3Fragment;
import com.dsz.fragments.Monitor4Fragment;
import com.dsz.fragments.QiTaFragment;


/**
 * Created by Administrator on 2016/10/12.
 */
public class ModelFragmentAdapter extends FragmentPagerAdapter {
    private Fragment[] fragments = new Fragment[]{new ModelLivingFragment(),
            new ModelMasterRoomFragment(), new Monitor3Fragment(), new Monitor4Fragment(), new QiTaFragment()};

    public ModelFragmentAdapter(FragmentManager fm) {
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
