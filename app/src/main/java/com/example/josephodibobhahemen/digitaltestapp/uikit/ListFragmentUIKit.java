package com.example.josephodibobhahemen.digitaltestapp.uikit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.josephodibobhahemen.digitaltestapp.R;
import com.example.josephodibobhahemen.digitaltestapp.manager.EventBusManager;
import com.example.josephodibobhahemen.digitaltestapp.service.Reply;
import com.example.josephodibobhahemen.digitaltestapp.service.TestService;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import javax.inject.Inject;

/**
 * Created by josephodibobhahemen on 10/21/16.
 */

public class ListFragmentUIKit extends Fragment {
    @Inject
    DetailsFragmentUIKit mDetailsFragmentUIKit;
    @Inject
    TestService service;

    @Inject
    EventBusManager busManager;

    private RecyclerView mRecyclerView;
    private CardView mCardView;
    private ListItemAdapter adapter;

    @Inject
    public ListFragmentUIKit() {
    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rcv_layout,container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mCardView = (CardView) view.findViewById(R.id.page_header);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        service.getAds(busManager);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(Reply reply) {
        Log.d("TAG", "Respond received");
    }

    @Override
    public void onStart() {
        super.onStart();
        if(!busManager.isRegistered(this)) {busManager.register(this);}
    }

    @Override
    public void onStop() {
        if(busManager.isRegistered(this)) {busManager.unregister(this);}
        super.onStop();
    }
}
