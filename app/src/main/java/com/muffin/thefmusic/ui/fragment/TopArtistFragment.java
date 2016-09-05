package com.muffin.thefmusic.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.muffin.thefmusic.R;
import com.muffin.thefmusic.io.LastFmApiAdapter;
import com.muffin.thefmusic.io.LastFmApiService;
import com.muffin.thefmusic.io.model.TopArtistResponse;
import com.muffin.thefmusic.ui.adapter.TopArtistsAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopArtistFragment extends Fragment {

    private RecyclerView artistList;
    private TopArtistsAdapter topArtistsAdapter;

    public TopArtistFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        topArtistsAdapter = new TopArtistsAdapter(getActivity());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_top_artist, container, false);
        artistList = (RecyclerView) root.findViewById(R.id.top_artist_list);
        topArtistsAdapter = new TopArtistsAdapter(getActivity());

        setupList();

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();

        Call<TopArtistResponse> topArtistResponseCall = LastFmApiAdapter.getApiService().getTopArtits();
        topArtistResponseCall.enqueue(new Callback<TopArtistResponse>() {
            @Override
            public void onResponse(Call<TopArtistResponse> call, Response<TopArtistResponse> response) {
                topArtistsAdapter.addAll(response.body().getArtist());
            }

            @Override
            public void onFailure(Call<TopArtistResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });

        /*LastFmApiAdapter.getApiService()
                .getTopArtists()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<TopArtistResponse>() {
                    @Override
                    public void call(TopArtistResponse topArtistResponse) {
                        topArtistsAdapter.addAll(topArtistResponse.getArtist());
                    }
                });*/
    }

    public void setupList(){
        artistList.setLayoutManager(new LinearLayoutManager(getActivity()));
        artistList.setAdapter(topArtistsAdapter);

    }

}
