package com.example.junekelectric.shoumikigenlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

import static com.example.junekelectric.shoumikigenlist.R.id.content;
import static com.example.junekelectric.shoumikigenlist.R.id.date;
import static com.example.junekelectric.shoumikigenlist.R.id.title;
import static com.example.junekelectric.shoumikigenlist.listActivity.food;
/**
 * Created by junekelectric on 2017/01/27.
 */

//public class foodAdapter extends ArrayAdapter<String>{
public class foodAdapter extends ArrayAdapter<food> {
    Context context;
    ArrayList<food> foodList;

//    public foodAdapter(Context context, int resource, String[] objects) {

    public foodAdapter(Context context, int layoutResourceId, List<food> objects) {
        super(context, layoutResourceId, objects);
        foodList = objects;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //this.foodList = foodList;

        @Override
        public int getCount () {
            return foodList.size();
        }

        @Override
        public food getItem (int position){
            return foodList.get(position);
        }

//        @Override
//        public long getFoodId(int position){
//            return 0;}

        @Override
        public View getView (final int position, View convertView, ViewGroup parent){
            final ViewHoler viewHoler;

            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.item, null);
                viewHoler = new ViewHoler(convertView);
                convertView.setTag(viewHoler);//ここでtagを設定しないと落ちる　from単語帳教科書
            } else {
                viewHoler = (ViewHoler) convertView.getTag();
//                TextView title = (TextView) convertView.findViewById(R.id.title);
//                title.setText(listActivity.get(position).getTitle);
//
//                TextView date = (TextView) convertView.findViewById(R.id.date);
//                date.setText(listActivity.get(position).getDate);
//
//                TextView content = (TextView) convertView.findViewById(R.id.content);
//                content.setText(listActivity.get(position).getContent);
            }
            final food item = getItem(position);
            return convertView;
        }

        private class ViewHoler {
            //継承前のitem.xmlの中身を書きます
            title = (TextView) view.findViewById(title);
            date = (TextView) view.findViewById(date);
            content = (TextView) view.findViewById(content);

        }

    }

}
