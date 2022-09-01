package com.example.shoppiglist.screens.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppiglist.R;
import com.example.shoppiglist.model.ShoppingList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ShoppingListAdapter shoppingListAdapter;
    private MainActivityViewModel viewModel;
    private ShoppingList shoppingList;
    private Button createListButton;
    private Button openMenuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createListButton = findViewById(R.id.create_list_button);
        createListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShoppingListCreationActivity.class);
                startActivity(intent);
            }
        });

        openMenuButton = findViewById(R.id.choiceListBigButtonMain);
        openMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                intent.putExtra("from where", 1);
                startActivity(intent);
            }
        });
    }
}
