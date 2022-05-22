package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ImageView img = (ImageView) findViewById(R.id.userCharacterView);


        Intent intent = getIntent();
        int characterNum = intent.getIntExtra(MainActivity.EXTRA_NUM, 0);

        Toast.makeText(this, "Character num: " + characterNum, Toast.LENGTH_SHORT).show();

        if(characterNum == 1)
        {
            Drawable myDrawable = getResources().getDrawable(R.drawable.character1);
            img.setImageDrawable(myDrawable);
        }
        else if(characterNum == 2)
        {
            Drawable myDrawable = getResources().getDrawable(R.drawable.character2);
            img.setImageDrawable(myDrawable);
        }
        else if(characterNum == 3)
        {
            Drawable myDrawable = getResources().getDrawable(R.drawable.character3);
            img.setImageDrawable(myDrawable);
        }
        else if(characterNum == 4)
        {
            Drawable myDrawable = getResources().getDrawable(R.drawable.character4);
            img.setImageDrawable(myDrawable);
        }

    }

    public void attackClick(View v)
    {
        Toast.makeText(this, "The attack button has been clicked", Toast.LENGTH_SHORT).show();
    }

    public void specialClick(View v)
    {
        Toast.makeText(this, "The special button has been clicked", Toast.LENGTH_SHORT).show();
    }

    public void blockClick(View v)
    {
        Toast.makeText(this, "The block button has been clicked", Toast.LENGTH_SHORT).show();
    }

}

//Code for how to set imageView image from https://docs.microsoft.com/en-us/dotnet/api/android.widget.imageview.setimagedrawable?view=xamarin-android-sdk-12
