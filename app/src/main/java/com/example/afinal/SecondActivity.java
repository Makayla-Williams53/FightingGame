package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.Thread;

public class SecondActivity extends AppCompatActivity  {

    int userHealth = 100;
    boolean userBlocking = false;
    int opponentHealth = 100;
    boolean opponentBlocking = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ImageView img = (ImageView) findViewById(R.id.userCharacterView);


        Intent intent = getIntent();
        int characterNum = intent.getIntExtra(MainActivity.EXTRA_NUM, 0);

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
        TextView current = (TextView) findViewById(R.id.currentMoveView);
        current.setText("Attack");

        //add delay in

        int rand = (int) (Math.random() * 100);
        if(rand <= 40 && opponentBlocking == false)
        {
            opponentHealth -= 15;
            TextView opponentView = (TextView)findViewById(R.id.opponentHealthView);
            opponentView.setText("Opponent Health: " + opponentHealth);
            current.setText("Your attack did 15 points of damage");
        }
        else if(opponentBlocking == true)
        {
            current.setText("Your opponent was blocking was not damaged by your attack");
        }
        else
        {
            current.setText("Your opponent dodged the attack");
        }

        opponentBlocking = false;
        //add delay in
        //add opponent move in
    }

    public void specialClick(View v)
    {
        TextView current = (TextView) findViewById(R.id.currentMoveView);
        current.setText("Special Attack");

        //add delay in

        int rand = (int)(Math.random() * 100);
        if(rand <= 30 && opponentBlocking == false)
        {
            opponentHealth -= 25;
            TextView opponentView = (TextView)findViewById(R.id.opponentHealthView);
            opponentView.setText("Opponent Health: " + opponentHealth);
            current.setText("Your special attack did 25 points of damage");
        }
        else if(opponentBlocking == true)
        {
            opponentHealth -= 10;
            TextView opponentView = (TextView)findViewById(R.id.opponentHealthView);
            opponentView.setText("Opponent Health: " + opponentHealth);
            current.setText("Your opponent was blocking so your special attack did 10 points of damage");
        }
        else
        {
            current.setText("Your opponent dodged the attack");
        }

        opponentBlocking = false;
        //add delay in
        //add opponent move in
    }

    public void blockClick(View v)
    {
        Toast.makeText(this, "The block button has been clicked", Toast.LENGTH_SHORT).show();
    }
}



//Code for how to set imageView image from https://docs.microsoft.com/en-us/dotnet/api/android.widget.imageview.setimagedrawable?view=xamarin-android-sdk-12
//Code for sleep timer from https://www.javatpoint.com/thread-sleep-in-java