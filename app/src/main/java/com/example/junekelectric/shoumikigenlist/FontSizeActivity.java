package com.example.junekelectric.shoumikigenlist;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static android.R.attr.onClick;
import static com.example.junekelectric.shoumikigenlist.R.id.contentitem;
import static com.example.junekelectric.shoumikigenlist.R.id.contentwrite;
import static com.example.junekelectric.shoumikigenlist.R.id.dateitem;
import static com.example.junekelectric.shoumikigenlist.R.id.datewrite;
import static com.example.junekelectric.shoumikigenlist.R.id.howmanyDaysleft;
import static com.example.junekelectric.shoumikigenlist.R.id.howmanydaysLeft;
import static com.example.junekelectric.shoumikigenlist.R.id.titleitem;
import static com.example.junekelectric.shoumikigenlist.R.id.titlewrite;

import static com.example.junekelectric.shoumikigenlist.R.layout.activity_memo;
import static com.example.junekelectric.shoumikigenlist.R.layout.item;

public class FontSizeActivity extends AppCompatActivity {
    RadioGroup radio;
    SharedPreferences fontsize;

    //引用の仕方わからん。

    EditText titleadd = (TextView)activity_memo.findViewById(titlewrite);
    EditText titleadd;
    TextView dateadd = (TextView)activity_memo.findViewById(datewrite);
    EditText contentadd = (TextView)activity_memo.findViewById(contentwrite);

    TextView titlelist = (TextView)item.findViewById(titleitem);
    TextView dayslist = (TextView)item.findViewById(dateitem);
    TextView contentlist = (TextView)item.findViewById(contentitem);
    TextView Daysleft = (TextView)item.findViewById(howmanyDaysleft);
    TextView daysLeft = (TextView)item.findViewById(howmanydaysLeft);
    TextView diff = (TextView)item.findViewById(diff);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_font_size);

        radio = (RadioGroup) findViewById(R.id.radio);
        radio.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        // 一回選択するたびにtoast型の通知が来る。
        if (0 == checkedId) {
            Toast.makeText(FontSizeActivity.this,
                    "Font10 is selected",
                    Toast.LENGTH_SHORT).show();
        } else if (2 == checkedId){
            Toast.makeText(FontSizeActivity.this,
                    //((RadioButton)findViewById(checkedId)).getText()
                    "Font20 is selected",
                    Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(FontSizeActivity.this,
                    //((RadioButton)findViewById(checkedId)).getText()
                    "Font15 is selected",
                    Toast.LENGTH_SHORT).show();
        }
    }


    public void save(View v) {
        //Preference内操作
        SharedPreferences.Editor editor = fontsize.edit();
        editor.putString("key_font10", 0);
        editor.putString("key_font15", 1);
        editor.putString("key_font20", 2);
        //editor.commit();
        editor.apply();
        finish();

        // チェックされているラジオボタンの ID を取得
        int id = radio.getCheckedRadioButtonId();
        // チェックされているラジオボタンオブジェクトを取得
        RadioButton radioButton = (RadioButton) findViewById(id);

        //何も選択されてない時は自動的に15
        if (id == 0) {
            titleadd.setTextSize(10);
            dateadd.setTextSize(10);
            contentadd.setTextSize(10);
            titlelist.setTextSize(10);
            dayslist.setTextSize(10);
            contentlist.setTextSize(10);
            daysLeft.setTextSize(10);
            Daysleft.setTextSize(10);
            diff.setTextSize(10);
        } else if (id == 2) {
            titleadd.setTextSize(20);
            dateadd.setTextSize(20);
            contentadd.setTextSize(20);
            titlelist.setTextSize(20);
            dayslist.setTextSize(20);
            contentlist.setTextSize(20);
            daysLeft.setTextSize(20);
            Daysleft.setTextSize(20);
            diff.setTextSize(20);
        } else {
            titleadd.setTextSize(15);
            dateadd.setTextSize(15);
            contentadd.setTextSize(15);
            titlelist.setTextSize(15);
            dayslist.setTextSize(15);
            contentlist.setTextSize(15);
            daysLeft.setTextSize(15);
            Daysleft.setTextSize(15);
            diff.setTextSize(15);
        }

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        super.onResume();
    }
}