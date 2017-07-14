package com.example.junekelectric.shoumikigenlist;

import android.app.ListActivity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import static com.example.junekelectric.shoumikigenlist.R.layout.activity_list;
import static com.example.junekelectric.shoumikigenlist.R.layout.activity_main;
import static com.example.junekelectric.shoumikigenlist.R.layout.activity_memo;

public class DesignActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design);
    }

    //imagebuttonのOnClick idを押すと、背景色および文字色が変わること。

    //Preference 1=(黒、オレンジ)　２＝（）

    public void bgblack (View v){
        activity_main.setBackgroundColor(R.id.colors.Black);
        activity_main(setBackgroundColor(R.id.colors.Black));
        activity_main.setBackgroundTint (R.id.colors.Black);
        activity_memo.setBackgroundColor(R.id.colors.Black);
        activity_memo.setTextColor (R.id.colors.Orange);
        activity_list.setBackgroundColor(R.id.colors.Black);
        activity_list.setTextColor (R.id.colors.Orange);
    }

    public void bgwhite (View v){
        activity_main.setBackgroundColor(R.id.colors.White);
        activity_memo.setBackgroundColor(R.id.colors.White);
        activity_memo.setTextColor (R.id.colors.Blue);
        activity_list.setBackgroundColor(R.id.colors.White);
        activity_list.setTextColor (R.id.colors.Blue);
    }


    public void bglightblue (View v){
        activity_main.setBackgroundColor(R.id.colors.LightBlue);
        activity_memo.setBackgroundColor(R.id.colors.LIghtBlue);
        activity_memo.setTextColor (R.id.colors.Purple);
        activity_list.setBackgroundColor(R.id.colors.LightBlue);
        activity_list.setTextColor (R.id.colors.Purple);
    }

    public void bgyellow (View v) {
        activity_main.setBackgroundColor(R.id.colors.Yellow);
        activity_memo.setBackgroundColor(R.id.colors.Yellow);
        activity_memo.setTextColor (R.id.colors.Green);
        activity_list.setBackgroundColor(R.id.colors.Yellow);
        activity_list.setTextColor (R.id.colors.Green);
    }

    public void bgpink (View v){
        activity_main.setBackgroundColor(R.id.colors.Pink);
        activity_memo.setBackgroundColor(R.id.colors.Pink);
        activity_memo.setTextColor (R.id.colors.LightGreen);
        activity_list.setBackgroundColor(R.id.colors.LightGreen);
        activity_list.setTextColor (R.id.colors.Pink);
    }

}
