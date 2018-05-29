package com.example.jiraiya.volley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    TextView tv,tv1,tv2;
    Button btn;
    String serverip="http://192.xxx.xxx.xxx/fetch.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.data_string);
        tv1 = (TextView) findViewById(R.id.data_address);
        tv2 = (TextView) findViewById(R.id.data_phone);
        btn = (Button) findViewById(R.id.fetch);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.POST, serverip, null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {

                                try {
                                    tv.setText(response.getString("Name"));
                                    tv1.setText(response.getString("Email"));
                                    tv2.setText(response.getString("Mobile"));
                                }catch (JSONException e){
                                    Toast.makeText(MainActivity.this, "JSON Exception", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Error !!", Toast.LENGTH_SHORT).show();
                    }
                });
                Singleton.getInstance(getApplicationContext()).addToRequestQueue(jsonObjectRequest);


            }
        });
    }
}
