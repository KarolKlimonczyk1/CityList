package com.karol.klimonczyk.citylist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Karol on 3/15/2016.
 */
public class ListAdapter extends BaseAdapter {

    Context context;
    List<String> cities;
    LayoutInflater layoutInflater;

    public ListAdapter(Context context, List<String> cities) {
        this.context = context;
        this.cities = cities;
        layoutInflater=(LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return cities.size();
    }

    @Override
    public Object getItem(int position) {
        return cities.get(position);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=convertView;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.activity_list_item, parent, false);
        }
        if (position % 2 == 0) {
            view.setBackgroundResource(R.color.colorPrimary);
        } else {
            view.setBackgroundResource(R.color.colorAccent);
        }

        ((TextView) view.findViewById(R.id.list_item)).setText(cities.get(position));

        return view;
    }


}
