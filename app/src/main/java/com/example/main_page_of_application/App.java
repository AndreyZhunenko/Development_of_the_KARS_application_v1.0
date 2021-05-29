package com.example.main_page_of_application;

import android.app.Application;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class App extends Application {
    private static RequestQueue myRequestQueue;
    private static App my_app;

    @Override
    public void onCreate() {
        super.onCreate();
        my_app = this;
    }

    public static synchronized  App getApp(){
        return my_app;
    }

    public RequestQueue getMyRequestQueue(){
        if (myRequestQueue == null){
            myRequestQueue = Volley.newRequestQueue(this.getApplicationContext());
        }
        return myRequestQueue;
    }

    public void addToRequestQueue(Request myRequest){
        getMyRequestQueue().add(myRequest);
    }
}
