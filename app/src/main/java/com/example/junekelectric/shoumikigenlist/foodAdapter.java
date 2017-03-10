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

/**
 * Created by junekelectric on 2017/01/27.
 */

//public class foodAdapter extends ArrayAdapter<String>{
public class foodAdapter extends ArrayAdapter<Card> {
    //Context context;
    List<Card> foodList;

//    public foodAdapter(Context context, int resource, String[] objects) {



    public foodAdapter(Context context, int layoutResourceId, List<Card> objects) {
        super(context, layoutResourceId, objects);
        foodList = objects;
        //layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //this.foodList = foodList;
    }

        @Override
        public int getCount () {
            return foodList.size();
        }

        @Override
        public Card getItem (int position){
            return foodList.get(position);
        }

//        @Override
//        public long getFoodId(int position){
//            return 0;}

    @Override
    public View getView (final int position, View convertView, ViewGroup parent){
        final ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder); //ここでtagを設定しないと落ちる　from単語帳教科書
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
//                TextView title = (TextView) convertView.findViewById(R.id.title);
//                title.setText(listActivity.get(position).getTitle);
//
//                TextView date = (TextView) convertView.findViewById(R.id.date);
//                date.setText(listActivity.get(position).getDate);
//
//                TextView content = (TextView) convertView.findViewById(R.id.content);
//                content.setText(listActivity.get(position).getContent);
        }

        final Card item = getItem(position);

        if (item != null){
            //set data
            viewHolder.titleTextView.setText(item.title);
            viewHolder.dateTextView.setText(item.date);
            viewHolder.contentTextView.setText(item.content);
        }
        return convertView;
    }

    private class ViewHolder {
        //継承前のitem.xmlの中身を書きます
        //get instance
        TextView titleTextView;
        TextView dateTextView;
        TextView contentTextView;

        public ViewHolder(View view) {
            titleTextView = (TextView) view.findViewById(title);
            dateTextView = (TextView) view.findViewById(date);
            contentTextView = (TextView) view.findViewById(content);
        }
    }


}
