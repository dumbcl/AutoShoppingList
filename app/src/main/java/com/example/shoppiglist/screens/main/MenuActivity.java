package com.example.shoppiglist.screens.main;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.shoppiglist.R;
import com.example.shoppiglist.screens.bucket.BucketActivity;

public class MenuActivity extends AppCompatActivity {

    private Button toBackButton;
    private Button toListsButton;
    private Button toBucketButton;
    private int fromWhere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        fromWhere = getIntent().getIntExtra("from where", 0);

        Drawable chosenLists = getDrawable(R.drawable.chosen_lists_button);
        Drawable unchosenLists = getDrawable(R.drawable.unchosen_lists_button);
        Drawable chosenBucket = getDrawable(R.drawable.chosen_bucket_button);
        Drawable unchosenBucket = getDrawable(R.drawable.unchosen_bucket_button);

        toListsButton = findViewById(R.id.tolistsbutton);
        toBucketButton = findViewById(R.id.tobucketbutton);
        if (fromWhere == 1) {toListsButton.setBackground(chosenLists); toBucketButton.setBackground(unchosenBucket);}
        else {toListsButton.setBackground(unchosenLists); toBucketButton.setBackground(chosenBucket);}

        toListsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        toBucketButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, BucketActivity.class);
                startActivity(intent);
            }
        });

        toBackButton = findViewById(R.id.tothemainbutton);
        toBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MenuActivity.this, MainActivity.class);
                Intent intent2 = new Intent(MenuActivity.this, BucketActivity.class);
                if (fromWhere == 1) startActivity(intent1); else startActivity(intent2);
            }
        });
    }
}
