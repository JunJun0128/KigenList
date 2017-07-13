package com.example.junekelectric.shoumikigenlist;

import android.app.ListActivity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import static com.example.junekelectric.shoumikigenlist.R.layout.activity_main;
import static com.example.junekelectric.shoumikigenlist.R.layout.activity_memo;

public class DesignActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design);
    }

    //imagebuttonのOnClick idを押すと、背景色および文字色が変わること。

    public void bgblack (View v){

        MainActivity.setBackgroundColor(R.id.colors.Black);
        activity_main(setBackgroundColor(R.id.colors.Black));
        activity_main.setBackgroundTint (R.id.colors.Black));
        MemoActivity.setBackgroundColor(R.id.colors.Black);
        MemoActivity.setTextColor (R.id.colors.Orange);
        ListActivity.setBackgroundColor(R.id.colors.Black);
        ListActivity.setTextColor (R.id.colors.Orange);
    }

    public void bgwhite (View v){
        MainActivity.setBackgroundColor(R.id.colors.White);
        MemoActivity.setBackgroundColor(R.id.colors.White);
        MemoActivity.setTextColor (R.id.colors.Blue);
        ListActivity.setBackgroundColor(R.id.colors.White);
        ListActivity.setTextColor (R.id.colors.Blue);
    }


    public void bglightblue (View v){
        MainActivity.setBackgroundColor(R.id.colors.LightBlue);
        MemoActivity.setBackgroundColor(R.id.colors.LIghtBlue);
        MemoActivity.setTextColor (R.id.colors.Purple);
        ListActivity.setBackgroundColor(R.id.colors.LightBlue);
        ListActivity.setTextColor (R.id.colors.Purple);
    }

    public void bgyellow (View v) {
        MainActivity.setBackgroundColor(R.id.colors.Yellow);
        MemoActivity.setBackgroundColor(R.id.colors.Yellow);
        MemoActivity.setTextColor (R.id.colors.Green);
        ListActivity.setBackgroundColor(R.id.colors.Yellow);
        ListActivity.setTextColor (R.id.colors.Green);
    }

    public void bgpink (View v){
        MainActivity.setBackgroundColor(R.id.colors.Pink);
        MemoActivity.setBackgroundColor(R.id.colors.Pink);
        MemoActivity.setTextColor (R.id.colors.LightGreen);
        ListActivity.setBackgroundColor(R.id.colors.LightGreen);
        ListActivity.setTextColor (R.id.colors.Pink);
    }

}
