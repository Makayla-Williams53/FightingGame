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

import org.w3c.dom.Text;

import java.lang.Thread;

public class SecondActivity extends AppCompatActivity
{
    public static final String EXTRA_NUM = "com.example.example.EXTRA_NUMBER";

    int characterNum;

    int userHealth = 100;
    boolean userBlocking = false;
    int opponentHealth = 15;
    boolean opponentBlocking = false;
    boolean userTurn = true;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        Intent intent = getIntent();
        characterNum = intent.getIntExtra(MainActivity.EXTRA_NUM, 0);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ImageView img = findViewById(R.id.userCharacterView);

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
        test();

        if(userTurn)
        {
            userTurn = false;
            TextView current = findViewById(R.id.currentMoveView);
            current.setText("You attack");

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
                    if(rand <= 60 && opponentBlocking == false)
                    {
                        opponentHealth -= 15;
                        TextView opponentView = findViewById(R.id.opponentHealthView);
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
                    }, 2000); //end inner postDelayed method

                }//end outer run method
                //insert the amount of time delayed
            }, 4000);//end outer postDelayed method
        }//end userTurn if
    }//end attackClick method

    public void specialClick(View v)
    {
        test();

        if(userTurn)
        {
            userTurn = false;
            TextView current = findViewById(R.id.currentMoveView);
            current.setText("Special Attack");

            Handler handler = new Handler();
            handler.postDelayed(new Runnable()
            {
                @Override
                public void run()
                {
                    int rand = (int)(Math.random() * 100);
                    if(rand <= 50 && opponentBlocking == false)
                    {
                        opponentHealth -= 25;
                        TextView opponentView = findViewById(R.id.opponentHealthView);
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
                    }, 2000); //end inner postDelayed

                }//end outer run
            }, 4000);//end outer postDelayed
        }//end userTurn if
    }//end specialClick

    public void blockClick(View v)
    {
        test();

        if(userTurn)
        {
            userTurn = false;
            userBlocking = true;
            TextView current = (TextView) findViewById(R.id.currentMoveView);
            current.setText("You are blocking, preparing for your opponent's next move");

            Handler handler = new Handler();
            handler.postDelayed(new Runnable()
            {
                @Override
                public void run()
                {
                    opponentMove();
                }//end run
            }, 4000); //end postDelayed
        }//end userTurn if
    }//end blockClick

    public void opponentMove()
    {
        test();

        TextView current = (TextView) findViewById(R.id.currentMoveView);
        current.setText("Opponent's move");

        Handler handler = new Handler();
        handler.postDelayed(new Runnable()
        {
            @Override
            public void run()
            {

                int rand = (int) ((Math.random() * 10) + 1);
                while(rand != 1 && rand != 2 && rand != 3)
                {
                    rand = (int) ((Math.random() * 10) + 1);
                }

                if(rand == 1)
                {
                    //opponent attacking
                    current.setText("Opponent Attacks");

                    //creates object that will allow for the delayed code
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            int rand = (int) (Math.random() * 100);
                            if(rand <= 60 && userBlocking == false)
                            {
                                userHealth -= 15;
                                TextView userView = (TextView) findViewById(R.id.userHealthView);
                                userView.setText("User Health: " + userHealth);
                                current.setText("The opponents attack did 15 points of damage");
                            }//end if
                            else if(userBlocking){
                                current.setText("You were blocking so you were not damaged by their attack.");
                            }//end else if
                            else
                            {
                                current.setText("You dodged the attack");
                            }//end else
                        }//end run method
                    }, 4000); //end postDelay method
                }//end if
                else if(rand == 2)
                {
                    //opponent special attack
                    current.setText("Opponent Special Attack");

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            int rand = (int)(Math.random() * 100);
                            if(rand <= 50 && userBlocking == false)
                            {
                                userHealth -= 25;
                                TextView userView = (TextView)findViewById(R.id.userHealthView);
                                userView.setText("User Health: " + userHealth);
                                current.setText("Their special attack did 25 points of damage");
                            }//end if
                            else if(userBlocking == true)
                            {
                                opponentHealth -= 15;
                                TextView userView = (TextView)findViewById(R.id.userHealthView);
                                userView.setText("User Health: " + userHealth);
                                current.setText("You were blocking so their special attack did less damage");
                            }//end else if
                            else
                            {
                                current.setText("You dodged the special attack");
                            }//end else

                            userBlocking = false;

                        }//end run method
                    }, 4000);//end post delay method
                }//end outer else if
                else
                {
                    opponentBlocking = true;
                    current.setText("Your opponent is blocking, preparing for your attack");
                }//end else
            }//end runnable
        }, 3000); //end postDelayed method

        handler.postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                current.setText("Your Move");
                userTurn = true;
            }//end run method
        }, 10000); //end postDelayed method
    }//end opponentMove

    public void test()
    {
        if(userHealth <= 0)
        {
            Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
            intent.putExtra(EXTRA_NUM, -1);
            startActivity(intent);
        }//end if
        else if(opponentHealth <= 0)
        {
            Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
            intent.putExtra(EXTRA_NUM, characterNum);
            startActivity(intent);
        }//end else if
    }//end test method


}//end secondActivity class

//Code for how to set imageView image from https://docs.microsoft.com/en-us/dotnet/api/android.widget.imageview.setimagedrawable?view=xamarin-android-sdk-12
//Code for sleep timer from https://docs.microsoft.com/en-us/dotnet/api/android.os.handler.postdelayed?view=xamarin-android-sdk-12