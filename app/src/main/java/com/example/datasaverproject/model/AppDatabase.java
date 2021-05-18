package com.example.datasaverproject.model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {MyWork.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static final String DBName="ourdb";
    public abstract WorkDAO workDAO();

    public static AppDatabase appDatabase;
    public static AppDatabase getInstance(Context context){
        if(appDatabase==null){
            synchronized (AppDatabase.class){
                if(appDatabase==null){
                    appDatabase= Room.databaseBuilder(context, AppDatabase.class, DBName).allowMainThreadQueries().build();
                }
            }
        }
        return appDatabase;
    }

}
