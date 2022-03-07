package com.bbs.sampleproject.database;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface AppDao {
    @Insert
    void insertAll(AppEntity... user);
}
