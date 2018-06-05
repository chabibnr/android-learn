package net.chabibnr.latihan.Content;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import net.chabibnr.latihan.Adapter.GithubAdapter;
import net.chabibnr.latihan.Adapter.RecyclerViewAdapter;
import net.chabibnr.latihan.Library.Http;
import net.chabibnr.latihan.Models.GithubModel;
import net.chabibnr.latihan.Models.PackageModel;
import net.chabibnr.latihan.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ContentGithub extends AppCompatActivity  implements SwipeRefreshLayout.OnRefreshListener{

    ActionBar mActionBar;
    Context mContext;

    RecyclerView mRecyclerView;
    GithubAdapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mActionBar = getSupportActionBar();
        mActionBar.setTitle("Github Repository");

        mContext = this;
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

        GithubModel model = new GithubModel(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, linearLayoutManager.getOrientation());

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new GithubAdapter(model);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addItemDecoration(dividerItemDecoration);

        loadFeedData();
        //Http http = Http.getInstance(this);

    }

    private void loadFeedData(){
        String url = "https://api.github.com/users/chabibnr/repos";
        mSwipeRefreshLayout.setRefreshing(true);
        JsonArrayRequest jsonObjectRequest = new JsonArrayRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {
                        mSwipeRefreshLayout.setRefreshing(false);
                        Log.d("Response Github ", response.toString());
                        ArrayList<GithubModel> models = new ArrayList<GithubModel>();
                        for(int i =0; i < response.length(); i++){
                            try {
                                JSONObject object = response.getJSONObject(i);
                                GithubModel model = new GithubModel(object.getString("full_name"),object.getString("name"));
                                models.add(model);
                            }catch (JSONException je){

                            }
                        }
                        mAdapter.addModel(models);
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        mSwipeRefreshLayout.setRefreshing(false);
                        // TODO: Handle error
                        Toast.makeText(mContext, "Gagal memuat", Toast.LENGTH_LONG).show();
                    }
                });

// Access the RequestQueue through your singleton class.
        Http.getInstance(this).addToRequestQueue(jsonObjectRequest);
    }

    @Override
    public void onRefresh() {
        loadFeedData();
    }
}
