package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void character1Click(View v)
    {
        Toast.makeText(this, "You clicked character 1", Toast.LENGTH_SHORT).show();
    }

    public void character2Click(View v)
    {
        Toast.makeText(this, "You clicked character 2", Toast.LENGTH_SHORT).show();
    }

    public void character3Click(View v)
    {
        Toast.makeText(this, "You clicked character 3", Toast.LENGTH_SHORT).show();
    }

    public void character4Click(View v)
    {
        Toast.makeText(this, "You clicked character 4", Toast.LENGTH_SHORT).show();
    }
}