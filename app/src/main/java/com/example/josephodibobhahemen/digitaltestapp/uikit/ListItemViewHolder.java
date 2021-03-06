package com.example.josephodibobhahemen.digitaltestapp.uikit;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.josephodibobhahemen.digitaltestapp.R;
import com.example.josephodibobhahemen.digitaltestapp.service.AdsItem;
import com.squareup.picasso.Picasso;

/**
 * Created by josephodibobhahemen on 10/22/16.
 */

public class ListItemViewHolder extends RecyclerView.ViewHolder {

    public static ListItemViewHolder createViewHolder(Context context, ViewGroup viewGroup, int viewType) {


        int layoutId = -1;
        switch (viewType) {
            case TAG.DATA_ROW:
                layoutId = R.layout.list_item;
                break;
        }

        final View view = LayoutInflater.from(context).inflate(layoutId, viewGroup, false);
        return new ListItemViewHolder(view, viewType);

    }

    private ListItemViewHolder(View itemView, int viewType) {
        super(itemView);
    }

    @SuppressWarnings("unchecked")
    void internalBinding(final AdsItem adsItem, final RecyclerViewListener.onItemClickListener mOnClickListener) {
        RatingBar ratingBar = (RatingBar) itemView.findViewById(R.id.ratingBar);
        ratingBar.setRating(adsItem.getRating());

        TextView productName = (TextView) itemView.findViewById(R.id.product_name);
        productName.setText(adsItem.getProductName());

        ImageView imageView = (ImageView) itemView.findViewById(R.id.thumb_nail_view);
        Picasso.with(itemView.getContext())
                .load(adsItem.getProductThumbnail())
                .placeholder(R.color.cardview_dark_background)
                .into(imageView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnClickListener != null) {
                    mOnClickListener.onItemClick(v, adsItem);
                }
            }
        });


    }
}
