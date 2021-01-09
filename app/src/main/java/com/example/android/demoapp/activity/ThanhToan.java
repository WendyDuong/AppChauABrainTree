package com.example.android.demoapp.activity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.android.demoapp.R;

public class ThanhToan extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanh_toan);
        Toolbar toolbar = findViewById(R.id.toolbar_thanh_toan);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Hình thức thanh toán");
        toolbar.setNavigationIcon(R.drawable.ic_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });
        String htmltext = "<p>Qu&yacute; kh&aacute;ch tiến h&agrave;ng gửi email đặt h&agrave;ng đến địa chỉ: <strong><a href=\"mailto:kundenservice@giaohang.eu\">kundenservice@giaohang.eu </a></strong></p>\n" +
                "<p>Giaohang.eu sẽ li&ecirc;n lạc với qu&yacute; kh&aacute;ch để ho&agrave;n tất qu&aacute; tr&igrave;nh đặt h&agrave;ng.</p>\n" +
                "<p>Để thanh to&aacute;n qu&yacute; kh&aacute;ch vui l&ograve;ng chuyển khoản tới:</p>\n" +
                "<p><strong>Số T&agrave;i Khoản: 0541000321788 </strong></p>\n" +
                "<p><strong>T&ecirc;n T&agrave;i Khoản: Dương Thị Ng&aacute;t </strong></p>\n" +
                "<p><strong>Chi Nh&aacute;nh: Vietcombank Long Bi&ecirc;n </strong></p>\n" +
                "<p>Khi chuyển khoản qu&yacute; kh&aacute;ch vui l&ograve;ng ghi th&ecirc;m th&ocirc;ng tin v&agrave;o phần nội dung chuyển tiền của ng&acirc;n h&agrave;ng như sau:</p>\n" +
                "<p><strong><em>T&ecirc;n người gửi-Số điện thoại hoặc email. </em></strong></p>\n" +
                "<p>VD: Dương Minh Hiếu&ndash;minhhieu@gmail.com/0968686868</p>\n" +
                "<p>Sau khi nhận được tiền, c&ocirc;ng ty sẽ tiến h&agrave;nh đặt h&agrave;ng cho qu&yacute; kh&aacute;ch.</p>";
        WebView webView = findViewById(R.id.wv_thanh_toan);
        webView.loadDataWithBaseURL(null,htmltext,"text/html","utf-8", null);
/*
        TextView tv = findViewById(R.id.tv_thanh_toan);
        tv.setText(R.string.thong_tin_thanh_toan);
*/

    }
}