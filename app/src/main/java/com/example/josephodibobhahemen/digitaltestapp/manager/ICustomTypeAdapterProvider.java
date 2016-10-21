package com.example.josephodibobhahemen.digitaltestapp.manager;

import com.google.gson.GsonBuilder;

/**
 * Created by josephodibobhahemen on 10/21/16.
 */

public interface ICustomTypeAdapterProvider {
    /**
     * Register type adapter.
     *
     * @param gsonBuilder the gson builder
     */
    void registerTypeAdapter(GsonBuilder gsonBuilder);
}
