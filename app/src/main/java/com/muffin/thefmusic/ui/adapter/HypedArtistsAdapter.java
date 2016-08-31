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

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by StriderKeni on 8/30/16.
 */
public class HypedArtistsAdapter extends RecyclerView.Adapter<HypedArtistsAdapter.HypedArtistsViewHolder>{

    ArrayList<Artists> artists;

    Context context;

    public HypedArtistsAdapter(Context context) {
        this.context = context;
        this.artists = new ArrayList<>();
    }

    @Override
    public HypedArtistsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.item_hyped_artists, parent, false);
        return new HypedArtistsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(HypedArtistsViewHolder holder, int position) {
        Artists currentArtists = artists.get(position);

        holder.setArtistName(currentArtists.getName());
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

    public class HypedArtistsViewHolder extends RecyclerView.ViewHolder {

        TextView artistName;
        ImageView artistImage;

        public HypedArtistsViewHolder(View itemView) {
            super(itemView);

            artistName = (TextView) itemView.findViewById(R.id.txt_name_artist);
            artistImage = (ImageView) itemView.findViewById(R.id.img_artists);
        }

        public void setArtistName(String name) {
            artistName.setText(name);
        }
    }

}
