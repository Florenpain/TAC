package com.example.app.database.room.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.app.api.Champion;

import java.util.List;
import io.reactivex.Observable;

@Dao
public interface ChampionDao {

    @Insert
    long insert(Champion champion);

    @Query("SELECT * FROM Champion")
    Observable<List<Champion>> getAllChampions();

    @Query("DELETE FROM Champion")
    void deleteAll();

}
