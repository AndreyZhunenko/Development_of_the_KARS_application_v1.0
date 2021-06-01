package com.example.main_page_of_application;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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
    String firstParent_id = "-1";
    //HashMap<String, String> historyRequest = new HashMap<>();
  //  CategoryListAdapter myAdapter = new CategoryListAdapter();

    String UrlAdress = "http://192.168.0.39/get_list_of_categories_from_database.php";

   // ArrayList dataForListAdapter = new ArrayList<>();

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);

        ListCategories_of_goods = findViewById(R.id.ListOFcategories_id);
        JSONObject bodyJson = new JSONObject();
        if (firstParent_id.equals("-1")){
            try {
                bodyJson.put("Name", "0");
                NewRequestOnServer myRequest = new NewRequestOnServer(ListCategories_of_goods, UrlAdress, bodyJson, this, 20);
                myRequest.GetDataFromServer();
                firstParent_id = myRequest.OurParentId;
            } catch (JSONException e) {
                e.printStackTrace();
            }
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

    public void ONclick_button_ReturnBack(View view) throws JSONException {
            btn_returnBack.setImageResource(R.drawable.button_return1_onclick);
            JSONObject ReturnbodyJson = new JSONObject();
            ReturnbodyJson.put("Name", "0");
            NewRequestOnServer myRequestReturn = new NewRequestOnServer(ListCategories_of_goods, UrlAdress, ReturnbodyJson, this, 20);
            myRequestReturn.GetDataFromServer();
            firstParent_id = myRequestReturn.OurParentId;
    }

    public void Onclick_itemList(View onClickView) throws JSONException {
        Button ourbtn = onClickView.findViewById(R.id.Button_categoryItem_id);
        JSONObject bodyNewRequest = new JSONObject();
        bodyNewRequest.put("Name", ourbtn.getText().toString());
        bodyNewRequest.put("parent_id", firstParent_id);
        NewRequestOnServer myNewRequest = new NewRequestOnServer(ListCategories_of_goods, UrlAdress, bodyNewRequest, this, 18);
        myNewRequest.GetDataFromServer();
        firstParent_id = myNewRequest.OurParentId;
    }

}
