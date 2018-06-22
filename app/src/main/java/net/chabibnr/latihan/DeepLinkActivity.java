package net.chabibnr.latihan;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class DeepLinkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deep_link);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView textAction = (TextView) findViewById(R.id.action);
        TextView linkHost = (TextView) findViewById(R.id.link_host);
        TextView linkPath = (TextView) findViewById(R.id.link_path);
        TextView linkParams = (TextView) findViewById(R.id.link_param);

        Intent intent = getIntent();
        String action = intent.getAction();
        Uri data = intent.getData();

        textAction.setText(action);
        linkHost.setText(data.getHost());
        linkPath.setText(data.getPath());
        linkParams.setText(data.getQueryParameter("param"));


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
