package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        //gets in parameter from second screen
        Intent intent = getIntent();
        int winner = intent.getIntExtra(SecondActivity.EXTRA_NUMV2, 0);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        //changes text and image view depending on who won
        if(winner == -1)
        {
            ImageView img = findViewById(R.id.winnerView);
            Drawable myDrawable = getResources().getDrawable(R.drawable.villain);
            img.setImageDrawable(myDrawable);
            TextView winText = findViewById(R.id.winnerText);
            winText.setText("The winner is: THE VILLAIN!!! YOU LOSE!!!");
        }//end if
        else if(winner == 1)
        {
            ImageView img = findViewById(R.id.winnerView);
            Drawable myDrawable = getResources().getDrawable(R.drawable.character1);
            img.setImageDrawable(myDrawable);
            TextView winText = findViewById(R.id.winnerText);
            winText.setText("The winner is: YOU!!! YAAAY");
        }//end first else if
        else if(winner == 2)
        {
            ImageView img = findViewById(R.id.winnerView);
            Drawable myDrawable = getResources().getDrawable(R.drawable.character2);
            img.setImageDrawable(myDrawable);
            TextView winText = findViewById(R.id.winnerText);
            winText.setText("The winner is: YOU!!! YAAAY");
        }//end second else if
        else if(winner == 3)
        {
            ImageView img = findViewById(R.id.winnerView);
            Drawable myDrawable = getResources().getDrawable(R.drawable.character3);
            img.setImageDrawable(myDrawable);
            TextView winText = findViewById(R.id.winnerText);
            winText.setText("The winner is: YOU!!! YAAAY");
        }//end third else if
        else if(winner == 4)
        {
            ImageView img = findViewById(R.id.winnerView);
            Drawable myDrawable = getResources().getDrawable(R.drawable.character4);
            img.setImageDrawable(myDrawable);
            TextView winText = findViewById(R.id.winnerText);
            winText.setText("The winner is: YOU!!! YAAAY");
        }//end fourth else if
    }//end onCreate method

    //changes back to first screen if the user replays
    public void replay(View v)
    {
        Intent intent = new Intent(ThirdActivity.this, MainActivity.class);
        startActivity(intent);
    }//end replay

}//end third activity