package com.bbs.sampleproject.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {AppEntity.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract AppDao appDao();
}
