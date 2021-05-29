package com.example.main_page_of_application;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.Response;

import org.json.JSONObject;

import java.util.ArrayList;

public class CategoryListAdapter extends BaseAdapter {

    Context ctx;
    ArrayList<String>categories;
    public CategoryListAdapter(Context ctx, ArrayList<String>categories){
        this.ctx = ctx;
        this.categories = categories;
    }

    @Override
    public int getCount() {
        return categories.size();
    }

    @Override
    public Object getItem(int position) {
        return categories.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String ValueCategory = categories.get(position);
        convertView = LayoutInflater.from(ctx).inflate(R.layout.category_item, parent, false);
        TextView NameOFcategory = convertView.findViewById(R.id.TextView_categoryItem_id);

        NameOFcategory.setText(ValueCategory);

        return convertView;
    }
}
