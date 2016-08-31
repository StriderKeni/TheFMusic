package com.muffin.thefmusic.io;

import com.muffin.thefmusic.io.model.HypedArtistsResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;

/**
 * Created by StriderKeni on 8/30/16.
 */
public interface LastFmApiService {

    @GET(ApiConstant.URL_HYPED_ARTIST)
    Call<HypedArtistsResponse> getHypedArtists();
}
