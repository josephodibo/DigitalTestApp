package com.example.josephodibobhahemen.digitaltestapp.service;

import com.example.josephodibobhahemen.digitaltestapp.manager.ICustomTypeAdapterProvider;
import com.example.josephodibobhahemen.digitaltestapp.manager.ServiceManager;
import com.google.gson.GsonBuilder;

import java.util.LinkedHashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by josephodibobhahemen on 10/21/16.
 */

public class TestService {

    interface TestApi {
        @GET("getAds")
        Call<Reply> getAds(@QueryMap Map<String, String> options);
    }

   private TestApi api;
    public TestService() {
        api = ServiceManager.getServiceInstance(TestApi.class, new ICustomTypeAdapterProvider() {
            @Override
            public void registerTypeAdapter(GsonBuilder gsonBuilder) {

            }
        });
    }

    public void getAds() {
        Call<Reply> call = api.getAds(map());
        call.enqueue(new Callback<Reply>() {
            @Override
            public void onResponse(Call<Reply> call, Response<Reply> response) {

            }

            @Override
            public void onFailure(Call<Reply> call, Throwable t) {

            }
        });
    }


    private Map<String, String>  map() {
        Map<String, String> queryMap =  new LinkedHashMap<>();
        queryMap.put("id","236");
        queryMap.put("password","OVUJ1DJN");
        queryMap.put("siteId","4288");
        queryMap.put("deviceId","4230");
        queryMap.put("sessionId","techtestsession");
        queryMap.put("lname","odibobhahemen");
        queryMap.put("totalCampaignsRequested",String.valueOf(10));

        return queryMap;
    }
}
