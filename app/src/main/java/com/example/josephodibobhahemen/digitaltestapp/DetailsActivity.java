package com.example.josephodibobhahemen.digitaltestapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.josephodibobhahemen.digitaltestapp.appcomponents.InjectedApplication;
import com.example.josephodibobhahemen.digitaltestapp.uikit.DetailsFragmentUIKit;

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
        getSupportFragmentManager().beginTransaction().replace(R.id.details_fragment_container,detailsFragmentUIKit).commit();

        detailsFragmentUIKit.setItem(null);
    }
}
