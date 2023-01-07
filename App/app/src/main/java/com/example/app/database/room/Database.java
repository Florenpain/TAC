package com.example.app.database.room;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.app.database.room.dao.ChampionDao;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class Database extends RoomDatabase {

    public abstract ChampionDao championDao();
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);


    private static volatile Database INSTANCE;

    public static Database getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (Database.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            Database.class, "my_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
