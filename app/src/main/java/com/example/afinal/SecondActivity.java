package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        int characterNum = intent.getIntExtra(MainActivity.EXTRA_NUM, 0);

        Toast.makeText(this, "Character num: " + characterNum, Toast.LENGTH_SHORT).show();
    }


}