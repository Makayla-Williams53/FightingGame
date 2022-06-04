package com.example.afinal;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    //used to pass parameters to next screen
    public static final String EXTRA_NUM = "com.example.example.EXTRA_NUMBER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }//end on create

    //character selections
    public void character1Click(View v)
    {
        charConfirm(1, EXTRA_NUM);
    }//end character1Click

    public void character2Click(View v)
    {
        charConfirm(2, EXTRA_NUM);
    }//end character2Click

    public void character3Click(View v)
    {
        charConfirm(3, EXTRA_NUM);
    }//end character3Click

    public void character4Click(View v)
    {
        charConfirm(4, EXTRA_NUM);
    }//end character4Click

    //pop up for confirmation
    public void charConfirm(int num, String EXTRA_NUM)
    {
        //create dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Confirm that you want to use character " + num);
        builder.setPositiveButton("Absolutely", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //switches the next screen and passes in the characterNum
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra(EXTRA_NUM, num);
                startActivity(intent);
            }//end onClick
        });//end set positive button

        builder.setNegativeButton("mmm no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //class is empty because the dialog just needs to disappear
            }//end onClick
        });//end set negative button

        AlertDialog resetDialog = builder.create();
        resetDialog.show();
    }//end charConfirm method

}//end Main activity method

//code for how to pass in extra variables to next activity from https://www.youtube.com/watch?v=eL69kj-_Wvs