package com.example.geeknew.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.geeknew.R;

public class VShowActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private WebView web;
    private boolean isLike;
    private MenuItem item;
    private static final String TAG = "VShowActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vshow2);
        initView();
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        web = (WebView) findViewById(R.id.web);
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        String title = intent.getStringExtra("title");
        Log.e(TAG, "initView: "+title );
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.fanhui);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        web.getSettings().setJavaScriptEnabled(true);
        web.setWebViewClient(new WebViewClient());
        web.loadUrl(url);
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tool_option,menu);
        item=menu.findItem(R.id.like);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.like:
                if (isLike){
                    isLike=false;
                    item.setIcon(R.mipmap.ic_toolbar_like_n);
                }else {
                    isLike=true;
                    item.setIcon(R.mipmap.ic_toolbar_like_p);
                }
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
