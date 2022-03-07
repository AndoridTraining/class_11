package com.bbs.sampleproject.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {AppEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract AppDao appDao();
}
