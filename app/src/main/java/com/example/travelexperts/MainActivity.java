package com.example.travelexperts;

import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.travelexperts.activities.CustomerDashboard;
import com.example.travelexperts.models.Packages;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ImageView trlogo ;
    private final String Jsonurl = "http://10.0.2.2:8080/api.travelexperts.com/rest/customers/login";
    private static final String TAG = MainActivity.class.getName();

    EditText username;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        //hide the default action bar

        getSupportActionBar().hide();

        //Json call to login customer
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        //setting the logo
        trlogo = (ImageView) findViewById(R.id.login_img);
        trlogo.setImageResource(R.drawable.trcolorwhite);

    }

    public void LoginCustomer(View view)
    {

        // before allowing the user to login
        String username_input = username.getText().toString().trim();
        String password_input = password.getText().toString().trim();

        jsonrequest(username_input, password_input);

    }

    private void setupDashboard(){
        Intent CustomerDashboard = new Intent(this, com.example.travelexperts.activities.CustomerDashboard.class);
        startActivity(CustomerDashboard);
    }

    private void jsonrequest( final String username, final String password){

        System.out.println(username);
        System.out.println(password);
        RequestQueue queue = Volley.newRequestQueue(this);//Creating The Request Queue
        StringRequest postRequest = new StringRequest(Request.Method.POST/*Setting The Method As Post*/, Jsonurl/*Passing The Url Of Your API*/,
                new Response.Listener<String>()
                {

                    @Override
                    public void onResponse(String response) {
                        if(Boolean.valueOf(response))
                        {
                            setupDashboard();
                        }else{
                            Toast.makeText(getApplicationContext(),"Please Check your username and password",Toast.LENGTH_SHORT).show();
                        }

                        Log.d(TAG, "Response"+response);
                        //Here You Will Get Your JSON as response.
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        // error
                        Log.d(TAG,"Error.Response");
                        //Here You Will Get Your Error related to your Request.
                    }
                }
        ) {
            @Override
            public String getBodyContentType() {
                return "application/x-www-form-urlencoded; charset=UTF-8";
            }

            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("username", username);
                params.put("password", password);//Puting The  Parameters In Map To Pass It To The API.

                return params;
            }
        };
        queue.add(postRequest);
    }
}
