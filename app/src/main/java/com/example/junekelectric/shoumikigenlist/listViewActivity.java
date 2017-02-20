package com.example.junekelectric.shoumikigenlist;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class listViewActivity extends AppCompatActivity {

    TextView title;
    TextView date;
    TextView content;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item);

        title = (TextView)findViewById(R.id.title);
        date = (TextView)findViewById(R.id.date);
        content = (TextView)findViewById(R.id.content);

        pref = getSharedPreferences("pref_memo", MODE_PRIVATE);

        title.setText(pref.getString("key_title", ""));
        date.setText(pref.getString("key_date", ""));
        content.setText(pref.getString("key_content",""));
    }
}
