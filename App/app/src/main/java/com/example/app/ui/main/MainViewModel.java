package com.example.app.ui.main;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.app.database.Repository;
import com.example.app.database.entity.ChampionEntity;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends AndroidViewModel {

    private MutableLiveData<List<ChampionEntity>> allChampions;
    private Repository mRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        allChampions = new MutableLiveData<List<ChampionEntity>>();
        mRepository = new Repository(application);
        getAllChampions();
    }

    public void addChampion(ChampionEntity championEntity) {
        mRepository.insert(championEntity);
    }

    public LiveData<List<ChampionEntity>> getChampions() {
        return allChampions;
    }

    public void getAllChampions() {
        Observable<List<ChampionEntity>> champions = mRepository.getAllChampions();
        Observer<List<ChampionEntity>> observer = champions.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new Observer<List<ChampionEntity>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d("FB", "subscribe ON");
                    }

                    @Override
                    public void onNext(List<ChampionEntity> championEntities) {
                        Log.d("FB", "next");
                        allChampions.setValue(championEntities);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("FB", "ERREUR : " + e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.d("FB", "complete");
                    }
                });
    }
}