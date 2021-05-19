package com.example.main_page_of_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView LogoCompany;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LogoCompany = findViewById(R.id.LogoCompanyID);
        LogoCompany.setImageResource(R.drawable.main_logo);
    }
}