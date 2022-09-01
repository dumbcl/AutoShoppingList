package com.example.shoppiglist.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity
public class ShoppingList implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "purchasesnumber")
    public int purchasesnumber;

    @ColumnInfo(name = "boughtpurchasesnumber")
    public int boughtpurchasesnumber;

    @ColumnInfo(name = "isinbucket")
    public boolean isinbucket;

    @ColumnInfo(name = "deletiontime")
    public long deletiontime;

    @ColumnInfo(name = "isconst")
    public boolean isconst;

    public ShoppingList(){
        //а дата норм с этим? не забудь
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingList that = (ShoppingList) o;
        return uid == that.uid && purchasesnumber == that.purchasesnumber && boughtpurchasesnumber == that.boughtpurchasesnumber && isinbucket == that.isinbucket && deletiontime == that.deletiontime && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, name, purchasesnumber, boughtpurchasesnumber, isinbucket, deletiontime);
    }


    @Override
    public int describeContents() {
        return 0;
    }

    protected ShoppingList(Parcel in) {
        uid = in.readInt();
        name = in.readString();
        purchasesnumber = in.readInt();
        boughtpurchasesnumber = in.readInt();
        isinbucket = in.readByte() != 0;
        deletiontime = in.readLong();
        isconst = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(uid);
        dest.writeString(name);
        dest.writeInt(purchasesnumber);
        dest.writeInt(boughtpurchasesnumber);
        dest.writeByte((byte) (isinbucket ? 1 : 0));
        dest.writeLong(deletiontime);
        dest.writeByte((byte) (isconst ? 1 : 0));
    }

    public static final Creator<ShoppingList> CREATOR = new Creator<ShoppingList>() {
        @Override
        public ShoppingList createFromParcel(Parcel in) {
            return new ShoppingList(in);
        }

        @Override
        public ShoppingList[] newArray(int size) {
            return new ShoppingList[size];
        }
    };
}
