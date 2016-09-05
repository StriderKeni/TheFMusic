package com.muffin.thefmusic.io;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.muffin.thefmusic.io.deserializer.HypedArtistsDeserializer;
import com.muffin.thefmusic.io.deserializer.TopArtistsDeserializer;
import com.muffin.thefmusic.io.model.HypedArtistsResponse;
import com.muffin.thefmusic.io.model.TopArtistResponse;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by StriderKeni on 8/30/16.
 */
public class LastFmApiAdapter {

    private static LastFmApiService API_SERVICE;

    public static LastFmApiService getApiService() {
        if(API_SERVICE == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(ApiConstant.URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create(buildLastFmApiGsonConverter()))
                    .build();

            API_SERVICE = retrofit.create(LastFmApiService.class);
        }

        return API_SERVICE;
    }

    //Indicar a retrofir que el deserializador es manual y no utilizaremos HypedArtistResponse
    private static Gson buildLastFmApiGsonConverter(){
        Gson gsonConf = new GsonBuilder()
                .registerTypeAdapter(HypedArtistsResponse.class, new HypedArtistsDeserializer())
                .registerTypeAdapter(TopArtistResponse.class, new TopArtistsDeserializer())
                .create();

        return  gsonConf;
    }


}
