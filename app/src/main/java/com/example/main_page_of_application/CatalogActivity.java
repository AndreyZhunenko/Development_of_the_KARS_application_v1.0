package com.example.main_page_of_application;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class CatalogActivity extends Activity {

    ImageButton PageCatalogSearch;
    ImageButton PageCatalogLOGO;
    ImageButton PageCatalogBasket;
    ImageButton btn_returnBack;
    ImageButton ButtonCatalog;
    ImageButton ButtonShops;
    ImageButton ButtonMyprofil;
    ListView ListCategories_of_goods;

    String UrlAdress = "http://192.168.0.39/get_list_of_categories_from_database.php";
    JSONObject bodyJson = new JSONObject();

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);

        ListCategories_of_goods = findViewById(R.id.ListOFcategories_id);

        try {
            bodyJson.put("Priority_1", "0");
            GetDataFromServer(this);
        } catch (JSONException e) {
            e.printStackTrace();
        }


        PageCatalogSearch = findViewById(R.id.CatalogSearch);
        PageCatalogSearch.setImageResource(R.drawable.search_1);

        PageCatalogLOGO = findViewById(R.id.CatalogLogo);
        PageCatalogLOGO.setImageResource(R.drawable.main_logo_button);

        PageCatalogBasket = findViewById(R.id.CatalogBasket);
        PageCatalogBasket.setImageResource(R.drawable.basket_1);

        btn_returnBack = findViewById(R.id.CatalogButtonReturnBack);
        btn_returnBack.setImageResource(R.drawable.button_return1);




        ButtonCatalog = findViewById(R.id.btnCatalog);
        ButtonCatalog.setImageResource(R.drawable.catalog_finish_ready);
        ButtonShops = findViewById(R.id.btnShops);
        ButtonShops.setImageResource(R.drawable.shops_in_company);
        ButtonMyprofil = findViewById(R.id.btnMyProfil);
        ButtonMyprofil.setImageResource(R.drawable.my_profil_ready);
    }

    public void ONclick_button_LOGO(View view){
        Intent ReturnONmainPage = new Intent(CatalogActivity.this, MainActivity.class);
        startActivity(ReturnONmainPage);
    }

    public void ONclick_button_ReturnBack(View view){
        btn_returnBack.setImageResource(R.drawable.button_return1_onclick);
    }

    public void GetDataFromServer(Context ctx){
        CustomJsonObjectRequest myRequest = new CustomJsonObjectRequest(Request.Method.POST, UrlAdress, bodyJson, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                ArrayList<String> resultCategories = new ArrayList<>();
                try {
                    resultCategories = Preparing_data_for_submission(response, "categories", "");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                CategoryListAdapter myAdapter = new CategoryListAdapter(ctx, resultCategories);
                ListCategories_of_goods.setAdapter(myAdapter);
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

    public ArrayList Preparing_data_for_submission(JSONObject responseServer, String Parsing1, String Parsing2) throws JSONException {
        HashMap<String, String> rezultParsing = new HashMap<>();
        ArrayList<String> DataForSend = new ArrayList<>();
        Secondary_functions parsingOurData = new Secondary_functions();
        rezultParsing = parsingOurData.ParsingJSONObject_on_String(responseServer, Parsing1, Parsing2);
        for (String key: rezultParsing.keySet()){
            DataForSend.add(rezultParsing.get(key));
        }
        return DataForSend;
    }



}
