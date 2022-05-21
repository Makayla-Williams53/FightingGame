package com.example.afinal;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int characterNum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }//end on create

    public void character1Click(View v)
    {
        charConfirm(1);
    }

    public void character2Click(View v)
    {
        charConfirm(2);
    }

    public void character3Click(View v)
    {
        charConfirm(3);
    }

    public void character4Click(View v)
    {
        charConfirm(4);
    }

    public void charConfirm(int num)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Confirm that you want to use character " + num);
        builder.setPositiveButton("Absolutely", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                characterNum = num;
                Toast.makeText(MainActivity.this, "Character " + num + " has been selected and confirmed", Toast.LENGTH_SHORT).show();
            }//end onClick
        });//end set positive button

        builder.setNegativeButton("Let me reconsider", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Character " + num + " has been selected and denied", Toast.LENGTH_SHORT).show();
            }//end onClick
        });//end set negative button

        AlertDialog resetDialog = builder.create();
        resetDialog.show();
    }
}