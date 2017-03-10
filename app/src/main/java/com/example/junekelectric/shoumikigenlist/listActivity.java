package com.example.junekelectric.shoumikigenlist;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

import static com.example.junekelectric.shoumikigenlist.R.id.title;

public class listActivity extends AppCompatActivity {
    ArrayList<Card> foodList;
    foodAdapter mFoodAdapter;
    ListView mListView;
    SharedPreferences pref;

// ListViewに表示する食べ物
//    public static final String[] food = {
//           // "魚", "牛", "七面鳥", "（上は仮）"
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        mListView = (ListView) findViewById(R.id.list);
        foodList = new ArrayList<Card>();

        pref = getSharedPreferences("pref_memo", MODE_PRIVATE);

        //foodList.add(new Card(getString("key_title")), getString("key_date"), getString("key_content"))));
        //foodList.add(new Card(getString(R.id.titleTextView)), getString(dateTextView), getString(contentTextView))));
        foodList.add(new Card(pref.getString("key_title", ""), pref.getString("key_date", ""), pref.getString("key_content","")));

        mFoodAdapter = new foodAdapter(this, R.layout.item, foodList);
        mListView.setAdapter(mFoodAdapter);

        // Adapterの作成
        foodAdapter adapter = new foodAdapter(this, R.layout.item, foodList);
        // Adapterの設定
        mListView.setAdapter(adapter);

        // ListViewの読み込み
        ListView foodList = (ListView)findViewById(R.id.list);

//        foodList.add(new food("魚", "20170303"));
//        foodList.add(new food("牛", "20180909"));
//        foodList.add(new food("七面鳥", "20171128"));

//        ArrayAdapter foodAdapter;
//        foodAdapter = new ArrayAdapter(Content content, int textViewResourceId, String[]data);
    }


}
