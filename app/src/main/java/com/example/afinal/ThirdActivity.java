package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ThirdActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        //gets in parameter from second screen
        Intent intent = getIntent();
        int winner = intent.getIntExtra(SecondActivity.EXTRA_NUMV2, 0);
        ArrayList<Integer> moves = (ArrayList<Integer>) intent.getSerializableExtra("key");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        //changes text and image view depending on who won
        if(winner == -1)
        {
            ImageView img = findViewById(R.id.winnerView);
            Drawable myDrawable = getResources().getDrawable(R.drawable.villain);
            img.setImageDrawable(myDrawable);
            TextView winText = findViewById(R.id.winnerText);
            winText.setText("The winner is: THE VILLAIN!!!!");
        }//end if
        else if(winner == 1)
        {
            ImageView img = findViewById(R.id.winnerView);
            Drawable myDrawable = getResources().getDrawable(R.drawable.character1);
            img.setImageDrawable(myDrawable);
            TextView winText = findViewById(R.id.winnerText);
            winText.setText("The winner is: YOU!!!");
        }//end first else if
        else if(winner == 2)
        {
            ImageView img = findViewById(R.id.winnerView);
            Drawable myDrawable = getResources().getDrawable(R.drawable.character2);
            img.setImageDrawable(myDrawable);
            TextView winText = findViewById(R.id.winnerText);
            winText.setText("The winner is: YOU!!!");
        }//end second else if
        else if(winner == 3)
        {
            ImageView img = findViewById(R.id.winnerView);
            Drawable myDrawable = getResources().getDrawable(R.drawable.character3);
            img.setImageDrawable(myDrawable);
            TextView winText = findViewById(R.id.winnerText);
            winText.setText("The winner is: YOU!!!");
        }//end third else if
        else if(winner == 4)
        {
            ImageView img = findViewById(R.id.winnerView);
            Drawable myDrawable = getResources().getDrawable(R.drawable.character4);
            img.setImageDrawable(myDrawable);
            TextView winText = findViewById(R.id.winnerText);
            winText.setText("The winner is: YOU!!!");
        }//end fourth else if

        //creates game overviews through the array passed through
        //based on which numbers were inserted the number in the ten's place
        //determines who did what move and the number in the one's place
        //determines if it worked and how so
        String output = "";
        for(int i = 0; i < moves.size(); i++)
        {
            if(moves.get(i) / 10 == 1)
            {
                if(moves.get(i) % 10 == 1)
                {
                    output += "You attack and it does 15 points of damage\n";
                }//end inner if
                else if(moves.get(i) % 10 == 2)
                {
                    output += "You attack but the villain is blocking\n";
                }//end inner else if
                else
                {
                    output += "You attack but the villain dodged\n";
                }//end inner else
            }//end first outer if
            else if(moves.get(i) / 10 == 2)
            {
                if(moves.get(i) % 10 == 1)
                {
                    output += "You special attack and it does 25 points of damage\n";
                }//end inner if
                else if(moves.get(i) % 10 == 2)
                {
                    output += "You special attack but its blocked and does 10 points of damage\n";
                }//end inner else if
                else
                {
                    output += "You special attack but the villain dodged\n";
                }//end inner else
            }//end second outer if
            else if(moves.get(i) / 10 == 3)
            {
                if(moves.get(i) % 10 == 1)
                {
                    output += "You blocked\n";
                }//end inner if
            }//end third outer if
            else if(moves.get(i) / 10 == 4)
            {
                if(moves.get(i) % 10 == 1)
                {
                    output += "The villain attacks and it does 15 points of damage\n";
                }//end inner if
                else if(moves.get(i) % 10 == 2)
                {
                    output += "The villain attacks but you blocked\n";
                }//end inner else if
                else
                {
                    output += "The villain attacks but you dodged\n";
                }//end inner else
            }//end outer fourth if
            else if(moves.get(i) / 10 == 5)
            {
                if(moves.get(i) % 10 == 1)
                {
                    output += "The villain special attack and it does 25 points of damage\n";
                }//end inner if
                else if(moves.get(i) % 10 == 2)
                {
                    output += "The villain special attacks but you block and it does 10 points of damage\n";
                }//end inner else if
                else
                {
                    output += "The villain special attacks but you dodged\n";
                }//end inner else
            }//end outer fifth if
            else
            {
                output += "The villain blocked\n";
            }//end outer else
        }//end for loop

        //changes text view and enables scroll bar
        TextView gameText = findViewById(R.id.gameView);
        gameText.setMovementMethod(new ScrollingMovementMethod());
        gameText.setText(output);
    }//end onCreate method

    //changes back to first screen if the user replays
    public void replay(View v)
    {
        Intent intent = new Intent(ThirdActivity.this, MainActivity.class);
        startActivity(intent);
    }//end replay

}//end third activity

//code for the scrollable text view from https://youtu.be/aZPsgEcCkkc