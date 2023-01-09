package com.example.app.database.room.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.app.database.entity.ChampionEntity;

import java.util.Collection;
import java.util.List;

import io.reactivex.Observable;

@Dao
public interface ChampionDao {

    @Insert
    long insert(ChampionEntity championEntity);

    @Query("SELECT * FROM ChampionEntity")
    Observable<List<ChampionEntity>> getAllChampions();

    @Query("DELETE FROM ChampionEntity")
    void deleteAll();

    @Delete
    void deleteChampion(ChampionEntity championEntity);

}
