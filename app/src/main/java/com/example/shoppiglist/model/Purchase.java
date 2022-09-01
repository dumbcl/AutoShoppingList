package com.example.shoppiglist.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity
public class Purchase implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "usingtimes")
    public int usingtimes;

    @ColumnInfo(name = "averageusingtime")
    public long averageusingtime;

    @ColumnInfo(name = "firstusingtime")
    public long firstusingtime;

    @ColumnInfo(name = "lastusingtime")
    public long lastusingtime;

    @ColumnInfo(name = "isbought")
    public boolean isbought;

    @ColumnInfo(name = "shoppinglistid")
    public int shoppinglistid;

    @ColumnInfo(name = "isconst")
    public boolean isconst;

    @ColumnInfo(name = "extracomments")
    public String extracomments;

    public Purchase(){
        //а дата норм с этим? не забудь

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchase purchase = (Purchase) o;
        return uid == purchase.uid && usingtimes == purchase.usingtimes && averageusingtime == purchase.averageusingtime && firstusingtime == purchase.firstusingtime && lastusingtime == purchase.lastusingtime && isbought == purchase.isbought && shoppinglistid == purchase.shoppinglistid && isconst == purchase.isconst && Objects.equals(name, purchase.name) && Objects.equals(extracomments, purchase.extracomments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, name, usingtimes, averageusingtime, firstusingtime, lastusingtime, isbought, shoppinglistid, isconst, extracomments);
    }


    @Override
    public int describeContents() {
        return 0;
    }

    protected Purchase(Parcel in) {
        uid = in.readInt();
        name = in.readString();
        usingtimes = in.readInt();
        averageusingtime = in.readLong();
        firstusingtime = in.readLong();
        lastusingtime = in.readLong();
        isbought = in.readByte() != 0;
        shoppinglistid = in.readInt();
        isconst = in.readByte() != 0;
        extracomments = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(uid);
        dest.writeString(name);
        dest.writeInt(usingtimes);
        dest.writeLong(averageusingtime);
        dest.writeLong(firstusingtime);
        dest.writeLong(lastusingtime);
        dest.writeByte((byte) (isbought ? 1 : 0));
        dest.writeInt(shoppinglistid);
        dest.writeByte((byte) (isconst ? 1 : 0));
        dest.writeString(extracomments);
    }

    public static final Creator<Purchase> CREATOR = new Creator<Purchase>() {
        @Override
        public Purchase createFromParcel(Parcel in) {
            return new Purchase(in);
        }

        @Override
        public Purchase[] newArray(int size) {
            return new Purchase[size];
        }
    };
}
