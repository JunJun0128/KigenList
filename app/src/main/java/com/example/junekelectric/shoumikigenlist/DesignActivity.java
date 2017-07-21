package com.example.junekelectric.shoumikigenlist;

import android.app.ListActivity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import static com.example.junekelectric.shoumikigenlist.R.color.Black;
import static com.example.junekelectric.shoumikigenlist.R.color.Blue;
import static com.example.junekelectric.shoumikigenlist.R.color.Green;
import static com.example.junekelectric.shoumikigenlist.R.color.LightBlue;
import static com.example.junekelectric.shoumikigenlist.R.color.LightGreen;
import static com.example.junekelectric.shoumikigenlist.R.color.Orange;
import static com.example.junekelectric.shoumikigenlist.R.color.Pink;
import static com.example.junekelectric.shoumikigenlist.R.color.Purple;
import static com.example.junekelectric.shoumikigenlist.R.color.White;
import static com.example.junekelectric.shoumikigenlist.R.color.Yellow;
import static com.example.junekelectric.shoumikigenlist.R.layout.activity_list;
import static com.example.junekelectric.shoumikigenlist.R.layout.activity_main;
import static com.example.junekelectric.shoumikigenlist.R.layout.activity_memo;


public class DesignActivity extends AppCompatActivity {

    //カラークラスの引用
//    public colors getValues(colors) {
//        return Black;
//        return Orange;
//        return White;
//        return Blue;
//        return LightBlue;
//        return Purple;
//        return Yellow;
//        return Green;
//        return Pink;
//        return LightGreen;
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design);
    }

    //imagebuttonのOnClick idを押すと、背景色および文字色が変わること。

    public void bgblack (View v){
        activity_main.setBackgroundColor(Black);
        activity_main(setBackgroundColor(Black));
        activity_memo.setBackgroundColor(Black);
        activity_memo.setTextColor (Orange);
        activity_list.setBackgroundColor(Black);
        activity_list.setTextColor (Orange);
    }

    public void bgwhite (View v){
        activity_main.setBackgroundColor(White);
        activity_memo.setBackgroundColor(White);
        activity_memo.setTextColor (Blue);
        activity_list.setBackgroundColor(White);
        activity_list.setTextColor (Blue);
    }


    public void bglightblue (View v){
        activity_main.setBackgroundColor(LightBlue);
        activity_memo.setBackgroundColor(LightBlue);
        activity_memo.setTextColor (Purple);
        activity_list.setBackgroundColor(LightBlue);
        activity_list.setTextColor (Purple);
    }

    public void bgyellow (View v) {
        activity_main.setBackgroundColor(Yellow);
        activity_memo.setBackgroundColor(Yellow);
        activity_memo.setTextColor (Green);
        activity_list.setBackgroundColor(Yellow);
        activity_list.setTextColor (Green);
    }

    public void bgpink (View v){
        activity_main.setBackgroundColor(Pink);
        activity_memo.setBackgroundColor(Pink);
        activity_memo.setTextColor(LightGreen);
        activity_list.setBackgroundColor(LightGreen);
        activity_list.setTextColor (Pink);
    }

}
