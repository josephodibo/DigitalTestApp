package com.example.josephodibobhahemen.digitaltestapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.josephodibobhahemen.digitaltestapp.appcomponents.InjectedApplication;
import com.example.josephodibobhahemen.digitaltestapp.service.AdsItem;
import com.example.josephodibobhahemen.digitaltestapp.uikit.DetailsFragmentUIKit;
import com.example.josephodibobhahemen.digitaltestapp.uikit.TAG;

import javax.inject.Inject;

/**
 * Created by josephodibobhahemen on 10/22/16.
 */

public class DetailsActivity extends AppCompatActivity {

    @Inject
    DetailsFragmentUIKit detailsFragmentUIKit;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        ((InjectedApplication) getApplication()).inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        if (getIntent().hasExtra(TAG.ITEM)){
            AdsItem item  = (AdsItem) getIntent().getExtras().getSerializable(TAG.ITEM);
            Bundle args = new Bundle();
            args.putSerializable(TAG.ITEM,item );
            detailsFragmentUIKit.setArguments(args);

            //noinspection ConstantConditions
            getSupportActionBar().setTitle(item.getProductName());
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.details_fragment_container,detailsFragmentUIKit).commit();
    }
}
