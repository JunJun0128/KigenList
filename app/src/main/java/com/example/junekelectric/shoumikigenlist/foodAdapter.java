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

//import static android.R.id.content;
//import static android.R.id.title;
//import static android.R.id.days;
//import static android.R.id.diff;
//
//import static com.example.junekelectric.shoumikigenlist.R.id.content;
//import static com.example.junekelectric.shoumikigenlist.R.id.date;
//import static com.example.junekelectric.shoumikigenlist.R.id.title;
//import static com.example.junekelectric.shoumikigenlist.R.id.diff;

/**
 * Created by junekelectric on 2017/01/27.
 */

public class foodAdapter extends ArrayAdapter<Card> {
    //Context context;
    List<Card> foodList;
    private LayoutInflater inflater;

//    public foodAdapter(Context context, int resource, String[] objects) {

    public foodAdapter (Context context, int textViewResourceId, List<Card> cList) {
        super(context, textViewResourceId, cList);
        foodList = cList;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.foodList = foodList;
    }

//    public foodAdapter (Context context, int layoutResourceId, List<Card> objects) {
//        super(context, layoutResourceId, objects);
//        foodList = objects;
//        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        this.foodList = foodList;
//    }

        @Override
        public int getCount () {
            return foodList.size();
        }

        @Override
        public Card getItem (int position) {
            return foodList.get(position);
        }

//        @Override
//        public long getFoodId(int position){
//            return 0;}

    private class ViewHolder {
        //継承前のitem.xmlの中身を書きます
        //get instance
        TextView titleTv;
        TextView daysTv;
        TextView diffTv;
        TextView contentTv;

//        public ViewHolder(View view) {
//            titleTv = (TextView) view.findViewById(title);
//            //daysTv = (TextView) view.findViewById(date);
//            contentTv = (TextView) view.findViewById(content);
//            diffTv = (TextView) view.findViewById(diff);
//        }
    }

    @Override
    public View getView (final int position, View convertView, ViewGroup parent){
        final ViewHolder viewHolder;

        if (convertView == null) {
            inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item, null);

            TextView title = (TextView) convertView.findViewById(R.id.titleitem);
            TextView content = (TextView) convertView.findViewById(R.id.contentitem);
            TextView date = (TextView) convertView.findViewById(R.id.dateitem);
            TextView diff = (TextView) convertView.findViewById(R.id.diff);

            viewHolder = new ViewHolder();
            viewHolder.titleTv = title;
            viewHolder.contentTv = content;
            viewHolder.daysTv = date;
            viewHolder.diffTv = diff;

            convertView.setTag(viewHolder);
            //ここでtagを設定しないと落ちる　by単語帳教科書

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            //以下はいらない
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
            viewHolder.titleTv.setText(item.getTitle());
            viewHolder.contentTv.setText(item.getContent());
            viewHolder.daysTv.setText(item.getContent());
            viewHolder.diffTv.setText(String.valueOf(item.getDiffday()));
        }
        return convertView;
    }




}
