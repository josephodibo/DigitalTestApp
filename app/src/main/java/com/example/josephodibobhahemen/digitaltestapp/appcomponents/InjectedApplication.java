package com.example.josephodibobhahemen.digitaltestapp.appcomponents;

import android.app.Application;
import android.support.v4.app.Fragment;
import android.util.Log;

import dagger.ObjectGraph;

/**
 * Created by josephodibobhahemen on 10/21/16.
 */

public class InjectedApplication extends Application {

    public static final String TAG = InjectedApplication.class.getSimpleName();

    private ObjectGraph mObjectGraph;

    @Override
    public void onCreate() {
        super.onCreate();
        initObjectGraph(new AppModule(this));

    }

    /**
     * Init object graph.
     *
     * @param module for Dagger
     */
    public void initObjectGraph(Object module) {
        mObjectGraph = module !=null ? ObjectGraph.create(module): null;
    }

    public  void inject(Object object) {
        if (mObjectGraph == null) {
            Log.i(TAG, "Object graph is null, only happen during testing");
            return;
        }
        mObjectGraph.inject(object);
    }


}
