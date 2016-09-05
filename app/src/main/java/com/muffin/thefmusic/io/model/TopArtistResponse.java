package com.muffin.thefmusic.io.model;

import com.google.gson.annotations.SerializedName;
import com.muffin.thefmusic.domain.Artists;

import java.util.ArrayList;

/**
 * Created by StriderKeni on 9/4/16.
 */
public class TopArtistResponse {

    @SerializedName(JsonKeys.ARTISTS_RESULTS)
    HypedArtistsResult result;

    public ArrayList<Artists> getArtist(){
        return result.artists;
    }

    public void setArtists(ArrayList<Artists> artists) {
        this.result.artists = artists;
    }

    private class HypedArtistsResult {

        ArrayList<Artists> artists;
    }
}