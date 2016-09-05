package com.muffin.thefmusic.domain;

import com.google.gson.annotations.SerializedName;
import com.muffin.thefmusic.io.model.JsonKeys;

/**
 * Created by StriderKeni on 8/29/16.
 */
public class Artists {

    @SerializedName(JsonKeys.ARTIST_NAME)
    String name;

    String urlMediumImage;
    String urlLargeImage;
    String playCount;
    String listeners;

    public Artists() {
    }

    public Artists(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlMediumImage() {
        return urlMediumImage;
    }

    public void setUrlMediumImage(String urlMediumImage) {
        this.urlMediumImage = urlMediumImage;
    }

    public String getUrlLargeImage() {
        return urlLargeImage;
    }

    public void setUrlLargeImage(String urlLargeImage) {
        this.urlLargeImage = urlLargeImage;
    }

    public String getPlayCount() {
        return playCount;
    }

    public void setPlayCount(String playCount) {
        this.playCount = playCount;
    }

    public String getListeners() {
        return listeners;
    }

    public void setListeners(String listeners) {
        this.listeners = listeners;
    }
}
