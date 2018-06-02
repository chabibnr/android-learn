package net.chabibnr.latihan.Navigation.tab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class CollectionPagerAdapter extends FragmentStatePagerAdapter {

    public CollectionPagerAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int i){
        Fragment fragment = new ObjectFragment();
        Bundle args = new Bundle();
        args.putInt(ObjectFragment.ARG_OBJECT, i + 1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount(){
        return 100;
    }

    @Override
    public CharSequence getPageTitle(int position){

        return "OBJECT "+ (position + 1);
    }
}
