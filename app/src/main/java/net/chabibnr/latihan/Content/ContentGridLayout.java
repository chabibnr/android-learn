package net.chabibnr.latihan.Content;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import net.chabibnr.latihan.R;

public class ContentGridLayout extends AppCompatActivity {

    ActionBar mActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActionBar = getSupportActionBar();
        mActionBar.setTitle("Grid Layout");

        setContentView(R.layout.activity_gridview);
    }
}
