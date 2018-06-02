package net.chabibnr.latihan.Content;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import net.chabibnr.latihan.Navigation.tab.CollectionPagerAdapter;
import net.chabibnr.latihan.R;

public class ContentRecyclerView extends AppCompatActivity{

    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActionBar actionBar = getActionBar();
        setContentView(R.layout.activity_content_recyclerview);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        String[] myAdapter = new String[] {"element1","element2","element3"};
        mAdapter = new RecyclerViewAdapter(myAdapter);
        mRecyclerView.setAdapter(mAdapter);

    }

}
