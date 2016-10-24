package com.example.josephodibobhahemen.digitaltestapp.uikit;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.josephodibobhahemen.digitaltestapp.DetailsActivity;
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

    private TestService service = new TestService();
    private EventBusManager busManager = EventBusManager.getInstance();

    private RecyclerView mRecyclerView;
    private ListItemAdapter adapter;
    private SwipeRefreshLayout mSwipeRefreshLayout;


    /**
     * Instantiates a new List fragment ui kit.
     */
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
        View view = inflater.inflate(R.layout.fragment_rcv_layout, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.addItemDecoration(new DeviderItemDecorator(getActivity()));
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_layout);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(true);
                service.getAds(busManager);
            }
        });
    }

    /**
     * Init.
     */
    void init() {
        adapter = new ListItemAdapter(getActivity());
        adapter.setOnClickListener(new RecyclerViewListener.onItemClickListener() {
            @Override
            public void onItemClick(View view, Object object) {
                AdsItem item = (AdsItem) object;
                startActivity(new Intent(getActivity(), DetailsActivity.class).putExtra(TAG.ITEM,item));
            }
        });
        mRecyclerView.setAdapter(adapter);
        initSwipeRefresh();
    }


    /**
     * Init swipe refresh.
     */
    void initSwipeRefresh() {
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                service.getAds(busManager);
            }
        });
        mSwipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
    }

    /**
     * On event.
     *
     * @param reply the reply
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(Reply reply) {
        mSwipeRefreshLayout.setRefreshing(false);
        adapter.setData(reply.getAdsItemList());
    }

    @Override
    public void onStart() {
        super.onStart();
        if (!busManager.isRegistered(this)) {
            busManager.register(this);
        }
    }

    @Override
    public void onStop() {
        if (busManager.isRegistered(this)) {
            busManager.unregister(this);
        }
        super.onStop();
    }
}
