package com.muffin.thefmusic.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.muffin.thefmusic.R;
import com.muffin.thefmusic.domain.Artists;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by StriderKeni on 9/4/16.
 */
public class TopArtistsAdapter extends RecyclerView.Adapter<TopArtistsAdapter.TopArtistsViewHolder>{

    ArrayList<Artists> artists;

    Context context;

    public TopArtistsAdapter(Context context) {
        this.context = context;
        this.artists = new ArrayList<>();
    }

    @Override
    public TopArtistsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.item_top_artist, parent, false);
        return new TopArtistsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TopArtistsViewHolder holder, int position) {
        Artists currentArtists = artists.get(position);

        holder.setArtistName(currentArtists.getName());
        holder.setArtistPlayCount(currentArtists.getPlayCount());
        holder.setArtistListeners(currentArtists.getListeners());

        if(currentArtists.getUrlMediumImage() != null) {
            holder.setArtistImage(currentArtists.getUrlMediumImage());
        } else {
            holder.setArtistImageDefaultImage();
        }
    }

    @Override
    public int getItemCount() {
        return artists.size();
    }

    public void addAll(@NonNull ArrayList<Artists> artists){
        if(artists == null)
            throw new NullPointerException("The items cannot be null");

        this.artists.addAll(artists);
        notifyItemRangeInserted(getItemCount() - 1, artists.size());
    }

    public class TopArtistsViewHolder extends RecyclerView.ViewHolder {

        ImageView artistImage;
        TextView artistName;
        TextView artistPlayCount;
        TextView artistListeners;

        public TopArtistsViewHolder(View itemView) {
            super(itemView);

            artistImage = (ImageView) itemView.findViewById(R.id.img_artist);
            artistName = (TextView) itemView.findViewById(R.id.txt_artist_name);
            artistPlayCount = (TextView) itemView.findViewById(R.id.txt_play_count);
            artistListeners = (TextView) itemView.findViewById(R.id.txt_listeners);
        }

        public void setArtistName(String name) {
            artistName.setText(name);
        }

        public void setArtistPlayCount(String playCount) {
            artistPlayCount.setText(playCount);
        }

        public void setArtistListeners(String listeners){
            artistListeners.setText(listeners);
        }

        public void setArtistImage (String url) {
            Picasso.with(context)
                    .load(url)
                    .placeholder(R.drawable.artist_placeholder)
                    .into(artistImage);
        }

        public void setArtistImageDefaultImage () {
            Picasso.with(context)
                    .load(R.drawable.artist_placeholder)
                    .into(artistImage);
        }


    }


}