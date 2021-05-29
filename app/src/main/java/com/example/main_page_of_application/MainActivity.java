package com.example.main_page_of_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ImageView LogoCompany;
    ImageButton ButtonCatalog;
    ImageButton ButtonShops;
    ImageButton ButtonMyprofil;
    String UrlAdress = "http://192.168.0.39/get_list_of_categories_from_database.php";


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

    public void ONclick_button_Catalog(View view){
        Intent CatalogIntent = new Intent(MainActivity.this, CatalogActivity.class );
        startActivity(CatalogIntent);
    }






}