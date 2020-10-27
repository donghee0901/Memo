package com.example.memo;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {MemoEntity.class}, version = 2)
public abstract class MemoDatabase extends RoomDatabase {
    public abstract MemoDao memoDao();
    private static MemoDatabase instance = null;
    static MemoDatabase getInstance(Context context) {
        if(instance == null) {
            instance = Room.databaseBuilder(context, MemoDatabase.class, "database-name").fallbackToDestructiveMigration().build();
        }
        return instance;
    }
}
