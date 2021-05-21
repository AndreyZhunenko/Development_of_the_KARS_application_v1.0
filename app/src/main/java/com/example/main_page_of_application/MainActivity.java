package com.example.main_page_of_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView LogoCompany;

    ImageButton ButtonCatalog;
    ImageButton ButtonShops;
    ImageButton ButtonMyprofil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LogoCompany = findViewById(R.id.LogoCompanyID);
        LogoCompany.setImageResource(R.drawable.main_logo);

        ButtonCatalog = findViewById(R.id.btnCatalog);
        ButtonCatalog.setImageResource(R.drawable.catalog_finish_ready);

        ButtonShops = findViewById(R.id.btnShops);
        ButtonShops.setImageResource(R.drawable.shops_in_company);

        ButtonMyprofil = findViewById(R.id.btnMyProfil);
        ButtonMyprofil.setImageResource(R.drawable.my_profil_ready);

    }
}