package com.example.jiraiya.volley;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class Singleton {

    private static Singleton mInstance;
    private RequestQueue requestQueue;
    private Context context;

    private Singleton(Context con){
        context=con;
        requestQueue=getRequestQueue();
    }

    private RequestQueue getRequestQueue() {
        if(requestQueue==null)
            requestQueue= Volley.newRequestQueue(context.getApplicationContext());
        return requestQueue;
    }

    public static Singleton getInstance(Context context){

        if(mInstance==null)
            mInstance=new Singleton(context);
        return mInstance;

    }

    public<T> void addToRequestQueue(Request<T> request){

        requestQueue.add(request);
    }
}
