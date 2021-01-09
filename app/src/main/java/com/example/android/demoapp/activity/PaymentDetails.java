package com.example.android.demoapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.demoapp.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class PaymentDetails extends AppCompatActivity {

    TextView txtId, txtAmount, txtStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_details);

        txtId = findViewById(R.id.txtId);
        txtAmount = findViewById(R.id.txtAmount);
        txtStatus = findViewById(R.id.txtStatus);

        //Get Intent
        final Intent intent =  getIntent();

        try {
            JSONObject jsonObject = new JSONObject(Objects.requireNonNull(intent.getStringExtra("PaymentDetails")));
            showDetails(jsonObject.getJSONObject("response"), intent.getStringExtra("PaymentAmount"));

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    private void showDetails(JSONObject response, String paymentAmount) {
        try {
            txtId.setText("Mã: " + response.getString("id"));
            txtStatus.setText("Thanh toán thành công: " + response.getString("state"));
            txtAmount.setText("Đã chuyển tiền: " + "€" + paymentAmount);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void BackToHome(View view) {
        Intent IntentBackToHomeSite = new Intent(PaymentDetails.this, MainActivity.class);
        startActivity(IntentBackToHomeSite);

    }
}