package com.example.main_page_of_application;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONException;
import org.json.JSONObject;


public class ListOfGoodsActivity extends Activity {
    ImageButton PageCatalogSearch;
    ImageButton PageCatalogLOGO;
    ImageButton PageCatalogBasket;
    ImageButton btn_returnBack;
    ImageButton ButtonCatalog;
    ImageButton ButtonShops;
    ImageButton ButtonMyprofil;

    RecyclerView List_of_goods;

    String URLadress = "http://192.168.0.39/get_list_of_goods_from_server.php";

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_goods);

        List_of_goods = findViewById(R.id.List_of_goods_id);

        GridLayoutManager manager = new GridLayoutManager(this, 2);
        List_of_goods.setLayoutManager(manager);
        List_of_goods.setHasFixedSize(true);

        Intent intent = getIntent();
        String ID_category = intent.getStringExtra("ID");
        JSONObject bodyRequest = new JSONObject();
        try {
            if (ID_category != null){
                bodyRequest.put("IDcategory", ID_category);
                NewRequestOnServer myRequest = new NewRequestOnServer(List_of_goods, URLadress, bodyRequest, this);
                myRequest.GetListOfGoodsFromServer();
            }
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
        Intent GoToMainPage = new Intent(ListOfGoodsActivity.this, MainActivity.class);
        startActivity(GoToMainPage);
    }

    public void ONclick_button_Basket(View view){
        Intent gotoBasketIntent = new Intent(ListOfGoodsActivity.this, UserBasketActivity.class);
        startActivity(gotoBasketIntent);
    }











}
