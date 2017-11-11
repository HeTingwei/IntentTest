package com.example.intenttest;

import android.os.Parcel;
import android.os.Parcelable;


/**
 * Created by HeTingwei on 2017/11/11.
 * this class' object , is the object send from FirstActivity to SixthActivity by intent
 */

public class User implements Parcelable {

    String name;
    int age;
    User2 user2;

    public User(String name,int age,User2 user2) {
        this.name = name;
        this.age = age;
        this.user2=user2;
    }

    public String getName() {
        return name;
    }
    public int getAge(){
        return age;
    }
    public User2 getUser2(){
        return user2;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(age);
        parcel.writeParcelable(user2,0);
    }

    public static final Creator<User> CREATOR = new Creator<User>() {

        @Override
        public User createFromParcel(Parcel parcel) {
            return new User(parcel);
        }

        @Override
        public User[] newArray(int i) {
            return new User[i];
        }
    };

    private User(Parcel in) {
        name = in.readString();
        age = in.readInt();
        user2 = in.readParcelable(Thread.currentThread().getContextClassLoader());
    }
}
