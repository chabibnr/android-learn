package net.chabibnr.latihan.Content;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


import net.chabibnr.latihan.Adapter.RecyclerViewAdapter;
import net.chabibnr.latihan.Models.PackageModel;
import net.chabibnr.latihan.R;

public class ContentRecyclerView extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener{


    RecyclerView mRecyclerView;
    RecyclerViewAdapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    StaggeredGridLayoutManager mStaggeredGridLayoutManager;
    SwipeRefreshLayout mSwipeRefreshLayout;
    PackageModel mPackageModel;
    DividerItemDecoration mDividerItemDecoration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("RecyclerView");
        setContentView(R.layout.activity_content_recyclerview);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        // SwipeRefreshLayout
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_container);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary,
                android.R.color.holo_green_dark,
                android.R.color.holo_orange_dark,
                android.R.color.holo_blue_dark);

        mPackageModel = new PackageModel(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mDividerItemDecoration = new DividerItemDecoration(this, linearLayoutManager.getOrientation());

        mLayoutManager = new LinearLayoutManager(this);
        mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(3, linearLayoutManager.getOrientation());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new RecyclerViewAdapter(mPackageModel);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addItemDecoration(mDividerItemDecoration);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.switch_view_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_listview:
                mRecyclerView.setLayoutManager(mLayoutManager);
                mAdapter = new RecyclerViewAdapter(mPackageModel);
                mRecyclerView.setAdapter(mAdapter);
                mRecyclerView.addItemDecoration(mDividerItemDecoration);
                break;
            case R.id.menu_gridview:
                mRecyclerView.setLayoutManager(mStaggeredGridLayoutManager);
                mAdapter = new RecyclerViewAdapter(mPackageModel, R.layout.content_recyclerview_item_image_horizontal_2);
                mRecyclerView.setAdapter(mAdapter);
                mRecyclerView.removeItemDecoration(mDividerItemDecoration);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onRefresh() {
        //PackageModel model = new PackageModel(this);
        //mAdapter.addModel(model.all());
        mSwipeRefreshLayout.setRefreshing(false);
    }
}
