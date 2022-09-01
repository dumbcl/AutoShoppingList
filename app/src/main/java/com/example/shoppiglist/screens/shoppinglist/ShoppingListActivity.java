package com.example.shoppiglist.screens.shoppinglist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppiglist.R;
import com.example.shoppiglist.model.Purchase;
import com.example.shoppiglist.model.ShoppingList;
import com.example.shoppiglist.screens.main.MainActivity;
import com.example.shoppiglist.screens.main.MainActivityViewModel;
import com.example.shoppiglist.screens.main.ShoppingListAdapter;
import com.example.shoppiglist.screens.main.ShoppingListCreationActivity;
import com.example.shoppiglist.screens.purchasesselection.AddingPurchasesActivity;

public class ShoppingListActivity extends AppCompatActivity {

    private Button backToMainButton;
    private Button listActionsButton;
    private Button addPurchaseButton;
    private ShoppingList shoppingList;
    private Purchase purchase;
    private RecyclerView recyclerView;
    private PurchasesInShoppingListAdapter shoppingListAdapter;
    private ShoppingListActivityViewModel viewModel;
    private TextView listName;
    private TextView emptyListText;
    private View listFullnessView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);

        backToMainButton = findViewById(R.id.backToMainButton);
        backToMainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShoppingListActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        listActionsButton = findViewById(R.id.listActionsButton);
        listActionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogListActionsIn();
            }
        });

        addPurchaseButton = findViewById(R.id.add_purchase_button);
        addPurchaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShoppingListActivity.this, AddingPurchasesActivity.class);
                startActivity(intent);
            }
        });

        listName = findViewById(R.id.listName);
        if (getIntent().getStringExtra("list_name").equals("")) listName.setText("Новый список");
        else listName.setText(getIntent().getStringExtra("list_name"));

        emptyListText = findViewById(R.id.emptyListText);


        listFullnessView = findViewById(R.id.listFullnessView);
    }

    private void showDialogListActionsIn() {
        AlertDialog dialogBuilder = new AlertDialog.Builder(this).create();
        View dialogView = getLayoutInflater().inflate( R.layout.dialog_list_actions_in, null);
        Button markAllButton = dialogView.findViewById(R.id.markAllButton);
        Button unmarkAllButton = dialogView.findViewById(R.id.unmarkAllButton);
        Button deleteBoughtButton = dialogView.findViewById(R.id.deleteBoughtButton);
        Button deleteAllButton = dialogView.findViewById(R.id.deleteAllButton);

        markAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        unmarkAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        deleteBoughtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        deleteAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        dialogBuilder.setView(dialogView);
        dialogBuilder.show();
    }
}
