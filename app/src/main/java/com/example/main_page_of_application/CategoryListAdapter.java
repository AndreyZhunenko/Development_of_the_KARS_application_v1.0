package com.example.main_page_of_application;

import android.content.Context;
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

public class CategoryListAdapter extends BaseAdapter {
    Context ctx;
    ArrayList<String>categories;
    String nowParentId = "";

   /* public CategoryListAdapter(){

    }*/
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
        Button NameOFcategory = convertView.findViewById(R.id.Button_categoryItem_id);

        NameOFcategory.setText(ValueCategory);


        //JSONObject bodyRequest = new JSONObject();
        //CatalogActivity myActivity = new CatalogActivity();


       /* NameOFcategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myActivity.ListCategories_of_goods.setAdapter(null);
               /* try {
                    if (nowParentId.isEmpty()){
                        bodyRequest.put("Name", NameOFcategory.getText().toString());
                        bodyRequest.put("parent_id", myActivity.firstParent_id);
                        NewRequestOnServer new_request = new NewRequestOnServer(myActivity.ListCategories_of_goods, myActivity.UrlAdress, bodyRequest, ctx);
                        new_request.GetDataFromServer();
                        nowParentId = new_request.OurParentId;
                    }
                    else{
                        bodyRequest.put("Name", NameOFcategory.getText().toString());
                        bodyRequest.put("parent_id", nowParentId);
                        NewRequestOnServer new_request = new NewRequestOnServer(myActivity.ListCategories_of_goods, myActivity.UrlAdress, bodyRequest, ctx);
                        new_request.GetDataFromServer();
                        nowParentId = new_request.OurParentId;
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }*/
            //}
        //});*/

        return convertView;
    }


}
