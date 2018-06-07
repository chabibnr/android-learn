package net.chabibnr.latihan.Content;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import net.chabibnr.latihan.Adapter.RecyclerViewAdapter;
import net.chabibnr.latihan.Models.PackageModel;
import net.chabibnr.latihan.R;

public class ContentRecyclerViewHorizontal extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener{


    RecyclerView mRecyclerView;
    RecyclerViewAdapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("RecyclerView Horizontal");
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

        PackageModel model = new PackageModel(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, linearLayoutManager.getOrientation());

        mLayoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, true);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new RecyclerViewAdapter(model, R.layout.content_recyclerview_item_image_horizontal);
        mRecyclerView.setAdapter(mAdapter);
        //mRecyclerView.addItemDecoration(dividerItemDecoration);

    }

    @Override
    public void onRefresh() {
        //PackageModel model = new PackageModel(this);
        //mAdapter.addModel(model.all());
        mSwipeRefreshLayout.setRefreshing(false);
    }
}
