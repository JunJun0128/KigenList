package com.example.junekelectric.shoumikigenlist;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import static android.R.attr.onClick;

public class FontSizeActivity extends AppCompatActivity {
    RadioGroup radio;
    SharedPreferences fontsize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_font_size);

        radio = (RadioGroup) findViewById(R.id.radio);
    }

    public void save(View v) {
        //Preference内操作
        SharedPreferences.Editor editor = fontsize.edit();
        editor.putString("key_title", titleText);
        editor.putString("key_date", dateText);
        editor.putString("key_content", contentText);
        //editor.commit();
        editor.apply();
        finish();


        // チェックされているラジオボタンの ID を取得
        int id = radio.getCheckedRadioButtonId();
        // チェックされているラジオボタンオブジェクトを取得
        RadioButton radioButton = (RadioButton) findViewById(id);

        //0 = font10, 1 = font15, 2 = font 20.
        //何も選択されてない時は自動的に１５
        if (id == 0) {
            fontsize.

        } else if (id == 2) {


        } else {


        }


        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        super.onResume();
    }
}