package com.example.josephodibobhahemen.digitaltestapp.uikit;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.josephodibobhahemen.digitaltestapp.service.AdsItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by josephodibobhahemen on 10/22/16.
 */

public class ListItemAdapter extends RecyclerView.Adapter<ListItemViewHolder> {

    private Context mContext;
    private List<AdsItem> mAdsItemList = new ArrayList<>();
    private RecyclerViewListener.onItemClickListener mOnClickListener;

    public ListItemAdapter(Context context) {
        this.mContext = context;
    }

    public  void setData(List<AdsItem> adsItemList) {
        this.mAdsItemList = adsItemList;
        notifyDataSetChanged();

    }

    @Override
    public ListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return ListItemViewHolder.createViewHolder(mContext,parent,viewType);
    }

    @Override
    public void onBindViewHolder(ListItemViewHolder holder, int position) {
        holder.internalBinding(mAdsItemList.get(position), mOnClickListener);

    }

    @Override
    public int getItemCount() {
        return mAdsItemList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return ListItemViewHolder.DATA_ROW;
    }

    public void setOnClickListener(RecyclerViewListener.onItemClickListener listener) {
        this.mOnClickListener = listener;
    }
}
