package com.example.shoppiglist.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.shoppiglist.model.ShoppingList;

import java.util.List;

@Dao
public interface ShoppingListDao {
    @Query("SELECT * FROM shoppinglist")
    List<ShoppingList> getAll();

    @Query("SELECT * FROM shoppinglist WHERE isconst = 'true'")
    List<ShoppingList> getConst();

    @Query("SELECT * FROM shoppinglist WHERE isinbucket = 'true'")
    List<ShoppingList> getInBucket();

    @Query("SELECT * FROM shoppinglist WHERE isinbucket = 'false'")
    List<ShoppingList> getNotInBucket();

//    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
//    List<User> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM shoppinglist WHERE name LIKE :name")
    ShoppingList findByName(String name);

    @Query("SELECT * FROM shoppinglist WHERE uid LIKE :uid")
    ShoppingList findById(int uid);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(ShoppingList shoppingList);

    @Update
    void update(ShoppingList shoppingList);

    @Delete
    void delete(ShoppingList shoppingList);
}
