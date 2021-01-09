package com.example.android.demoapp.activity;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.android.demoapp.R;

public class VanChuyen extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giao_hang);
        Toolbar toolbar = findViewById(R.id.toolbar_giao_hang);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Thông tin vận chuyển");
        WebView webView = findViewById(R.id.wv_vanchuyen);

        String htmltext = "<h2 style=\"color: #2e6c80;\">Đối t&aacute;c vận chuyển: DPD</h2>\n" +
                "<p><strong>DPD Standard:</strong> Cho đồ kh&ocirc;<br /><strong>DPD Express:</strong> Cho rau củ, thịt tươi v&agrave; đồ đ&ocirc;ng lạnh</p>\n" +
                "<p>&nbsp;</p>\n" +
                "<h2 style=\"color: #2e6c80;\">Bảng gi&aacute;:</h2>\n" +
                "<h3 style=\"color: #2e6c80;\">Trong nước Đức</h3>\n" +
                "<table style=\"border-collapse: collapse; width: 99.1104%; height: 282px;\" border=\"1\">\n" +
                "<tbody>\n" +
                "<tr style=\"height: 52px;\">\n" +
                "<td style=\"width: 23.3428%; height: 52px; text-align: center;\"><strong>Vận chuyển thường</strong></td>\n" +
                "<td style=\"width: 26.88%; height: 52px; text-align: center;\">\n" +
                "<div>0kg&ndash;30kg</div>\n" +
                "</td>\n" +
                "<td style=\"width: 49.6045%; height: 52px; text-align: center;\">&euro; 5,9&nbsp;</td>\n" +
                "</tr>\n" +
                "<tr style=\"height: 34px;\">\n" +
                "<td style=\"width: 23.3428%; height: 34px; text-align: center;\">\n" +
                "<div>&nbsp;</div>\n" +
                "2 Pakete</td>\n" +
                "<td style=\"width: 26.88%; height: 34px; text-align: center;\">\n" +
                "<div>&nbsp;</div>\n" +
                "31kg&ndash;60kg</td>\n" +
                "<td style=\"width: 49.6045%; height: 34px; text-align: center;\">\n" +
                "<div>&nbsp;</div>\n" +
                "&euro;11.40</td>\n" +
                "</tr>\n" +
                "<tr style=\"height: 34px;\">\n" +
                "<td style=\"width: 23.3428%; height: 34px; text-align: center;\">3 Pakete</td>\n" +
                "<td style=\"width: 26.88%; height: 34px; text-align: center;\">\n" +
                "<div>&nbsp;</div>\n" +
                "61kg&ndash;90kg</td>\n" +
                "<td style=\"width: 49.6045%; height: 34px; text-align: center;\">\n" +
                "<div>&nbsp;</div>\n" +
                "&euro;16.90</td>\n" +
                "</tr>\n" +
                "<tr style=\"height: 34px;\">\n" +
                "<td style=\"width: 23.3428%; height: 34px; text-align: center;\">4 Pakete</td>\n" +
                "<td style=\"width: 26.88%; height: 34px; text-align: center;\">\n" +
                "<div>91kg&ndash;120kg</div>\n" +
                "</td>\n" +
                "<td style=\"width: 49.6045%; height: 34px; text-align: center;\">\n" +
                "<div>&nbsp;</div>\n" +
                "&euro;22.40</td>\n" +
                "</tr>\n" +
                "<tr style=\"height: 34px;\">\n" +
                "<td style=\"width: 23.3428%; height: 34px; text-align: center;\">5 Pakete</td>\n" +
                "<td style=\"width: 26.88%; height: 34px; text-align: center;\">\n" +
                "<div>&nbsp;</div>\n" +
                "121kg&ndash;150kg</td>\n" +
                "<td style=\"width: 49.6045%; height: 34px; text-align: center;\">\n" +
                "<div>&nbsp;</div>\n" +
                "&euro;27.90</td>\n" +
                "</tr>\n" +
                "<tr style=\"height: 34px;\">\n" +
                "<td style=\"width: 23.3428%; height: 34px; text-align: center;\">6 Pakete</td>\n" +
                "<td style=\"width: 26.88%; height: 34px; text-align: center;\">\n" +
                "<div>&nbsp;</div>\n" +
                "151kg&ndash;180kg</td>\n" +
                "<td style=\"width: 49.6045%; height: 34px; text-align: center;\">\n" +
                "<div>&nbsp;</div>\n" +
                "&euro;33.40</td>\n" +
                "</tr>\n" +
                "<tr style=\"height: 34px;\">\n" +
                "<td style=\"width: 23.3428%; height: 34px; text-align: center;\">7 Pakete</td>\n" +
                "<td style=\"width: 26.88%; height: 34px; text-align: center;\">ab 180kg</td>\n" +
                "<td style=\"width: 49.6045%; height: 34px; text-align: center;\">Vui l&ograve;ng li&ecirc;n hệ để nhận b&aacute;o gi&aacute;!</td>\n" +
                "</tr>\n" +
                "</tbody>\n" +
                "</table>\n" +
                "<h3 style=\"color: #2e6c80;\">&nbsp;</h3>\n" +
                "<table style=\"border-collapse: collapse; width: 99.4662%; height: 247px;\" border=\"1\">\n" +
                "<tbody>\n" +
                "<tr style=\"height: 62px;\">\n" +
                "<td style=\"width: 22.5979%; height: 62px; text-align: center;\">\n" +
                "<p><strong>Phụ ph&iacute; vận chuyển si&ecirc;u tốc</strong></p>\n" +
                "</td>\n" +
                "<td style=\"width: 27.7189%; height: 62px; text-align: center;\">\n" +
                "<div>0kg&ndash;30kg</div>\n" +
                "</td>\n" +
                "<td style=\"width: 49.5053%; height: 62px; text-align: center;\">&nbsp;\n" +
                "<div>&euro; 7,9 (Chưa bao gồm ph&iacute; vận chuyển thường)</div>\n" +
                "</td>\n" +
                "</tr>\n" +
                "<tr style=\"height: 34px;\">\n" +
                "<td style=\"width: 22.5979%; height: 34px; text-align: center;\">\n" +
                "<div>&nbsp;</div>\n" +
                "2 Pakete</td>\n" +
                "<td style=\"width: 27.7189%; height: 34px; text-align: center;\">\n" +
                "<div>&nbsp;</div>\n" +
                "31kg&ndash;60kg</td>\n" +
                "<td style=\"width: 49.5053%; height: 34px; text-align: center;\">\n" +
                "<div>&nbsp;</div>\n" +
                "&euro;15.40&nbsp;</td>\n" +
                "</tr>\n" +
                "<tr style=\"height: 34px;\">\n" +
                "<td style=\"width: 22.5979%; height: 34px; text-align: center;\">3 Pakete</td>\n" +
                "<td style=\"width: 27.7189%; height: 34px; text-align: center;\">\n" +
                "<div>&nbsp;</div>\n" +
                "61kg&ndash;90kg</td>\n" +
                "<td style=\"width: 49.5053%; height: 34px; text-align: center;\">\n" +
                "<div>&nbsp;</div>\n" +
                "&euro;22.90</td>\n" +
                "</tr>\n" +
                "<tr style=\"height: 10px;\">\n" +
                "<td style=\"width: 22.5979%; height: 10px; text-align: center;\">4 Pakete</td>\n" +
                "<td style=\"width: 27.7189%; height: 10px; text-align: center;\">\n" +
                "<p>91kg&ndash;120kg&nbsp;</p>\n" +
                "</td>\n" +
                "<td style=\"width: 49.5053%; height: 10px; text-align: center;\">\n" +
                "<div>&euro;30.40</div>\n" +
                "</td>\n" +
                "</tr>\n" +
                "<tr style=\"height: 34px;\">\n" +
                "<td style=\"width: 22.5979%; height: 34px; text-align: center;\">5 Pakete</td>\n" +
                "<td style=\"width: 27.7189%; height: 34px; text-align: center;\">\n" +
                "<div>&nbsp;</div>\n" +
                "121kg&ndash;150kg</td>\n" +
                "<td style=\"width: 49.5053%; height: 34px; text-align: center;\">\n" +
                "<div>&nbsp;</div>\n" +
                "&euro;37.90</td>\n" +
                "</tr>\n" +
                "<tr style=\"height: 34px;\">\n" +
                "<td style=\"width: 22.5979%; height: 34px; text-align: center;\">6 Pakete</td>\n" +
                "<td style=\"width: 27.7189%; height: 34px; text-align: center;\">\n" +
                "<div>&nbsp;</div>\n" +
                "151kg&ndash;180kg</td>\n" +
                "<td style=\"width: 49.5053%; height: 34px; text-align: center;\">\n" +
                "<div>&nbsp;</div>\n" +
                "&euro;45.40</td>\n" +
                "</tr>\n" +
                "<tr style=\"height: 39px;\">\n" +
                "<td style=\"width: 22.5979%; height: 39px; text-align: center;\">7 Pakete</td>\n" +
                "<td style=\"width: 27.7189%; height: 39px; text-align: center;\">ab 180kg</td>\n" +
                "<td style=\"width: 49.5053%; height: 39px; text-align: center;\">Vui l&ograve;ng li&ecirc;n hệ để nhận b&aacute;o gi&aacute;!</td>\n" +
                "</tr>\n" +
                "</tbody>\n" +
                "</table>\n" +
                "<h3 style=\"color: #2e6c80;\">&nbsp;</h3>\n" +
                "<p>&nbsp;</p>";
        toolbar.setNavigationIcon(R.drawable.ic_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });
        //TextView tv = findViewById(R.id.tv_giao_hang);
        //tv.setText(R.string.thong_tin_giao_hang);

        webView.loadDataWithBaseURL(null,htmltext,"text/html","utf-8", null);

    }

}