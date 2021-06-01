package com.example.main_page_of_application;

import android.app.Activity;
import android.content.Context;
import android.view.ContextMenu;
import android.widget.ListView;
import android.widget.Toast;

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
    String OurParentId = "";
    ArrayList resultCategories = new ArrayList<>();
    int SizeTextItem;



    public NewRequestOnServer( ListView myList, String UrlAdress, JSONObject bodyJson, Context myCTX, int SizeTextItem){
        this.myList = myList;
        this.UrlAdress = UrlAdress;
        this.bodyJson = bodyJson;
        this.myCTX = myCTX;
        this.SizeTextItem = SizeTextItem;
    }

    public void GetDataFromServer(){
        CustomJsonObjectRequest myRequest = new CustomJsonObjectRequest(Request.Method.POST, UrlAdress, bodyJson, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    Preparing_data_for_submission(response, "categories", "");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                myAdapter = new CategoryListAdapter(myCTX, resultCategories, SizeTextItem);
                myList.setAdapter(myAdapter);
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

    public void Preparing_data_for_submission(JSONObject responseServer, String Parsing1, String Parsing2) throws JSONException {
        HashMap<String, String> rezultParsing = new HashMap<>();
        Secondary_functions parsingOurData = new Secondary_functions();
        rezultParsing = parsingOurData.ParsingJSONObject_on_String(responseServer, Parsing1, Parsing2);
        for (String key: rezultParsing.keySet()){
            if ( key.equals("parent_id") ){
                OurParentId = rezultParsing.get(key);
            }
            else{
                resultCategories.add(rezultParsing.get(key));
            }
        }
    }

}
