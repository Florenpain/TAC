package com.example.app.database;

import android.app.Application;

import com.example.app.database.entity.ChampionEntity;
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

    public void insert(ChampionEntity championEntity) {
        Database.databaseWriteExecutor.execute(() -> {
            championDao.insert(championEntity);
        });
    }

    public Observable<List<ChampionEntity>> getAllChampions() {
        return myDatabase.championDao().getAllChampions();
    }

    public void deleteAll() {
        Database.databaseWriteExecutor.execute(() -> {
            championDao.deleteAll();
        });
    }

}
