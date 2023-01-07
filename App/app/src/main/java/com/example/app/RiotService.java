package com.example.app;

import com.example.app.api.Champion;
import com.example.app.api.ChampionDetails;
import com.example.app.api.DataDragon;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RiotService {

    @GET("/data/fr_FR/champion.json")
    Single<DataDragon> getChampions();

    @GET("/data/fr_FR/champion/{champion}.json")
    Single<ChampionDetails> getChampion(@Path("champion") String champion);

    /*

    @GET("/img/champion/{champion}.png")
    Call<ResponseBody> getChampionImage(@Path("champion") String champion);

    @GET("/img/champion/splash/{champion}_0.jpg")
    Call<ResponseBody> getChampionSplash(@Path("champion") String champion);

    @GET("/img/champion/loading/{champion}_0.jpg")
    Call<ResponseBody> getChampionLoading(@Path("champion") String champion);

    @GET("/img/spell/{spell}.png")
    Call<ResponseBody> getSpellImage(@Path("spell") String spell);

    @GET("/img/item/{item}.png")
    Call<ResponseBody> getItemImage(@Path("item") String item);

    @GET("/img/passive/{passive}.png")
    Call<ResponseBody> getPassiveImage(@Path("passive") String passive);

    @GET("/img/profileicon/{profileIcon}.png")
    Call<ResponseBody> getProfileIcon(@Path("profileIcon") String profileIcon);

    @GET("/img/summoner/spell/{summonerSpell}.png")
    Call<ResponseBody> getSummonerSpellImage(@Path("summonerSpell") String summonerSpell);

    @GET("/img/ability/{ability}.png")
    Call<ResponseBody> getAbilityImage(@Path("ability") String ability);

    */

}
