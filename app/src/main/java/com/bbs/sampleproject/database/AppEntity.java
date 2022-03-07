package com.bbs.sampleproject.database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class AppEntity {
    @PrimaryKey (autoGenerate = true)
    @ColumnInfo(name = "sid")
    public int sid;

    @ColumnInfo(name = "user_name")
    public String user_name;

    @ColumnInfo(name = "user_password")
    public String user_password;

    @ColumnInfo(name = "user_phone")
    public int user_phone;

    @ColumnInfo(name = "user_email")
    public String user_email;

    @ColumnInfo(name = "organization")
    public String organization;

    @ColumnInfo(name = "position")
    public String position;

    public AppEntity(
            @NonNull String user_name,
            @NonNull String user_password,
            @NonNull int user_phone){
        this.user_name = user_name;
        this.user_password = user_password;
        this.user_phone = user_phone;
    }


}
