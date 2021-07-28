package com.bananaemperor.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class kamar_webview extends AppCompatActivity {
    WebView kamar_webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kamar_webview);
        kamar_webview = findViewById(R.id.kamar);
        kamar_webview.setWebViewClient(new WebViewClient());
        kamar_webview.loadUrl("https://kamarportal.mrgs.school.nz/index.php"); //Load the Url to kamar


    }
}