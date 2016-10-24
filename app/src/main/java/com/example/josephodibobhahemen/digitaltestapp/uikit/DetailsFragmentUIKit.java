package com.example.josephodibobhahemen.digitaltestapp.uikit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.josephodibobhahemen.digitaltestapp.R;
import com.example.josephodibobhahemen.digitaltestapp.service.AdsItem;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

/**
 * Created by josephodibobhahemen on 10/21/16.
 */

public class DetailsFragmentUIKit extends Fragment {

    private ImageView imageView;

    @Inject
    public DetailsFragmentUIKit() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.details_fragment_layout, container, false);
        imageView = (ImageView) view.findViewById(R.id.details_image_view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        AdsItem adsItem = (AdsItem) getArguments().getSerializable(TAG.ITEM);
        setItem(adsItem);
    }

    /**
     * Sets item.
     *
     * @param item the item
     */
    void setItem(AdsItem item) {
        Picasso.with(getContext())
                .load(item.getProductThumbnail())
                .placeholder(R.color.cardview_dark_background)
                .into(imageView);
    }


}
