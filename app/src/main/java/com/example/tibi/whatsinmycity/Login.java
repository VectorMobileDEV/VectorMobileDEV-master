package com.example.tibi.whatsinmycity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity
{



    String email="deventuredev@gmail.com",email2="deventuredev%40gmail.com", parola="deventure1@";
    Gson gson = new Gson();
    String url ="http://itec-api.deventure.co/api/Token";

    Button btn,btn1;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button)findViewById(R.id.button);
        btn1 = (Button)findViewById(R.id.button2);

        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent1 = new Intent(Login.this, MapsActivity.class);
                startActivity(intent1);
                functie_token();
                functie_get_user_by_email();
                functie_is_authorized();
                //functie_register();
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(Login.this, Sign_Up.class);
                startActivity(intent2);
            }
        });

    }

    public void functie_token(){

        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        //mTextView.setText("Response is: "+ response.substring(0,500));
                        Log.i("Token", response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //mTextView.setText("That didn't work!");
            }
        })
        {
            @Override
            public byte[] getBody() throws AuthFailureError {
//                return super.getBody();
            return ("username="+email+"&password="+parola+"&grant_type=password").getBytes();

            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("Content-Type", "application/x-www-form-urlencoded");
                return map;
            }
        };

// add the request to the RequestQueue.
        queue.add(stringRequest);

    }
    String url2 = ("http://itec-api.deventure.co/api/Account/GetUserByEmail?email="+email2);

    public void functie_get_user_by_email(){

        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url2,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //Info_User idk = gson.fromJson(response, Info_User.class);
                        Info_User idk = new Info_User();
                        idk = gson.fromJson(response, Info_User.class);
                        Log.i("GetUserByEmail", idk.getFullName()+"");
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //mTextView.setText("That didn't work!");
            }
        })
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {

                Map<String, String> map = new HashMap<>();
                map.put("Authorization", "Bearer JZakLhN-QzEqnoLuvNDV-LORVzPFm5xsT7TR79RPvMV5IMpKR7I5JJDaDSVQQYXz4Kg0h4Ah8uBbGetnH4eQAy31-AQGtQEhWp-Y43lcF8nzEVi0YvT-lLiTc39VtzpWQn_XFD6JJ_52YvPLlxVlP-euUU0g4Ad2Bz-B3PC5dXFzL97ww_N36jpHintZR5tdNOV9K6yD6_5m0AsufpirZjMXVPKK915YqRApxVARaDtGmVTMYFKVrlPBHFM1gMxH5aKDFkakIw66PaGh0pO1EAZCMEkwffCkgooQ1MB4iU9kkETycZ8XPwt23VO-WV1_hJdTYKd730UYoA1H-iq60up94vSi1Q5gIiFslBHlAYBmgxwCl3t4RZlqSRGRkUuvIS2TEggydI_sGlVxdCM0V6cheAHKgYO66F0PDSMr5FTIUOvG-mgopHenQ64sfUjuWZgBoxT3IBfeMxPOF7ilOpxHDVYL33ir3lzvpSMdRao9_RkQUlv-g0isg-oGgGgeCkDsdXtyrFnywFJKCxX5Aiqai9hzvJEEvi8nMySG1uK9W4q5DtSnR_5ADAMLM8cwWIcYrS6G9a_JiHitlM7xOqYNbT3hS8UViPRU0FmIubQu9TXxTfb8zaGRTlANoTR9r3T_dIQN1YzRCNEltM655Uxi8kJAi1g5KFnRmazvK6rrpmUBs5ql1CDhyQ-xYNUHpM7kekLf0XKk5r-D6Ii8wnUnXjznyWS2tQM2Dtw-gJA7lLmUzyVPuPm9YWfTSPBSNLThz7MVl3Nsr_K7aQ3LRw8ccKpmoMa9QeFHO8SdVnwDjoKdvmTGn105kH01RA0uxtVSdJNKf4vIDB_QpWG3FXxj1LNZsAV5lDZJoj8jI3gNgdjaYk2cLApvIJZ5hA8GAtoqyaj1b1Xi_BTV2DSkcvru9IXA2KqVPCAoXE_ZNggcvo-TisBosfVDEESW4XqL0E75vkRlxBd4pL3fjVT1ghggzOWDIQciAH9dfIcVd7BhzseLrrJE_7q9H_JjO_9zSvYjJtWWjI9y8FybINQfXm0zwPQNYK0y_09f-iRrb7PK7z9KtSVb58Krjuo_hDGljrO7PKhm03hzj4q5qKBFngaPDQHAQLLFGqYXIcmZeyxbvfvbI5_bp_XrS36_AkQr0wu09ky_2siZhzfTOZh_Me7hwtuGu1vzcgP7LZrqaEY");
                map.put("Content-Type", "application/json");
                return map;

            }
        };
        queue.add(stringRequest);

    }

    String url3 = ("http://itec-api.deventure.co/api/Account/IsAuthorized?email="+email);

    public void functie_is_authorized(){

        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url3,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        //mTextView.setText("Response is: "+ response.substring(0,500));
                        Log.i("IsAuthorized", response);


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //mTextView.setText("That didn't work!");
            }
        })
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {

                Map<String, String> map = new HashMap<>();
                map.put("Authorization", "Bearer KwtCakta9ludUFTNPXIAqJFuuIBpr72jTzvW8UUXlfsHBfQriPc1FxiTwMH01Cl5AhX2Y8pQNgLgkljSnPGxLp0tSAxBiWCIKwJjHvVwRiY9XsXKJskVbGBTesUY_Rl27daFHOlNtV1VzO_hn1ywO4NVS1KenBxIl5cTE-PPOhf6Zio8BiIn3JEkkHvdbOa5u6w_D8wre9gmPD4QCyy4aDDK2ZH6e9W_X80Ff_UQJ3LmwCsyypig0n657DQtJe6YbU16RrF2I22j84VedGO-wD-kG-ORwJNY3yJyAt5Q9k3FRRAWIDHianLgZSr33_nPvg2PQ2O4lKaru3K6rFrUwWpigSvsOzBJAivwE6KxzbvKLEm1Xq58_E-Vz7SE09ciGXOe1rxNduYWPuL_G90zDAOcvg_jbYNYv3P9m3ADXnPSn-qkCn3cEvC1xckdmsJ9gnkPr-aJbM2I_rnGbiph8jDjToW9yaQNRMHNtiBPu6bHkuKBYZ8Pc6_lBtKKZVztKedcTIPXtQ1rFCI3F5-K96cBSBBoJUUJeVyNnFVOqeLQ7OEFBa7Y4VC18sqMn-oGnkKpYYpt6rEp7QRAsSXay-TG5yMpEi5Mdlbj0Ok_QwotTi8EWvheCgY11RgY3Vjz8YJFUY4q1eIVHpDhHFslV6jri87iOZInZlr2Wzoav1UxMSObAMKDC7pXW37dA5m7uoTUbwhPR-BcK59bDoZNtUTTVy7O_4qw5oR_xTvFGJhLSrvGaHZG7g6G3QnDe4V1m1kZ2cmakO2NhUVq2qltDWSd0vA9YRCmGqdAZIJdSKMiN6XitDx1x7Mbc-hz_Vci6OAtV_h-bn0QDkbm48Ay_fwygsAfXvSkFopOksb0sPdPy238ypKxnXnjzTjwtc0URceTNLSXzocPn6qxewxxQl2-zMKoP4Q_97dvOWUifszDrG2IdAUP34azDRSStLheUF8ghQO5Qs5mIA6yuNJrY4jZ67lIxbi7703hcNfRAvE");
                return map;

            }
        };
        queue.add(stringRequest);

    }

    String url4 = "http://itec-api.deventure.co/api/Account/Register";

    public void functie_register(){

        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url4,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        //mTextView.setText("Response is: "+ response.substring(0,500));
                        Log.i("Register", response);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //mTextView.setText("That didn't work!");
            }
        });
        queue.add(stringRequest);

    }
}
