package com.example.junekelectric.shoumikigenlist;

import android.app.DatePickerDialog;
import android.app.ListActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.DialogFragment;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.Arrays;
import java.util.List;


public class MemoActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    EditText titleEditText;
    EditText contentEditText;
    TextView dateTextView;
    SharedPreferences settingss;
    String mtitle;
    String mcontent;
    String mdeadline;
    long mdiffday;
    List<Card> foodList;
    //String subject[];
    List<String> readList;
    String helper[];
    List<String> readHelperList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);

        //定義とそれぞれの入力画面の機能
        titleEditText = (EditText) findViewById(R.id.titlewrite);
        titleEditText.setInputType(InputType.TYPE_CLASS_TEXT);

        dateTextView = (TextView) findViewById(R.id.datewrite);
        dateTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datepick();
            }
        });

        contentEditText = (EditText) findViewById(R.id.contentwrite);
        titleEditText.setInputType(InputType.TYPE_CLASS_TEXT);
        foodList = new ArrayList<Card>();



        SharedPreferences settingss = getSharedPreferences("ShoumiKigen", MODE_PRIVATE);
        int fontsize = settingss.getInt("keyfont", 15);

        // TODO　settings if ってなってた
        if (fontsize == 10) {
            titleEditText.setTextSize(fontsize);
            dateTextView.setTextSize(fontsize);
            contentEditText.setTextSize(fontsize);

            //SharedPrefrencesについて定義
//        pref = getSharedPreferences("pref_memo", MODE_PRIVATE);
//        titleEditText.setText(pref.getString("key_title", ""));
//        dateTextView.setText(pref.getString("key_date", ""));
//        contentEditText.setText(pref.getString("key_content", ""));

            //ArrayListについて定義
            foodList = new ArrayList<>();
            readFile();

            readList = new ArrayList<String>();
            readHelperList = new ArrayList<String>();
            readSubjectFile();
            readHelperFile();
            //firststarting();
        }
        // TODO 下に括弧が足りなかった！
    }

    // TODO 下の@Overrideは要らないよ！
    //@Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        dateTextView.setText(String.valueOf(year) + "/ " + String.valueOf(monthOfYear + 1) + "/ " + String.valueOf(dayOfMonth));
        mdeadline = String.valueOf(year) + "/ " + String.valueOf(monthOfYear + 1) + "/ " + String.valueOf(dayOfMonth);

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, monthOfYear, dayOfMonth);
        long deadlineMillis = calendar.getTimeInMillis();
        long currentTimeMillis = System.currentTimeMillis();
        long diff = deadlineMillis - currentTimeMillis;
        diff = diff / 1000;
        diff = diff / 60;
        diff = diff / 60;
        diff = diff / 24;
        mdiffday = diff;
    }


    public boolean readFile() {
        try {
            FileInputStream fis = openFileInput("lCard");
            ObjectInputStream ois = new ObjectInputStream(fis);
            foodList = (ArrayList<Card>) ois.readObject();
            ois.close();
            fis.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (StreamCorruptedException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean readSubjectFile() {
        try {
            FileInputStream fis = openFileInput("savesubject");
            ObjectInputStream ois = new ObjectInputStream(fis);
            readList = (List<String>) ois.readObject();
            ois.close();
            fis.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (StreamCorruptedException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean readHelperFile() {
        try {
            FileInputStream fis = openFileInput("savehelper");
            ObjectInputStream ois = new ObjectInputStream(fis);
            readHelperList = (List<String>) ois.readObject();
            ois.close();
            fis.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (StreamCorruptedException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

//    public boolean firststarting() {
//        String[] firstsubject = {"古典", "現代文", "数I", "数Ⅱ", "英語", "英語表現",
//                "コミュ英語", "物理", "化学", "生物", "地学", "地理", "世界史", "日本史"};
//        if (readList.size() == 0) {
//            for (int i = 0; i < 14; i++) {
//                readList.add(firstsubject[i]);
//            }
//        }
//        String[] firsthelper = {"P", "No", "～P", "～No", "・"};
//        if (readHelperList.size() == 0) {
//            for (int i = 0; i < 5; i++) {
//                readHelperList.add(firsthelper[i]);
//            }
//        }
//        return true;
//    }

    public void save(View v) {
        String titleText = titleEditText.getText().toString();
        String dateText = dateTextView.getText().toString();
        String contentText = contentEditText.getText().toString();
        String mcontent = String.valueOf(contentEditText.getText());
        String mtitle = String.valueOf(titleEditText.getText());
        Card addCard = new Card(mtitle, mdiffday, mcontent);

     //216がnull pointer exception
        foodList.add(addCard);
        if (titleText.isEmpty() && dateText.isEmpty() && contentText.isEmpty()) {
            Toast.makeText(this, R.string.msg_destruction, Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            FileOutputStream fos = openFileOutput("lCard", MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(foodList);
            oos.close();
            fos.close();
        } catch (Exception e) {

        }
        Intent intent = new Intent(MemoActivity.this, listActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);

        //savesubject 関係ない
//        try {
//            FileOutputStream fos = openFileOutput("savesubject", MODE_PRIVATE);
//            ObjectOutputStream oos = new ObjectOutputStream(fos);
//            oos.writeObject(readList);
//            oos.close();
//            fos.close();
//        } catch (Exception e) {
//        }

        try {
            FileOutputStream fos = openFileOutput("savehelper", MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(readHelperList);
            oos.close();
            fos.close();
        } catch (Exception e) {
        }

//        pref　多分使わない
//        SharedPreferences.Editor editor = pref.edit();
//        editor.putString("key_title", titleText);
//        editor.putString("key_date", dateText);
//        editor.putString("key_content", contentText);
//        //editor.commit();
//        editor.apply();
//        finish();

//        Intent intent = new Intent(this, listActivity.class);
//        startActivity(intent);
//        super.onResume();
    }


    //これは教科についてなので関係ないかも　alertDialog.setItemsからは本当にいらない　
//    public boolean add() {
//        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MemoActivity.this);
//        subject = readList.toArray(new String[readList.size()]);
//        alertDialog.setItems(subject, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                sTextView.setText(subject[i]);
//            }
//        });
//        alertDialog.create().show();
//        return true;
//    }

    public boolean datepick() {
        DialogFragment newFragment = new DatePickFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
        return true;
    }

    //エスカ　imageButtonの操作→関係ない
//    public void helper(View v) {
//        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
//        helper = readHelperList.toArray(new String[readHelperList.size()]);
//        alertDialog.setItems(helper, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                cEditText.setText(cEditText.getText() + helper[i]);
//                cEditText.setSelection(cEditText.getText().length());
//            }
//        });
//        alertDialog.create().show();
//    }

}