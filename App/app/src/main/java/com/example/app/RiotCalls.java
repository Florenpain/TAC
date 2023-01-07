package com.example.app;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class RiotCalls {

    public static String dataDragonUrl = "https://ddragon.leagueoflegends.com/cdn/12.23.1";
    private static Retrofit retrofit;
    private static RiotCalls instance = null;
    private RiotService myAPI;

    public RiotCalls(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(dataDragonUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
            myAPI = retrofit.create(RiotService.class);
        }
    }

    public static RiotCalls getInstance() {
        if (instance == null) {
            instance = new RiotCalls();
        }
        return instance;
    }

    public RiotService getMyApi() {
        return myAPI;
    }
}
