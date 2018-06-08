package net.chabibnr.latihan;

import android.app.ActionBar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import net.chabibnr.latihan.Content.CollapsingToolbar;
import net.chabibnr.latihan.Content.ContentCalendar;
import net.chabibnr.latihan.Content.ContentGithub;
import net.chabibnr.latihan.Content.ContentGridLayout;
import net.chabibnr.latihan.Content.ContentRecyclerView;
import net.chabibnr.latihan.Content.ContentRecyclerViewHorizontal;
import net.chabibnr.latihan.Content.ContentRecyclerViewWithScrollView;
import net.chabibnr.latihan.Content.RecyclerViewAdapter;
import net.chabibnr.latihan.Content.SettingsActivity;
import net.chabibnr.latihan.Navigation.BottomNavigation;
import net.chabibnr.latihan.Navigation.TabNavigation;
import net.chabibnr.latihan.SystemBar.DimSystemBar;
import net.chabibnr.latihan.SystemBar.FullScreenMode;
import net.chabibnr.latihan.SystemBar.FullScreenModeWithResponseChange;
import net.chabibnr.latihan.SystemBar.HiddenNavigationBar;
import net.chabibnr.latihan.SystemBar.HiddenStatusBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    RecyclerView mRecyclerView;
    RecyclerViewAdapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    SwipeRefreshLayout mSwipeRefreshLayout;
    Model mModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActionBar actionBar = getActionBar();
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

        mModel = new Model(this);
        mModel.add("Dim System Bar", "Membuat Dim status bar", DimSystemBar.class);
        mModel.add("Hidden status bar", "Menghilangkan Status bar", HiddenStatusBar.class);
        mModel.add("Hidden Navigation Bar", "Menghilangkan Navigation Bar", HiddenNavigationBar.class);
        mModel.add("Full Screen Mode", "Fullscreen", FullScreenMode.class);
        mModel.add("Fullscreen mode response change", "Fullscreen dengan callback status", FullScreenModeWithResponseChange.class);
        mModel.add("Navigation Tab", "Tab Navigasi", TabNavigation.class);
        mModel.add("Navigation Bottom", "Bottom Navigasi", BottomNavigation.class);
        mModel.add("RecyclerView", "List daftar aplikasi", ContentRecyclerView.class);
        mModel.add("RecyclerView Horizontal", "List daftar aplikasi Horizontal", ContentRecyclerViewHorizontal.class);
        mModel.add("Recycler ScrollView", "REcyclerView + Scrollview", ContentRecyclerViewWithScrollView.class);
        mModel.add("Github Repository", "Menampilkan daftar repo", ContentGithub.class);
        mModel.add("Calendar", "Menampilkan Kalender", ContentCalendar.class);
        mModel.add("Grid Layout", "Menampilkan data Grid", ContentGridLayout.class);
        mModel.add("Collapsing Toolbar", "Collapsing toolbar", CollapsingToolbar.class);
        mModel.add("Settings", "Halaman Pengaturan", SettingsActivity.class);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, linearLayoutManager.getOrientation());

        mLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.getOrientation();
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new RecyclerViewAdapter(mModel);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addItemDecoration(dividerItemDecoration);

    }


    @Override
    public void onRefresh() {
        /*
        ArrayList<Model.Item> items = new ArrayList<Model.Item>();
        Model.Item item = mModel.createItem("TEst", "Keterangan", HiddenStatusBar.class);
        items.add(item);
        Model.Item item1 = mModel.createItem("TEst", "Keterangan", HiddenStatusBar.class);
        items.add(item1);
        Model.Item item2 = mModel.createItem("TEst", "Keterangan", HiddenStatusBar.class);
        items.add(item2);
        Model.Item item3 = mModel.createItem("TEst", "Keterangan", HiddenStatusBar.class);
        items.add(item3);
        mAdapter.addModel(items);
*/
        mSwipeRefreshLayout.setRefreshing(false);
    }
}
