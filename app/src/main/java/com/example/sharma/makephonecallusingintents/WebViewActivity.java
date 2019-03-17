package com.example.sharma.makephonecallusingintents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class WebViewActivity extends AppCompatActivity {
    EditText edt_url;
    Button btn_open;
    WebView webView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        init();
    }

    private void init() {
        edt_url=findViewById(R.id.edt_url);
        btn_open=findViewById(R.id.btn_open);
        webView=findViewById(R.id.webView);
        btn_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url=edt_url.getText().toString();

                webView.loadUrl(url);
            }
        });



    }
}
