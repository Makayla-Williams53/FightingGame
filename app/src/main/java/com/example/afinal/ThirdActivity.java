package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        ImageView img = findViewById(R.id.userCharacterView);

        TextView winText = findViewById(R.id.winnerText);

        Intent intent = getIntent();
        int winner = intent.getIntExtra(MainActivity.EXTRA_NUM, 0);

        if(winner == -1)
        {
            Drawable myDrawable = getResources().getDrawable(R.drawable.villain);
            img.setImageDrawable(myDrawable);
            winText.setText("The winner is THE VILLAIN!!! YOU LOSE");
        }
        else if(winner == 1)
        {
            Drawable myDrawable = getResources().getDrawable(R.drawable.character1);
            img.setImageDrawable(myDrawable);
            winText.setText("The winner is YOU!!! YAAAY");
        }
        else if(winner == 2)
        {
            Drawable myDrawable = getResources().getDrawable(R.drawable.character2);
            img.setImageDrawable(myDrawable);
            winText.setText("The winner is YOU!!! YAAAY");
        }
        else if(winner == 3)
        {
            Drawable myDrawable = getResources().getDrawable(R.drawable.character3);
            img.setImageDrawable(myDrawable);
            winText.setText("The winner is YOU!!! YAAAY");
        }
        else if(winner == 4) {
            Drawable myDrawable = getResources().getDrawable(R.drawable.character4);
            img.setImageDrawable(myDrawable);
            winText.setText("The winner is YOU!!! YAAAY");
        }
    }

    public void replay()
    {
        Intent intent = new Intent(ThirdActivity.this, MainActivity.class);
        startActivity(intent);
    }
}