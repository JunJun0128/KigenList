package com.example.junekelectric.shoumikigenlist;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import static android.content.Context.MODE_PRIVATE;

public class listViewActivity extends AppCompatActivity{

    TextView titleTextView;
    TextView dateTextView;
    TextView contentTextView;
    public String title;
    public String date;
    public String content;
    SharedPreferences pref;

    //public String

    public listViewActivity(String title, String date, String content) {
        this.title = title;
        this.date = date;
        this.content = content;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item);

        titleTextView = (TextView)findViewById(R.id.title);
        dateTextView = (TextView)findViewById(R.id.date);
        contentTextView = (TextView)findViewById(R.id.content);

        pref = getSharedPreferences("pref_memo", MODE_PRIVATE);

        titleTextView.setText(pref.getString("key_title", ""));
        dateTextView.setText(pref.getString("key_date", ""));
        contentTextView.setText(pref.getString("key_content",""));
    }
}
