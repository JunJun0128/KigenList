package com.example.junekelectric.shoumikigenlist;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.io.Serializable;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by junekelectric on 2017/02/24.
 */

//public class listViewActivity extends AppCompatActivity{
public class Card implements Serializable {
//    TextView titleTextView;
//    TextView dateTextView;
//    TextView contentTextView;
    //public String date;
    public String title;
    public String content;
    public long diffday;
    SharedPreferences pref;

    public Card(String title, long diffday, String content) {
        this.title = title;
        this.content = content;
        this.diffday = diffday;
        //this.date = date;
    }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public long getDiffday() {
            return diffday;
        }

        public void setDiffday(long diffday) {
            this.diffday = diffday;
        }



//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.item);
//
//        titleTextView = (TextView)findViewById(R.id.title);
//        dateTextView = (TextView)findViewById(R.id.date);
//        contentTextView = (TextView)findViewById(R.id.content);
//
//        pref = getSharedPreferences("pref_memo", MODE_PRIVATE);
//
//        titleTextView.setText(pref.getString("key_title", ""));
//        dateTextView.setText(pref.getString("key_date", ""));
//        contentTextView.setText(pref.getString("key_content",""));
//    }
}
