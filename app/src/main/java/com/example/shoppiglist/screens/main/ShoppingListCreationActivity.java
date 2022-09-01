package com.example.shoppiglist.screens.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.shoppiglist.R;
import com.example.shoppiglist.screens.shoppinglist.ShoppingListActivity;

public class ShoppingListCreationActivity extends AppCompatActivity {

    private Button createListButton;
    private Button cancelListCreationButton;
    private EditText createListText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list_creation);

        createListButton = findViewById(R.id.createListButton);
        cancelListCreationButton = findViewById(R.id.cancelListCreationButton);
        createListText = findViewById(R.id.createListText);

        cancelListCreationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShoppingListCreationActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        createListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShoppingListCreationActivity.this, ShoppingListActivity.class);
                String listName = createListText.getText().toString();
                intent.putExtra("list_name", listName);
                intent.putExtra("is_new",true);
                startActivity(intent);
            }
        });

    }
}
