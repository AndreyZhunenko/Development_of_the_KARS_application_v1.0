package com.example.main_page_of_application;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;

public class UserBasketActivity extends Activity {

    ImageButton PageBasketLogo;
    ImageButton ButtonCatalog;
    ImageButton ButtonShops;
    ImageButton ButtonMyprofil;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_basket);

        PageBasketLogo = findViewById(R.id.BasketLogo);
        PageBasketLogo.setImageResource(R.drawable.main_logo_button);






        ButtonCatalog = findViewById(R.id.btnCatalog);
        ButtonCatalog.setImageResource(R.drawable.catalog_finish_ready);
        ButtonShops = findViewById(R.id.btnShops);
        ButtonShops.setImageResource(R.drawable.shops_in_company);
        ButtonMyprofil = findViewById(R.id.btnMyProfil);
        ButtonMyprofil.setImageResource(R.drawable.my_profil_ready);
    }

    public void ONclick_button_BasketLOGO(View view){
        Intent ReturnONmainPage = new Intent(UserBasketActivity.this, MainActivity.class);
        startActivity(ReturnONmainPage);
    }
    public void ONclick_buttonBasket_catalog(View view){
        Intent ReturnONmainPage = new Intent(UserBasketActivity.this, CatalogActivity.class);
        startActivity(ReturnONmainPage);
    }

}
