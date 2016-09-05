package com.muffin.thefmusic.io.deserializer;

import android.provider.CalendarContract;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.muffin.thefmusic.domain.Artists;
import com.muffin.thefmusic.io.model.HypedArtistsResponse;
import com.muffin.thefmusic.io.model.JsonKeys;
import com.muffin.thefmusic.io.model.TopArtistResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by StriderKeni on 9/4/16.
 */
public class TopArtistsDeserializer  implements JsonDeserializer<TopArtistResponse> {


    @Override
    public TopArtistResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();

        TopArtistResponse response = gson.fromJson(json, TopArtistResponse.class);

        //Obtener objeto artists
        JsonObject artistsResponseData = json.getAsJsonObject().getAsJsonObject(JsonKeys.ARTISTS_RESULTS);
        //Obtener array de artists
        JsonArray artistsArray = artistsResponseData.getAsJsonArray(JsonKeys.ARTISTS_ARRAY); //ahora estamos dentro del arreglo.

        System.out.print(artistsArray);
        //Convertir el jsonArray de artists a objetos  de la clase artists
        response.setArtists(extractArtistsFromJsonArray(artistsArray));

        return response;
    }


    private ArrayList<Artists> extractArtistsFromJsonArray(JsonArray array) {
        ArrayList<Artists> artists = new ArrayList<>();




        for (int i = 0; i < array.size(); i++) {
            JsonObject artistData = array.get(i).getAsJsonObject();

            Artists currentArtist = new Artists();

            String name =  artistData.get(JsonKeys.ARTIST_NAME).getAsString();
            System.out.print("PRUEBA STRING: "+ name);
            String playCount = artistData.get(JsonKeys.ARTIST_PLAYCOUNT).getAsString();
            String listeners = artistData.get(JsonKeys.ARTIST_LISTENERS).getAsString();

            /*For para extraer imágenes, debido a que existe más de una imágen para cada artista y
            en este caso solo necesitamos las que tienen mejor calidad */
            JsonArray imagesArray = artistData.getAsJsonArray(JsonKeys.ARTISTS_IMAGES);
            String[] images = extractArtistsImagesFromJsonArray(imagesArray);

            //Artists with all information
            currentArtist.setName(name);
            currentArtist.setPlayCount(playCount);
            currentArtist.setListeners(listeners);
            currentArtist.setUrlMediumImage(images[0]);
            currentArtist.setUrlLargeImage(images[1]);

            artists.add(currentArtist);
        }

        return artists;
    }

    //For Images
    private String[] extractArtistsImagesFromJsonArray(JsonArray imagesArray) {
        String [] images = new String[2];

        for (int i = 0; i < imagesArray.size(); i++) {
            JsonObject imagesData = imagesArray.get(i).getAsJsonObject();

            String size = imagesData.get(JsonKeys.IMAGE_SIZE).getAsString();
            String url = imagesData.get(JsonKeys.IMAGE_URL).getAsString();

            if(url.isEmpty()) {
                url = null;
            }

            if(size.matches(JsonKeys.IMAGE_XL)) {
                images[0] = url;

            } else if(size.matches(JsonKeys.IMAGE_MEGA)) {
                images[1] = url;
            }
        }

        return images;
    }
}