package com.example.myappnew.basa;

/*основной класс по работе с базой данных*/

import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

@Database(entities = {Entity_UserWeek.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract Dao_UserWeek dao_userWeek();

    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }
}
