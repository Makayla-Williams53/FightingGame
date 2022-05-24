package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.Thread;

public class SecondActivity extends AppCompatActivity
{
    int userHealth = 100;
    boolean userBlocking = false;
    int opponentHealth = 100;
    boolean opponentBlocking = false;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ImageView img = (ImageView) findViewById(R.id.userCharacterView);


        Intent intent = getIntent();
        int characterNum = intent.getIntExtra(MainActivity.EXTRA_NUM, 0);

        if(characterNum == 1)
        {
            Drawable myDrawable = getResources().getDrawable(R.drawable.character1);
            img.setImageDrawable(myDrawable);
        }//end if
        else if(characterNum == 2)
        {
            Drawable myDrawable = getResources().getDrawable(R.drawable.character2);
            img.setImageDrawable(myDrawable);
        }//end first else if
        else if(characterNum == 3)
        {
            Drawable myDrawable = getResources().getDrawable(R.drawable.character3);
            img.setImageDrawable(myDrawable);
        }//end second else if
        else if(characterNum == 4)
        {
            Drawable myDrawable = getResources().getDrawable(R.drawable.character4);
            img.setImageDrawable(myDrawable);
        }//end third else if

    }//end onCreate

    public void attackClick(View v)
    {
        TextView current = (TextView) findViewById(R.id.currentMoveView);
        current.setText("Attack");

        //creates object that will allow for the delayed code
        Handler handler = new Handler();

        //calls postDelayed method
        handler.postDelayed(new Runnable()
        {
            //creates a runnable object which is all the code that will run after the time limit is up
            @Override
            public void run()
            {
                int rand = (int) (Math.random() * 100);
                if(rand <= 40 && opponentBlocking == false)
                {
                    opponentHealth -= 15;
                    TextView opponentView = (TextView)findViewById(R.id.opponentHealthView);
                    opponentView.setText("Opponent Health: " + opponentHealth);
                    current.setText("Your attack did 15 points of damage");
                }//end if
                else if(opponentBlocking == true)
                {
                    current.setText("Your opponent was blocking was not damaged by your attack");
                }//end else if
                else
                {
                    current.setText("Your opponent dodged the attack");
                }//end else

                opponentBlocking = false;

                handler.postDelayed(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        opponentMove();
                    }//end inner run method
                }, 5000); //end inner postDelayed method

            }//end outer run method
            //insert the amount of time delayed
        }, 5000);//end outer postDelayed method

    }//end attackClick method

    public void specialClick(View v)
    {
        TextView current = (TextView) findViewById(R.id.currentMoveView);
        current.setText("Special Attack");

        Handler handler = new Handler();

        handler.postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                int rand = (int)(Math.random() * 100);
                if(rand <= 30 && opponentBlocking == false)
                {
                    opponentHealth -= 25;
                    TextView opponentView = (TextView)findViewById(R.id.opponentHealthView);
                    opponentView.setText("Opponent Health: " + opponentHealth);
                    current.setText("Your special attack did 25 points of damage");
                }//end if
                else if(opponentBlocking == true)
                {
                    opponentHealth -= 10;
                    TextView opponentView = (TextView)findViewById(R.id.opponentHealthView);
                    opponentView.setText("Opponent Health: " + opponentHealth);
                    current.setText("Your opponent was blocking so your special attack did 10 points of damage");
                }//end else if
                else
                {
                    current.setText("Your opponent dodged the attack");
                }//end else

                opponentBlocking = false;

                handler.postDelayed(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        opponentMove();
                    }//end inner run
                }, 5000); //end inner postDelayed

            }//end outer run
        }, 5000);//end outer postDelayed

    }//end specialClick

    public void blockClick(View v)
    {
        userBlocking = true;

        Handler handler = new Handler();
        handler.postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                opponentMove();
            }//end run
        }, 5000); //end postDelayed

    }//end blockClick

    public void opponentMove()
    {
        Toast.makeText(this, "opponent's turn", Toast.LENGTH_SHORT).show();
    }//end opponentMove

}//end secondActivity class

//Code for how to set imageView image from https://docs.microsoft.com/en-us/dotnet/api/android.widget.imageview.setimagedrawable?view=xamarin-android-sdk-12
//Code for sleep timer from https://docs.microsoft.com/en-us/dotnet/api/android.os.handler.postdelayed?view=xamarin-android-sdk-12