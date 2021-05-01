package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivityWTClass extends AppCompatActivity {

    WebView webViewWTClass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_w_t_class);

        webViewWTClass = findViewById(R.id.webViewWTClass);

        webViewWTClass.getSettings().setJavaScriptEnabled(true);

        webViewWTClass.setWebViewClient(new WebViewClient());

        webViewWTClass.loadUrl("https://wtclass.wtamu.edu/");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webViewWTClass.canGoBack()) {
            webViewWTClass.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}