package com.muffin.thefmusic.io;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by StriderKeni on 8/30/16.
 */
public class LastFmApiAdapter {

    private static LastFmApiService API_SERVICE;

    public static LastFmApiService getApiService() {
        if(API_SERVICE == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(ApiConstant.URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create()).build();

            API_SERVICE = retrofit.create(LastFmApiService.class);
        }

        return API_SERVICE;
    }
}
