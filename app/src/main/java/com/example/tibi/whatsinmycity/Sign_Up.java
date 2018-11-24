package com.example.tibi.whatsinmycity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Sign_Up extends AppCompatActivity
{

    Button btn;
    Spinner spin,spin1;
    String[] gender = new String[]{" ","Male","Female"};
    String[] orase = new String[]{" ","Constanta", "Coming soon..."};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign__up);
        spin = (Spinner)findViewById(R.id.simpleSpinner);
        spin1 = (Spinner)findViewById(R.id.simpleSpinner1);
        btn  = (Button)findViewById(R.id.button);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,gender);
        ArrayAdapter<String> adapter_2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,orase);
        spin.setAdapter(adapter);
        spin1.setAdapter(adapter_2);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                spin.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }
        });
        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                spin1.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }
        });
        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent  =  new Intent(Sign_Up.this, Successfully_Registered.class);
                startActivity(intent);
            }
        });
    }
}
