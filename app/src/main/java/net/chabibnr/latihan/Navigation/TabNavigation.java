package net.chabibnr.latihan.Navigation;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import net.chabibnr.latihan.Navigation.tab.CollectionPagerAdapter;
import net.chabibnr.latihan.R;

public class TabNavigation extends AppCompatActivity {

    CollectionPagerAdapter mCollectionPagerAdapter;
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActionBar actionBar = getActionBar();
        setContentView(R.layout.activity_navigation_tab);

        mCollectionPagerAdapter = new CollectionPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mCollectionPagerAdapter);
    }

}
