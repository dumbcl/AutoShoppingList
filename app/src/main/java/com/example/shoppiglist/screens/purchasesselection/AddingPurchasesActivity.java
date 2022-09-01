package com.example.shoppiglist.screens.purchasesselection;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppiglist.R;
import com.example.shoppiglist.model.Purchase;
import com.example.shoppiglist.model.ShoppingList;
import com.example.shoppiglist.screens.shoppinglist.PurchasesInShoppingListAdapter;
import com.example.shoppiglist.screens.shoppinglist.ShoppingListActivity;
import com.example.shoppiglist.screens.shoppinglist.ShoppingListActivityViewModel;

public class AddingPurchasesActivity extends AppCompatActivity {

    private Button backToListButton;
    private Button constPurchButton;
    private Button allPurchButton;
    private Button addCompletelyNewPurchaseButton;
    private ShoppingList shoppingList;
    private Purchase purchase;
    private RecyclerView recyclerView;
    private PurchaseToAddAdapter shoppingListAdapter;
    private AddingPurchasesActivityViewModel viewModel;
    private View inConstPurchView;
    private View inAllPurchView;
    private View outConstPurchView;
    private View outAllPurchView;
    private EditText purchaseName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_purchases);

        inConstPurchView = findViewById(R.id.inConstPurchView);
        inAllPurchView = findViewById(R.id.inAllPurchView);
        outConstPurchView = findViewById(R.id.outConstPurchView);
        outAllPurchView = findViewById(R.id.outAllPurchView);

        backToListButton = findViewById(R.id.backToListButton);
        backToListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddingPurchasesActivity.this, ShoppingListActivity.class);
                startActivity(intent);
            }
        });

        addCompletelyNewPurchaseButton = findViewById(R.id.addCompletelyNewPurchaseButton);
        addCompletelyNewPurchaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        constPurchButton = findViewById(R.id.constPurchButton);
        constPurchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inConstPurchView.setVisibility(View.VISIBLE);
                outConstPurchView.setVisibility(View.INVISIBLE);
                inAllPurchView.setVisibility(View.INVISIBLE);
                outAllPurchView.setVisibility(View.VISIBLE);
            }
        });

        allPurchButton = findViewById(R.id.allPurchButton);
        allPurchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inConstPurchView.setVisibility(View.INVISIBLE);
                outConstPurchView.setVisibility(View.VISIBLE);
                inAllPurchView.setVisibility(View.VISIBLE);
                outAllPurchView.setVisibility(View.INVISIBLE);
            }
        });
    }
}
