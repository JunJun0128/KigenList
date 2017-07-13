package com.example.junekelectric.shoumikigenlist;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static android.R.attr.onClick;

public class FontSizeActivity extends AppCompatActivity {
    RadioGroup radio;
    SharedPreferences fontsize;

    TextView titleadd = (TextView)findViewById(R.id.MemoActivity.title);
    TextView dateadd = (TextView)findViewById(R.id.MemoActivity.date);
    TextView contentadd = (TextView)findViewById(R.id.MemoActivity.content);

    TextView titlelist = (TextView)findViewById(R.id.Card.title);
    TextView dayslist = (TextView)findViewById(R.id.Card.days);
    TextView contentlist = (TextView)findViewById(R.id.Card.content);
    TextView Daysleft = (TextView)findViewById(R.id.Card.howmanyDaysleft);
    TextView daysLeft = (TextView)findViewById(R.id.Card.howmanydaysLeft);
    TextView diff = (TextView)findViewById(R.id.Card.diff);

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