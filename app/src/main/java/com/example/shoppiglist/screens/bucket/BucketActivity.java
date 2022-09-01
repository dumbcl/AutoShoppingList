package com.example.shoppiglist.screens.bucket;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppiglist.R;
import com.example.shoppiglist.model.ShoppingList;
import com.example.shoppiglist.screens.main.MainActivity;
import com.example.shoppiglist.screens.main.MenuActivity;
import com.example.shoppiglist.screens.main.ShoppingListAdapter;
import com.example.shoppiglist.screens.main.ShoppingListCreationActivity;

public class BucketActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ShoppingListBucketAdapter shoppingListBucketAdapter;
    private BucketActivityViewModel viewModel;
    private ShoppingList shoppingList;
    private Button openMenuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bucket);


        openMenuButton = findViewById(R.id.choiceListBigButtonBucket);
        openMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BucketActivity.this, MenuActivity.class);
                intent.putExtra("from where", 2);
                startActivity(intent);
            }
        });
    }
}
