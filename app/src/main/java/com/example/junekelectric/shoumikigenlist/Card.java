package com.example.junekelectric.shoumikigenlist;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import java.io.Serializable;

import static android.content.Context.MODE_PRIVATE;
import static com.example.junekelectric.shoumikigenlist.R.id.dateitem;
import static com.example.junekelectric.shoumikigenlist.R.id.titleitem;
import static com.example.junekelectric.shoumikigenlist.R.id.contentitem;
import static com.example.junekelectric.shoumikigenlist.R.id.howmanyDaysleft;
import static com.example.junekelectric.shoumikigenlist.R.id.howmanydaysLeft;
import static com.example.junekelectric.shoumikigenlist.R.id.diff;

/**
 * Created by junekelectric on 2017/02/24.
 */

public class Card implements Serializable {

    //public String date;
    public String title;
    public String content;
    public long diffday;
    SharedPreferences settingss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item);

//        titleitem = (TextView)findViewById(titleitem);
//        dateitem = (TextView)findViewById(dateitem);
//        contentitem = (TextView)findViewById(contentitem);
//        howmanyDaysleft = (TextView)findViewById(howmanyDaysleft);
//        howmanydaysLeft = (TextView)findViewById(howmanydaysLeft);
//        diff = (TextView)findViewById(diff);

        settingss if( == 0){
            titleitem.setTextSize(10);
            dateitem.setTextSize(10);
            contentitem.setTextSize(10);
            howmanyDaysleft.setTextSize(10);
            howmanydaysLeft.setTextSize(10);
            diff.setTextSize(10);
        }else if( ==2){
            titleitem.setTextSize(20);
            dateitem.setTextSize(20);
            contentitem.setTextSize(20);
            howmanyDaysleft.setTextSize(20);
            howmanydaysLeft.setTextSize(20);
            diff.setTextSize(20);
        }else if( ==1){
            titleitem.setTextSize(15);
            dateitem.setTextSize(15);
            contentitem.setTextSize(15);
            howmanyDaysleft.setTextSize(15);
            howmanydaysLeft.setTextSize(15);
            diff.setTextSize(15);
        }
    }

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
}
