package com.example.travelexperts.activities;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.travelexperts.R;

public class PackageInformation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_information);
        //hide the action bar

        getSupportActionBar().hide();

        // Recieve data

        String name  = getIntent().getExtras().getString("package_name");
        String description = getIntent().getExtras().getString("package_description");
        String package_price = getIntent().getExtras().getString("package_price");
        String package_start_date = getIntent().getExtras().getString("package_start_date");
        String package_end_date = getIntent().getExtras().getString("package_end_date");
        //String rating = getIntent().getExtras().getString("anime_rating") ;
        //String image_url = getIntent().getExtras().getString("anime_img") ;

        // ini views

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingtoolbar_id);
        collapsingToolbarLayout.setTitleEnabled(true);

        TextView tv_name = findViewById(R.id.aa_package_name);
        TextView tv_studio = findViewById(R.id.aa_price);
        TextView tv_start_date = findViewById(R.id.aa_start_date) ;
        TextView tv_end_date = findViewById(R.id.aa_end_date) ;
        TextView tv_description = findViewById(R.id.aa_description);
        //TextView tv_rating  = findViewById(R.id.aa_rating) ;
        //ImageView img = findViewById(R.id.aa_thumbnail);

        // setting values to each view

        tv_name.setText(name);
        tv_start_date.setText(package_start_date);
        tv_end_date.setText(package_end_date);
        tv_description.setText(description);
        //tv_rating.setText(rating);
        tv_studio.setText(package_price);

        collapsingToolbarLayout.setTitle(name);


        RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);


        // set image using Glide
        //Glide.with(this).load(image_url).apply(requestOptions).into(img);
    }
}
