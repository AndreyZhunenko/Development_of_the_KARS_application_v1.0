package com.example.main_page_of_application;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.Nullable;

public class CatalogActivity extends Activity {

    ImageButton PageCatalogLOGO;

    ImageButton ButtonCatalog;
    ImageButton ButtonShops;
    ImageButton ButtonMyprofil;



    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);

        PageCatalogLOGO = findViewById(R.id.CatalogLogo);
        PageCatalogLOGO.setImageResource(R.drawable.main_logo_button);

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



}
