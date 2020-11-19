package com.example.android.demoapp.activity;

import android.os.Bundle;
import android.view.View;
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
        TextView tv = findViewById(R.id.tv_thanh_toan);
        tv.setText(R.string.thong_tin_thanh_toan);

    }
}