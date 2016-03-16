package com.karol.klimonczyk.citylist;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Karol on 3/15/2016.
 */
public class AsyncGetCity extends AsyncTask<String, Void, Void> {

    RequestQueue requestQueue;
    String getCity;
    Context context;
    GoogleGeoCodeResponse googleGeoCodeResponse;


    public AsyncGetCity(RequestQueue requestQueue, String city, Context context) {
        this.requestQueue = requestQueue;
        this.getCity = city;
        this.context=context;
    }

    @Override
    protected Void doInBackground(String... params) {

        String url="http://maps.googleapis.com/maps/api/geocode/json?address="+getCity+"&sensor=true";
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, url,
                new Response.Listener<JSONObject>(){


                    @Override
                    public void onResponse(JSONObject response) {

                        Gson gson = new Gson();
                         googleGeoCodeResponse=gson.fromJson(response.toString(), GoogleGeoCodeResponse.class);


                        if( googleGeoCodeResponse.getStatus().equals("OK")){
                            Intent myIntent = new Intent(context, CityInfoActivity.class);
                            myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            myIntent.putExtra("googleGeo", googleGeoCodeResponse);
                            context.startActivity(myIntent);
                        }
                        else{
                            Toast.makeText(context, "Incorrect city name", Toast.LENGTH_LONG).show();
                        }
                    }
                }, new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }

        );
        requestQueue.add(jsonObjectRequest);

        return null;
    }


}





