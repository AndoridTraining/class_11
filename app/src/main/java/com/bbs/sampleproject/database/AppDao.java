package com.bbs.sampleproject.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface AppDao {
    @Insert
    void insertAll(AppEntity... user);

    @Query("Select * from AppEntity")
    List<AppEntity> getAll();
}
