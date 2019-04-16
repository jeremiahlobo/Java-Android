package com.example.travelexperts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView trlogo ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        //setting the logo
        trlogo = (ImageView) findViewById(R.id.login_img);
        trlogo.setImageResource(R.drawable.trcolorwhite);

    }

    public void LoginCustomer(View view)
    {
        //Json call to login customer
        Intent CustomerDashboard = new Intent(this, CustomerDashboard.class);
        startActivity(CustomerDashboard);
    }
}
