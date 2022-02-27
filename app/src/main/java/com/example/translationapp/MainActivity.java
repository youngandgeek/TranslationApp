package com.example.translationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//Numbers Intent
        TextView number=(TextView) findViewById(R.id.numbers);

        number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent numberIntent=new Intent(MainActivity.this,NumberActivity.class);
                startActivity(numberIntent);

            }
        });


        //Family Members Intent
        TextView familyMembers=(TextView) findViewById(R.id.family);

        familyMembers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent familyIntent=new Intent(MainActivity.this,FamilyMembersActivity.class);
                startActivity(familyIntent);

            }
        });
        //Colors Intent
        TextView color=(TextView) findViewById(R.id.colors);

        color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent colorsIntent=new Intent(MainActivity.this,ColorsActivity.class);
                startActivity(colorsIntent);
            }


        });


//Phrases Intent
        TextView phrase=(TextView) findViewById(R.id.phrases);

        phrase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent phrasesIntent=new Intent(MainActivity.this,PhrasesActivity.class);
                startActivity(phrasesIntent);

            }


        });




    }




/*
  * we can use onClick method or setOnClickListener

    public void openNumbersList(View view) {
        Intent numberIntent=new Intent(this,NumberActivity.class);
        startActivity(numberIntent);

    }

    public void openFamilyList(View view) {
        Intent familyIntent=new Intent(this,FamilyMembersActivity.class);
        startActivity(familyIntent);
    }

    public void openColorsList(View view) {
        Intent colorsIntent=new Intent(this,ColorsActivity.class);
        startActivity(colorsIntent);
    }

    public void openPhrasesList(View view) {
        Intent phrasesIntent=new Intent(this,PhrasesActivity.class);
        startActivity(phrasesIntent);
    }

    */



}