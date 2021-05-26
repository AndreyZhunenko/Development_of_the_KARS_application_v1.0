package com.example.main_page_of_application;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CatalogActivity extends Activity {

    ImageButton PageCatalogSearch;
    ImageButton PageCatalogLOGO;
    ImageButton PageCatalogBasket;
    ImageButton btn_returnBack;
    ImageButton ButtonCatalog;
    ImageButton ButtonShops;
    ImageButton ButtonMyprofil;

    ListView ListCategories_of_goods;



    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);

        ListCategories_of_goods = findViewById(R.id.ListOFcategories_id);
        CategoryListAdapter myListCategoriesAdarter;
        ArrayList<String>categories = new ArrayList<>();

        for (int i = 0; i < 13; i++){
            categories.add("Подарки");
            categories.add("Посуда");
            categories.add("Товары для дома");
            categories.add("Игрушки");
            categories.add("Зажигалки");
        }

        myListCategoriesAdarter = new CategoryListAdapter(this, categories);
        ListCategories_of_goods.setAdapter(myListCategoriesAdarter);




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



}
