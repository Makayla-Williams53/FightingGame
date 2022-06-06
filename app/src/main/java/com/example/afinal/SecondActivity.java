package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity
{
    //used to pass parameter to next screen
    public static final String EXTRA_NUMV2 = "com.example.example.EXTRA_NUMBER";

    //character variables
    int characterNum;
    int userHealth = 100;
    boolean userBlocking = false;
    int opponentHealth = 100;
    boolean opponentBlocking = false;
    boolean userTurn = true;

    //Arraylist to hold each move
    ArrayList<Integer> moves = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        //gets parameter from previous screen
        Intent intent = getIntent();
        characterNum = intent.getIntExtra(MainActivity.EXTRA_NUM, 0);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ImageView img = findViewById(R.id.userCharacterView);

        //sets user character image
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

    //user attack method
    public void attackClick(View v)
    {
        //test if a character or opponent has zero health
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
                    //creates random num to see if attack worked
                    int rand = (int) (Math.random() * 100);
                    if(rand <= 60 && opponentBlocking == false)
                    {
                        //changes opponent health and text view
                        opponentHealth -= 15;
                        TextView opponentView = findViewById(R.id.opponentHealthView);
                        opponentView.setText("Opponent Health: " + opponentHealth);
                        current.setText("Your attack did 15 points of damage");
                        //adds in the move that just happened to the arraylist
                        moves.add(11);
                    }//end if
                    else if(opponentBlocking == true)
                    {
                        current.setText("Your opponent was blocking was not damaged by your attack");
                        //adds in the move that just happened to the arraylist
                        moves.add(12);
                    }//end else if
                    else
                    {
                        current.setText("Your opponent dodged the attack");
                        //adds in the move that just happened to the arraylist
                        moves.add(13);
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

    //user special attack method
    public void specialClick(View v)
    {
        //tests to see if character or opponent has zero health
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
                    //creates random num to see if attack worked
                    int rand = (int)(Math.random() * 100);
                    if(rand <= 50 && opponentBlocking == false)
                    {
                        //changes opponent health and text screen
                        opponentHealth -= 25;
                        TextView opponentView = findViewById(R.id.opponentHealthView);
                        opponentView.setText("Opponent Health: " + opponentHealth);
                        current.setText("Your special attack did 25 points of damage");
                        moves.add(21);
                    }//end if
                    else if(opponentBlocking == true)
                    {
                        opponentHealth -= 10;
                        TextView opponentView = findViewById(R.id.opponentHealthView);
                        opponentView.setText("Opponent Health: " + opponentHealth);
                        current.setText("Your opponent was blocking so your special attack did 10 points of damage");
                        moves.add(22);
                    }//end else if
                    else
                    {
                        current.setText("Your opponent dodged the attack");
                        moves.add(23);
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

    //user block method
    public void blockClick(View v)
    {
        //tests if character or opponent has zero health
        test();

        if(userTurn)
        {
            userTurn = false;
            userBlocking = true;
            opponentBlocking = false;
            TextView current = findViewById(R.id.currentMoveView);
            current.setText("You are blocking, preparing for your opponent's next move");
            moves.add(31);

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

    //opponent move method
    public void opponentMove()
    {
        //tests to see if character or opponent has zero health
        test();

        TextView current = findViewById(R.id.currentMoveView);
        current.setText("Opponent's move");

        Handler handler = new Handler();
        handler.postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                //creates random number to select opponent move
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
                            //creates random num to see if attack worked
                            int rand = (int) (Math.random() * 100);
                            if(rand <= 60 && userBlocking == false)
                            {
                                //changes user health and text view
                                userHealth -= 15;
                                TextView userView = findViewById(R.id.userHealthView);
                                userView.setText("User Health: " + userHealth);
                                current.setText("The opponents attack did 15 points of damage");
                                moves.add(41);
                            }//end if
                            else if(userBlocking){
                                current.setText("You were blocking so you were not damaged by their attack.");
                                moves.add(42);
                            }//end else if
                            else
                            {
                                current.setText("You dodged the attack");
                                moves.add(43);
                            }//end else

                            userBlocking = false;
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
                            //creates random num to see if attack worked
                            int rand = (int)(Math.random() * 100);
                            if(rand <= 40 && userBlocking == false)
                            {
                                //changes user health and text view
                                userHealth -= 25;
                                TextView userView = findViewById(R.id.userHealthView);
                                userView.setText("User Health: " + userHealth);
                                current.setText("Their special attack did 25 points of damage");
                                moves.add(51);
                            }//end if
                            else if(userBlocking == true)
                            {
                                userHealth -= 15;
                                TextView userView = findViewById(R.id.userHealthView);
                                userView.setText("User Health: " + userHealth);
                                current.setText("You were blocking so their special attack did less damage");
                                moves.add(52);
                            }//end else if
                            else
                            {
                                current.setText("You dodged the special attack");
                                moves.add(53);
                            }//end else

                            userBlocking = false;

                        }//end run method
                    }, 4000);//end post delay method

                }//end outer else if
                else
                {
                    opponentBlocking = true;
                    userBlocking = false;
                    current.setText("Your opponent is blocking, preparing for your attack");
                    moves.add(61);
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
            //goes to third screen passing in that the villain won
            Intent intent2 = new Intent(SecondActivity.this, ThirdActivity.class);
            intent2.putExtra(EXTRA_NUMV2, -1);
            intent2.putExtra("key", moves);
            startActivity(intent2);
        }//end if
        else if(opponentHealth <= 0)
        {
            //goes to third screen passing in that the her won and the character num
            Intent intent2 = new Intent(SecondActivity.this, ThirdActivity.class);
            intent2.putExtra(EXTRA_NUMV2, characterNum);
            intent2.putExtra("key", moves);
            startActivity(intent2);
        }//end else if
    }//end test method

}//end secondActivity class

//Code for how to set imageView image from https://docs.microsoft.com/en-us/dotnet/api/android.widget.imageview.setimagedrawable?view=xamarin-android-sdk-12
//Code for sleep timer from https://docs.microsoft.com/en-us/dotnet/api/android.os.handler.postdelayed?view=xamarin-android-sdk-12