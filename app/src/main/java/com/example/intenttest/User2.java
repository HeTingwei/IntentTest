package com.example.intenttest;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by HeTingwei on 2017/11/11.
 * this class is use as a  User's variable
 */

public class User2 implements Parcelable {

    private  String  password;

    public User2(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(password);
    }

    public static final Creator<User2>CREATOR=new Creator<User2>() {
        @Override
        public User2 createFromParcel(Parcel in) {
            return new User2(in);
        }

        @Override
        public User2[] newArray(int size) {
            return new User2[size];
        }
    };

    private User2(Parcel in) {
        password = in.readString();
    }
}
