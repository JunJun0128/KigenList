package com.example.junekelectric.shoumikigenlist;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class MemoActivity extends AppCompatActivity {

    EditText titleEditText;
    EditText dateEditText;
    EditText contentEditText;

    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);

        titleEditText =  (EditText)findViewById(R.id.title);
        dateEditText = (EditText) findViewById(R.id.date);
        contentEditText = (EditText) findViewById(R.id.content);

        pref = getSharedPreferences("pref_memo", MODE_PRIVATE);

        titleEditText.setText(pref.getString("key_title", ""));
        dateEditText.setText(pref.getString("key_date", ""));
        contentEditText.setText(pref.getString("key_content", ""));
    }

    public void save (View v){

        String titleText = titleEditText.getText().toString();
        String dateText = dateEditText.getText().toString();
        String contentText = contentEditText.getText().toString();

        if (titleText.isEmpty() && dateText.isEmpty() && contentText.isEmpty()) {
            Toast.makeText(this, R.string.msg_destruction, Toast.LENGTH_SHORT).show();
            return;
        }

        // 保存

//        OutputStream out = null;
//        PrintWriter writer = null;
//        try{
//            out = this.openFileOutput(mFileName, Context.MODE_PRIVATE);
//            writer = new PrintWriter(new OutputStreamWriter(out,"UTF-8"));
//            // タイトル書き込み
//            writer.print(titleText);
//            //日付書き込み
//            writer.print(dateText);
//            // 内容書き込み
//            writer.print(contentText);
//            writer.close();
//            out.close();
//        }catch(Exception e){
//            Toast.makeText(this, "File save error!", Toast.LENGTH_LONG).show();
//        }

        SharedPreferences.Editor editor = pref.edit();
        editor.putString("key_title", titleText);
        editor.putString("key_date", dateText);
        editor.putString("key_content", contentText);
        editor.commit();
        finish();

        Intent intent = new Intent(this, listActivity.class);
        startActivity(intent);
        super.onResume();


    }
}