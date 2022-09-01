package com.example.shoppiglist.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.shoppiglist.model.Purchase;
import com.example.shoppiglist.model.ShoppingList;

@Database(entities = {ShoppingList.class, Purchase.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ShoppingListDao shoppingListDao();
    public abstract PurchaseDao purchaseDao();
}
