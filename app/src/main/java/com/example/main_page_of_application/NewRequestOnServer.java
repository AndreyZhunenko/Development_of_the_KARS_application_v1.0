package com.example.main_page_of_application;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.ContextMenu;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class NewRequestOnServer extends Activity {
    Context myCTX;
    ListView myList;
    String UrlAdress;
    JSONObject bodyJson;
    CategoryListAdapter myAdapter;
    ArrayList resultCategories = new ArrayList<>();
    int SizeTextItem;
    RecyclerView myGoods;


    public NewRequestOnServer(ListView myList, String UrlAdress, JSONObject bodyJson, Context myCTX, int SizeTextItem) {
        this.myList = myList;
        this.UrlAdress = UrlAdress;
        this.bodyJson = bodyJson;
        this.myCTX = myCTX;
        this.SizeTextItem = SizeTextItem;
    }

    public NewRequestOnServer(RecyclerView myGoods, String UrlAdress, JSONObject bodyJson, Context myCTX){
        this.myGoods = myGoods;
        this.UrlAdress = UrlAdress;
        this.bodyJson = bodyJson;
        this.myCTX = myCTX;
    }

    public void GetDataFromServer(TextView tvCountSlesh, TextView tvError) {

        CustomJsonObjectRequest myRequest = new CustomJsonObjectRequest(Request.Method.POST, UrlAdress, bodyJson,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Category_of_goods myListCategories;
                        Secondary_functions parsingJson = new Secondary_functions();
                        myListCategories = parsingJson.ParsingCategories_json_on_string(response);
                        resultCategories = myListCategories.categories;
                        tvCountSlesh.setText(myListCategories.CountSlesh);
                        tvError.setText(myListCategories.Error);
                        if (!tvError.getText().toString().equals("-1")) {
                            myAdapter = new CategoryListAdapter(myCTX, resultCategories, SizeTextItem);
                            myList.setAdapter(myAdapter);
                        } else {
                            Intent GoToNewActivity = new Intent(myCTX, ListOfGoodsActivity.class);
                            GoToNewActivity.putExtra("ID", myListCategories.id);
                            myCTX.startActivity(GoToNewActivity);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        App.getApp().addToRequestQueue(myRequest);
        myRequest.setRetryPolicy(new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {
            }
        });

    }

    public void GetListOfGoodsFromServer() {
        CustomJsonObjectRequest myRequest = new CustomJsonObjectRequest(Request.Method.POST, UrlAdress, bodyJson,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Array_of_goods myListOfGoods = new Array_of_goods();
                        Secondary_functions parsingJSONgoods = new Secondary_functions();
                        myListOfGoods = parsingJSONgoods.ParsingGoods_json_on_string(response);

                        GoodsAdapter myAdapter = new GoodsAdapter(myListOfGoods);
                        myGoods.setAdapter(myAdapter);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(myCTX, "Ошибки на сервере!", Toast.LENGTH_LONG).show();
            }
        });
        App.getApp().addToRequestQueue(myRequest);
        myRequest.setRetryPolicy(new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {
            }
        });


    }

}
