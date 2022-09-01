package com.example.shoppiglist;

import android.app.Application;

import androidx.room.Room;

import com.example.shoppiglist.data.AppDatabase;
import com.example.shoppiglist.data.PurchaseDao;
import com.example.shoppiglist.data.ShoppingListDao;

public class App extends Application {
    private AppDatabase database;
    private PurchaseDao purchaseDao;
    private ShoppingListDao shoppingListDao;

    private static App instance;

    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(getApplicationContext(),
                        AppDatabase.class, "shopping-lists-db")
                        .allowMainThreadQueries()
                        .build();
        purchaseDao = database.purchaseDao();
        shoppingListDao = database.shoppingListDao();
    }

    public AppDatabase getDatabase() {
        return database;
    }

    public void setDatabase(AppDatabase database) {
        this.database = database;
    }

    public PurchaseDao getPurchaseDao() {
        return purchaseDao;
    }

    public void setPurchaseDao(PurchaseDao purchaseDao) {
        this.purchaseDao = purchaseDao;
    }

    public ShoppingListDao getShoppingListDao() {
        return shoppingListDao;
    }

    public void setShoppingListDao(ShoppingListDao shoppingListDao) {this.shoppingListDao = shoppingListDao;}
}
