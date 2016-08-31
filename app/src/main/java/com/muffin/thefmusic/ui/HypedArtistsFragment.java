package com.muffin.thefmusic.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.muffin.thefmusic.R;
import com.muffin.thefmusic.domain.Artists;
import com.muffin.thefmusic.io.LastFmApiAdapter;
import com.muffin.thefmusic.io.LastFmApiService;
import com.muffin.thefmusic.io.model.HypedArtistsResponse;
import com.muffin.thefmusic.ui.adapter.HypedArtistsAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by StriderKeni on 8/29/16.
 */
public class HypedArtistsFragment extends Fragment {

    private static final int NUM_COLUMNS = 2;

    private RecyclerView mHypedArtistsList;
    private HypedArtistsAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new HypedArtistsAdapter(getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_hyped_artists, container, false);
        mHypedArtistsList = (RecyclerView) root.findViewById(R.id.hyped_artists_list);
        setupHypedArtistList();
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();

        Call<HypedArtistsResponse> call = LastFmApiAdapter.getApiService().getHypedArtists();
        call.enqueue(new Callback<HypedArtistsResponse>() {
            @Override
            public void onResponse(Call<HypedArtistsResponse> call, Response<HypedArtistsResponse> response) {
                adapter.addAll(response.body().getArtist());
            }

            @Override
            public void onFailure(Call<HypedArtistsResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }


    private void setupHypedArtistList() {
        mHypedArtistsList.setLayoutManager(new GridLayoutManager(getActivity(), NUM_COLUMNS));
        mHypedArtistsList.setAdapter(adapter);
        mHypedArtistsList.addItemDecoration(new itemOffsetDecoration(getActivity(), R.integer.offset));
    }



}
