package com.muffin.thefmusic.io.model;

import com.google.gson.annotations.SerializedName;
import com.muffin.thefmusic.domain.Artists;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by StriderKeni on 8/30/16.
 */
public class HypedArtistsResponse {

    @SerializedName(JsonKeys.ARTISTS_RESULTS)
    HypedArtistsResult result;

    public ArrayList<Artists> getArtist(){
        return result.artists;
    }

    private class HypedArtistsResult {
        @SerializedName(JsonKeys.ARTISTS_ARRAY)
        ArrayList<Artists> artists;
    }
}
