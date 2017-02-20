package com.example.junekelectric.shoumikigenlist;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class listActivity extends AppCompatActivity {
    List<food> foodList;
    FoodAdapter foodAdapter;
    ListView mListView:

    // ListViewに表示する食べ物
    public static final String[] food = {
           // "魚", "牛", "七面鳥", "（上は仮）"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        mListView = (ListView) findViewById(R.id.list);
        foodList = new ArrayList<food>();






















        // Adapterの作成
        foodAdapter adapter = new foodAdapter(
                this,
                R.layout.item,
                food
        );

        // Adapterの設定
        foodList.setAdapter(adapter);

        // ListViewの読み込み
        ListView foodList = (ListView)findViewById(R.id.list);

        // Adapterの作成
        ArrayList<food> foodList = new ArrayList<food>();
        foodList.add(new food("魚", "20170303"));
        foodList.add(new food("牛", "20180909"));
        foodList.add(new food("七面鳥", "20171128"));
        foodAdapter adapter = new foodAdapter(listActivity.this, foodList);

// Adapterの設定
        listView.setAdapter(adapter);

//        ArrayAdapter foodAdapter;
//        foodAdapter = new ArrayAdapter(Content content, int textViewResourceId, String[]data);

    }
}
