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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import com.example.travelexperts.models.Packages;

public class CustomerDashboard extends AppCompatActivity {

    private final String Jsonurl = "http://10.0.2.2:8080/api.travelexperts.com/rest/packages/getallpackages";
    private JsonArrayRequest request;
    private RequestQueue requestqueue;
    private List<Packages> lstPackages;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lstPackages = new ArrayList<Packages>();
        setContentView(R.layout.activity_customer_dashboard);
        recyclerView = findViewById(R.id.recyclerviewid);
        jsonrequest();
    }

    private void jsonrequest(){

        request = new JsonArrayRequest(Jsonurl, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                System.out.println(response);
                JSONObject jsonObject = null;

                for(int i=0; i < response.length(); i++)
                {
                    try{
                        jsonObject = response.getJSONObject(i);
                        //make a class object
                        Packages packages = new Packages();
                        packages.setPackageId(jsonObject.getString("packageId"));
                        packages.setPkgName(jsonObject.getString("pkgName"));
                        packages.setBasePrice(jsonObject.getString("pkgBasePrice"));
                        packages.setPkgDesc(jsonObject.getString("pkgDesc"));
                        packages.setPkgStartDate(jsonObject.getString("pkgStartDate"));
                        packages.setPkgEnddate(jsonObject.getString("pkgEndDate"));
                        packages.setPkgAgencyCommission(jsonObject.getString("pkgAgencyCommission"));
                        lstPackages.add(packages);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                setuprecyclerview(lstPackages);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error);
            }
        });

        requestqueue = Volley.newRequestQueue(CustomerDashboard.this);
        requestqueue.add(request);
    }

    private void setuprecyclerview(List<Packages> lstPackages) {

        RecyclerViewAdapter myadapter = new RecyclerViewAdapter(this,lstPackages);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(myadapter);
    }


}
