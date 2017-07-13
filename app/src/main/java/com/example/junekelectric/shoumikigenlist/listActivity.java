package com.example.junekelectric.shoumikigenlist;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;

import android.support.design.widget.FloatingActionButton;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.List;
import android.app.AlertDialog;
import static com.example.junekelectric.shoumikigenlist.R.id.title;

public class listActivity extends AppCompatActivity {
    ListView list;
    //ListView mListView;
    foodAdapter mFoodAdapter;
    ArrayList<Card> foodList;
    List<Card> readFoodList;
    List<Card> saveList;
    Card addCard;
    //SharedPreferences pref;

    // ListViewに表示する食べ物（仮、zackさんより）
    //    public static final String[] food = {
    //           "魚", "牛", "七面鳥"
    //    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        //floatingactionbutton
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        ImageButton fab = (ImageButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                save();
            }
        });

        ImageButton DeleteButton = (ImageButton)findViewById(R.id.DeleteButton);
        DeleteButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                //削除処理
                //Snackbarで通知
                Snackbar.make(v, "削除しました", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        readFoodList = new ArrayList<Card>();
        readFile();

        foodList = new ArrayList<Card>();

        //prefについて
        //pref = getSharedPreferences("pref_memo", MODE_PRIVATE);
        //foodList.add(new Card(getString("key_title")), getString("key_date"), getString("key_content"))));
        //foodList.add(new Card(getString(R.id.titleTextView)), getString(dateTextView), getString(contentTextView))));
        //foodList.add(new Card(pref.getString("key_title", ""), pref.getString("key_date", ""), pref.getString("key_content","")));

        mFoodAdapter = new foodAdapter(this, R.layout.item, readFoodList);
        list = (ListView) findViewById(R.id.list);
        list.setAdapter(mFoodAdapter);
        //AlertDialog
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(final AdapterView<?> adapterView, View view, final int i, long l) {

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(listActivity.this);
                alertDialog.setMessage("選択した項目を削除しますか？")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int position) {
                                Card delete = (Card) mFoodAdapter.getItem(i);
                                mFoodAdapter.remove(delete);
                                readFoodList.remove(delete);
                            }
                        })
                        .setNegativeButton("キャンセル", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                alertDialog.create().show();
            }

            //////:::::エスカと同じく、後◯日　とか入れるから、item.xmlに色々追加する
            // Homework Comparator ＝カウントダウンの機能だと思うので、、
            //Diffdayのような感じの機能です。　id: diff
        });

        //ダブることになるからいらないかも
//        // Adapterの作成
//        foodAdapter adapter = new foodAdapter(this, R.layout.item, foodList);
//        // Adapterの設定
//        list.setAdapter(adapter);
//        // ListViewの読み込み
//        ListView foodList = (ListView)findViewById(R.id.list);

//        foodList.add(new food("魚", "20170303"));
//        foodList.add(new food("牛", "20180909"));
//        foodList.add(new food("七面鳥", "20171128"));
//        ArrayAdapter foodAdapter;
//        foodAdapter = new ArrayAdapter(Content content, int textViewResourceId, String[]data);
    }
    //ここのかっこは　protected void onCreate(Bundle savedInstanceState)

    @Override
    public void onUserLeaveHint() {
        try {
            FileOutputStream fos = openFileOutput("lCard", MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(readFoodList);
            oos.close();
            fos.close();
        } catch (Exception e) {
        }
    }

    public boolean readFile() {
        try {
            FileInputStream fis = openFileInput("lCard");
            ObjectInputStream ois = new ObjectInputStream(fis);
            readFoodList = (ArrayList<Card>) ois.readObject();
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

    public boolean save() {
        try {
            FileOutputStream fos = openFileOutput("lFood", MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(readFoodList);
            oos.close();
            fos.close();
        } catch (Exception e) {

        }

        Intent intent = new Intent(listActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);

        return true;
    }




}
