package com.example.josephodibobhahemen.digitaltestapp.uikit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.josephodibobhahemen.digitaltestapp.R;
import com.example.josephodibobhahemen.digitaltestapp.manager.EventBusManager;
import com.example.josephodibobhahemen.digitaltestapp.service.AdsItem;
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

    TestService service = new TestService();
    EventBusManager busManager = EventBusManager.getInstance();

    private RecyclerView mRecyclerView;
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
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.addItemDecoration(new DeviderItemDecorator(getActivity()));

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
        service.getAds(busManager);

    }
    void init() {
        adapter = new ListItemAdapter(getActivity());
        adapter.setOnClickListener(new RecyclerViewListener.onItemClickListener() {
           @Override
           public void onItemClick(View view, Object object) {
               AdsItem item = (AdsItem) object;
           }
       });
        mRecyclerView.setAdapter(adapter);
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(Reply reply) {
        adapter.setData(reply.getAdsItemList());
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
