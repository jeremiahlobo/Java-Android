package com.example.travelexperts.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.travelexperts.R;
import com.example.travelexperts.adapters.*;
import com.example.travelexperts.models.Anime;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CustomerDashboard extends AppCompatActivity {

    private final String Jsonurl = "https://gist.githubusercontent.com/aws1994/f583d54e5af8e56173492d3f60dd5ebf/raw/c7796ba51d5a0d37fc756cf0fd14e54434c547bc/anime.json";
    private JsonArrayRequest request;
    private RequestQueue requestqueue;
    private List<Anime> lstAnime;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lstAnime = new ArrayList<>();
        setContentView(R.layout.activity_customer_dashboard);
        recyclerView = findViewById(R.id.recyclerviewid);
        jsonrequest();
    }

    private void jsonrequest(){

        request = new JsonArrayRequest(Jsonurl, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;

                for(int i=0; i < response.length(); i++)
                {
                    try{
                        jsonObject = response.getJSONObject(i);
                        //make a class object
                        Anime anime = new Anime();
                        anime.setName(jsonObject.getString("name"));
                        anime.setDescription(jsonObject.getString("description"));
                        anime.setRating(jsonObject.getString("Rating"));
                        anime.setCategorie(jsonObject.getString("categorie"));
                        anime.setStudio(jsonObject.getString("studio"));
                        anime.setNb_episode(jsonObject.getInt("episode"));
                        anime.setImage_url(jsonObject.getString("img"));

                        lstAnime.add(anime);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                setuprecyclerview(lstAnime);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestqueue = Volley.newRequestQueue(CustomerDashboard.this);
        requestqueue.add(request);
    }

    private void setuprecyclerview(List<Anime> lstAnime) {

        RecyclerViewAdapter myadapter = new RecyclerViewAdapter(this,lstAnime);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(myadapter);
    }


}
