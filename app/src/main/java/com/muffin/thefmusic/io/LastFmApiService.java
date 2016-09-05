package com.muffin.thefmusic.io;

import com.muffin.thefmusic.io.model.HypedArtistsResponse;
import com.muffin.thefmusic.io.model.TopArtistResponse;

import java.util.Observable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import rx.Observer;

/**
 * Created by StriderKeni on 8/30/16.
 */
public interface LastFmApiService {

    @GET(ApiConstant.URL_HYPED_ARTIST)
    Call<HypedArtistsResponse> getHypedArtists();

    @GET(ApiConstant.URL_TOP_ARTIST)
    Call<TopArtistResponse> getTopArtits();
    //rx.Observable<TopArtistResponse> getTopArtists();

}
