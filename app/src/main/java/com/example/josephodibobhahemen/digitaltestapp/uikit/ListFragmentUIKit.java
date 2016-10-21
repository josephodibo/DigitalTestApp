package com.example.josephodibobhahemen.digitaltestapp.uikit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.josephodibobhahemen.digitaltestapp.manager.ServiceManager;

import javax.inject.Inject;

/**
 * Created by josephodibobhahemen on 10/21/16.
 */

public class ListFragmentUIKit extends Fragment {

    @Inject
    DetailsFragmentUIKit mDetailsFragmentUIKit;
    @Inject
    ServiceManager serviceManager;

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
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
