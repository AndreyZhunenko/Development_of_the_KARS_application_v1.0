package com.example.main_page_of_application;

import android.content.Context;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static android.view.View.TEXT_ALIGNMENT_CENTER;

public class CategoryListAdapter extends BaseAdapter {
    Context ctx;
    ArrayList<String>categories;
   // String nowParentId = "";
    int SizeTextItem;


    public CategoryListAdapter(Context ctx, ArrayList<String>categories, int SizeTextItem){
        this.ctx = ctx;
        this.categories = categories;
        this.SizeTextItem = SizeTextItem;
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
        Button NameOFcategory = convertView.findViewById(R.id.Button_categoryItem_id);

        NameOFcategory.setTextSize(TypedValue.COMPLEX_UNIT_SP, SizeTextItem);
        NameOFcategory.setTextAlignment(TEXT_ALIGNMENT_CENTER);
        NameOFcategory.setText(ValueCategory);

        return convertView;
    }


}
