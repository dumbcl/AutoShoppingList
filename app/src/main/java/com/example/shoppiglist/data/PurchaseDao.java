package com.example.shoppiglist.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.shoppiglist.model.Purchase;

import java.util.List;

@Dao
public interface PurchaseDao {

    @Query("SELECT * FROM purchase")
    List<Purchase> getAll();

    @Query("SELECT * FROM purchase WHERE shoppinglistid LIKE :shoppinglistid")
    List<Purchase> getByShoppingListId(int shoppinglistid);

    @Query("SELECT * FROM purchase WHERE shoppinglistid LIKE :shoppinglistid AND isbought = 'true'")
    List<Purchase> getByShoppingListIdAndIsBought(int shoppinglistid);

    @Query("SELECT * FROM purchase WHERE shoppinglistid LIKE :shoppinglistid AND isbought = 'false'")
    List<Purchase> getByShoppingListIdAndIsntBought(int shoppinglistid);

    @Query("SELECT * FROM purchase WHERE shoppinglistid LIKE :shoppinglistid AND isconst = 'true'")
    List<Purchase> getByShoppingListIdAndIsConst(int shoppinglistid);

    @Query("SELECT * FROM purchase WHERE shoppinglistid LIKE :shoppinglistid AND isconst = 'false'")
    List<Purchase> getByShoppingListIdAndIsntConst(int shoppinglistid);

    @Query("SELECT * FROM purchase WHERE isconst = 'true'")
    List<Purchase> getIsConst();

    @Query("SELECT * FROM purchase WHERE isconst = 'false'")
    List<Purchase> getIsntConst();

    @Query("SELECT * FROM purchase WHERE lastusingtime+averageusingtime-averageusingtime*0.2<:currenttime")
    List<Purchase> getIsTime(long currenttime);

    @Query("SELECT * FROM purchase WHERE isconst = 'true' AND lastusingtime+averageusingtime-averageusingtime*0.2<:currenttime")
    List<Purchase> getIsConstAndIsTime(long currenttime);

    @Query("SELECT * FROM purchase WHERE shoppinglistid LIKE :shoppinglistid AND lastusingtime+averageusingtime-averageusingtime*0.2<:currenttime")
    List<Purchase> getByShoppingListAndIsTime(int shoppinglistid, long currenttime);

    @Query("SELECT * FROM purchase WHERE shoppinglistid LIKE :shoppinglistid AND lastusingtime+averageusingtime-averageusingtime*0.2<:currenttime AND isconst = 'true'")
    List<Purchase> getByShoppingListAndIsTimeAndIsConst(int shoppinglistid, long currenttime);

//    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
//    List<User> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM purchase WHERE name LIKE :name")
    Purchase findByName(String name);

    @Query("SELECT * FROM purchase WHERE name LIKE :uid")
    Purchase findById(int uid);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Purchase purchase);

    @Update
    void update(Purchase purchase);

    @Delete
    void delete(Purchase purchase);
}
