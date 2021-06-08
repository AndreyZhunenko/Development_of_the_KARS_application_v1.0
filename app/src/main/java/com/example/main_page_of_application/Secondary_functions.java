package com.example.main_page_of_application;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Secondary_functions {

      String str_my_json = "";

   public Category_of_goods Parsing_JSONObject_on_string(JSONObject my_json){

      Category_of_goods myList = new Category_of_goods();

      if (my_json != null){
         str_my_json = my_json.toString();

         GsonBuilder mybuilder = new GsonBuilder();
         Gson myGson = mybuilder.create();
         myList = myGson.fromJson(str_my_json, Category_of_goods.class);

      }

      return myList;
   }




}
