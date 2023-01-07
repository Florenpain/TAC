package com.example.app.database;

import android.app.Application;

import com.example.app.api.Champion;
import com.example.app.database.room.Database;
import com.example.app.database.room.dao.ChampionDao;

import java.util.List;

import io.reactivex.Observable;

public class Repository {

    private Database myDatabase;

    private ChampionDao championDao;

    public Repository(Application application) {
        myDatabase = Database.getDatabase(application);

        championDao = myDatabase.championDao();
    }

    public void insert(Champion champion) {
        Database.databaseWriteExecutor.execute(() -> {
            championDao.insert(champion);
        });
    }

    public Observable<List<Champion>> getAllChampions() {
        return myDatabase.championDao().getAllChampions();
    }

}
