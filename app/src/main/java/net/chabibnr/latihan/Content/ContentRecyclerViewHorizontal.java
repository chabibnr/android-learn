package net.chabibnr.latihan.Content;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.util.Log;

import net.chabibnr.latihan.Adapter.RecyclerViewAdapter;
import net.chabibnr.latihan.Models.PackageModel;
import net.chabibnr.latihan.R;

public class ContentRecyclerViewHorizontal extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {


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
        mRecyclerView = findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        // SwipeRefreshLayout
        mSwipeRefreshLayout = findViewById(R.id.swipe_container);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary,
                android.R.color.holo_green_dark,
                android.R.color.holo_orange_dark,
                android.R.color.holo_blue_dark);

        PackageModel model = new PackageModel(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, linearLayoutManager.getOrientation());

        mLayoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        //mLayoutManager.scrollToPosition(5);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new RecyclerViewAdapter(model, R.layout.content_recyclerview_item_image_horizontal_2);
        mRecyclerView.setAdapter(mAdapter);
        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(mRecyclerView);
        /*
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            int i = 0;
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                i += dx;
                Log.d("Scroll", "a: "+ dx +" | b:"+ dy+" | c: "+i);
            }
        });
        */
        //mRecyclerView.addItemDecoration(dividerItemDecoration);

    }

    @Override
    public void onRefresh() {
        //PackageModel model = new PackageModel(this);
        //mAdapter.addModel(model.all());
        mSwipeRefreshLayout.setRefreshing(false);
    }
}
