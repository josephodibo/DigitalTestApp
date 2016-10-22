package com.example.josephodibobhahemen.digitaltestapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.josephodibobhahemen.digitaltestapp.appcomponents.InjectedApplication;
import com.example.josephodibobhahemen.digitaltestapp.uikit.ListFragmentUIKit;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    ListFragmentUIKit mListFragmentUIKit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((InjectedApplication) getApplication()).inject(this);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,mListFragmentUIKit).commit();
    }
}
