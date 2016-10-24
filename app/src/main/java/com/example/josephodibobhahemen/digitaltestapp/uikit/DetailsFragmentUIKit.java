package com.example.josephodibobhahemen.digitaltestapp.uikit;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.josephodibobhahemen.digitaltestapp.R;
import com.example.josephodibobhahemen.digitaltestapp.service.AdsItem;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

/**
 * Created by josephodibobhahemen on 10/21/16.
 */

public class DetailsFragmentUIKit extends Fragment {

    private ImageView mImageView;
    private TextView mCategoryTxt, mRatingNumberTxt, mProductDesc;
    private RatingBar mRatingBar;
    private Button mButton;

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
        mImageView = (ImageView) view.findViewById(R.id.details_image_view);
        mCategoryTxt = (TextView) view.findViewById(R.id.category_value);
        mRatingNumberTxt = (TextView) view.findViewById(R.id.rating_number_value);
        mProductDesc =(TextView) view.findViewById(R.id.product_desc);
        mRatingBar =(RatingBar) view.findViewById(R.id.ratingBar2);
        mButton =(Button) view.findViewById(R.id.install_button);
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
    void setItem(final AdsItem item) {

        Picasso.with(getContext())
                .load(item.getProductThumbnail())
                .placeholder(R.color.cardview_dark_background)
                .into(mImageView);

        mRatingBar.setRating(item.getRating());
        mRatingNumberTxt.setText(item.getNumberOfRatings());
        mCategoryTxt.setText(item.getCategoryName());
        mProductDesc.setText(item.getProductDescription());

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + item.getApplicationId())));
            }
        });

    }


}
