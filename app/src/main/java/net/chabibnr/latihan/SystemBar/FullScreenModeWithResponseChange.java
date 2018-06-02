package net.chabibnr.latihan.SystemBar;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class FullScreenModeWithResponseChange extends AppCompatActivity {

    public Context mContext;


    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mContext = this;

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Full Screen Mode");

        View decorView = getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener(){
            @Override
            public void onSystemUiVisibilityChange(int visibility){
                if((visibility & View.SYSTEM_UI_FLAG_FULLSCREEN) == 0){
                    Toast.makeText(mContext,"Normal Mode", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(mContext,"Fullscreen Mode", Toast.LENGTH_LONG).show();
                }
            }
        });


    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus){
        super.onWindowFocusChanged(hasFocus);
        if(hasFocus){
            hiddenSystemUi();
        }
    }

    private void hiddenSystemUi(){
        View decorView = getWindow().getDecorView();

        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
        );
    }

    private void showSystemUi(){
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        );
    }
}
