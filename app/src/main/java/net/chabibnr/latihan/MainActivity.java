package net.chabibnr.latihan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import net.chabibnr.latihan.Content.ContentRecyclerView;
import net.chabibnr.latihan.Navigation.TabNavigation;
import net.chabibnr.latihan.SystemBar.DimSystemBar;
import net.chabibnr.latihan.SystemBar.FullScreenMode;
import net.chabibnr.latihan.SystemBar.FullScreenModeWithResponseChange;
import net.chabibnr.latihan.SystemBar.HiddenNavigationBar;
import net.chabibnr.latihan.SystemBar.HiddenStatusBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void activityDimSystemBar(View view){
        Intent i = new Intent(this, DimSystemBar.class);
        startActivity(i);
    }

    public void activityHiddenStatusBar(View view){
        Intent i = new Intent(this, HiddenStatusBar.class);
        startActivity(i);
    }

    public void activityHiddenNavigationBar(View view){
        Intent i = new Intent(this, HiddenNavigationBar.class);
        startActivity(i);
    }

    public void activityFullScreenMode(View view){
        Intent i = new Intent(this, FullScreenMode.class);
        startActivity(i);
    }
    public void activityFullScreenModeWithResponseChange(View view){
        Intent i = new Intent(this, FullScreenModeWithResponseChange.class);
        startActivity(i);
    }

    public void activityNavigationTab(View view){
        Intent i = new Intent(this, TabNavigation.class);
        startActivity(i);
    }

    public void activityRecyclerView(View view){
        Intent i = new Intent(this, ContentRecyclerView.class);
        startActivity(i);
    }
}
