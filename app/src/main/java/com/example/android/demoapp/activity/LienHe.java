package com.example.android.demoapp.activity;


import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.android.demoapp.R;

public class LienHe extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lien_he);

        Toolbar toolbar = findViewById(R.id.toolbar_lien_he);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Thông tin liên hệ");

        toolbar.setNavigationIcon(R.drawable.ic_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });
        String htmltext = "<h2 style=\"color: #2e6c80;\">Mọi thắc mắc xin vui l&ograve;ng li&ecirc;n hệ:</h2>\n" +
                "<p>&nbsp;</p>\n" +
                "<p><br /><strong>Email: <a href=\"mailto:kundenservice@giaohang.eu\">kundenservice@giaohang.eu</a></strong></p>\n" +
                "<p><strong>FB: <a href=\"https://www.facebook.com/shopify\">https://www.facebook.com/shopify</a></strong></p>\n" +
                "<p><strong>Hotline: +4917686239999</strong></p>";
        WebView webView = findViewById(R.id.wv_lien_he);
        webView.loadDataWithBaseURL(null,htmltext,"text/html","utf-8", null);

/*
        TextView tv = findViewById(R.id.tv_lien_he);
        tv.setText(R.string.thong_tin_lien_he);
*/


    }
}
