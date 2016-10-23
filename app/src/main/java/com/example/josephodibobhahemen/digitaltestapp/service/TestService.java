package com.example.josephodibobhahemen.digitaltestapp.service;

import android.util.Log;

import com.example.josephodibobhahemen.digitaltestapp.manager.EventBusManager;
import com.example.josephodibobhahemen.digitaltestapp.manager.ServiceManager;
import com.example.josephodibobhahemen.digitaltestapp.manager.TypeConverter;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by josephodibobhahemen on 10/21/16.
 */
public class TestService {

    /**
     * The interface Test api.
     */
    interface TestApi {
        /**
         * Gets ads.
         *
         * @param options the options
         * @return the ads
         */
        @GET("getAds")
        @TypeConverter.Xml
        Call<Reply> getAds(@QueryMap Map<String, String> options);
    }

    private TestApi api;

    /**
     * Instantiates a new Test service.
     */
    @Inject
    public TestService() {
        api = ServiceManager.getServiceInstance(TestApi.class);
    }

    /**
     * Gets ads.
     */
    public void getAds(final EventBusManager bus) {
        Call<Reply> call = api.getAds(queryMap());
        call.enqueue(new Callback<Reply>() {
            @Override
            public void onResponse(Call<Reply> call, Response<Reply> response) {
              bus.post(response.body());

            }

            @Override
            public void onFailure(Call<Reply> call, Throwable t) {
                Log.d("TAG", "Service Error");

            }
        });
    }


    /**
     * Map map.
     *
     * @return the map
     */
    Map<String, String> queryMap() {
        Map<String, String> queryMap = new LinkedHashMap<>();
        queryMap.put("id", "236");
        queryMap.put("password", "OVUJ1DJN");
        queryMap.put("siteId", "4288");
        queryMap.put("deviceId", "4230");
        queryMap.put("sessionId", "techtestsession");
        queryMap.put("lname", "odibobhahemen");
        queryMap.put("totalCampaignsRequested", String.valueOf(20));

        return queryMap;
    }
}
