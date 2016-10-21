package com.example.josephodibobhahemen.digitaltestapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.josephodibobhahemen.digitaltestapp.appcomponents.InjectedApplication;
import com.example.josephodibobhahemen.digitaltestapp.manager.ServiceManager;
import com.example.josephodibobhahemen.digitaltestapp.uikit.ListFragmentUIKit;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    ServiceManager serviceManager;
    @Inject
    ListFragmentUIKit mListFragmentUIKit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((InjectedApplication) getApplication()).inject(this);
        setContentView(R.layout.activity_main);

    }


    @Override
    protected void onResume() {
        super.onResume();
    }


}
