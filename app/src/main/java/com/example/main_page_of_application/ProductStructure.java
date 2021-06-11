package com.example.main_page_of_application;

import android.content.Context;

import com.squareup.picasso.Picasso;

public class ProductStructure {
    String name = "";
    int pnt;
    double price;

    String imageURL_1 = "https://www.kars.ru/images/goods/";
    String imageURL_2 = ".jpg";
    String readyURLimage = "";


    public ProductStructure(){
    }

    public void Create_ready_url_image(){
        readyURLimage = imageURL_1 + String.valueOf(pnt) + imageURL_2;
    }

}
