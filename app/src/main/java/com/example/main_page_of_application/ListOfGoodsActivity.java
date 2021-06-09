package com.example.main_page_of_application;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageButton;


public class ListOfGoodsActivity extends Activity {
    ImageButton PageCatalogSearch;
    ImageButton PageCatalogLOGO;
    ImageButton PageCatalogBasket;
    ImageButton btn_returnBack;
    ImageButton ButtonCatalog;
    ImageButton ButtonShops;
    ImageButton ButtonMyprofil;





    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_goods);









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
}
