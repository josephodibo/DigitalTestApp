package com.example.josephodibobhahemen.digitaltestapp.manager;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by josephodibobhahemen on 10/21/16.
 */

public class ServiceManager {

    private static final int TIMEOUT = 60;
    private OkHttpClient mOkHttpClient;
    private Retrofit.Builder mBuilder;

    public static final String BaseURL = "https://api.github.com/"; // provide your endpoint


    /**
     * Instantiates a new Service manager.
     */

    @Inject
    public ServiceManager() {
        initialize();
    }


    /**
     * Initialize.
     */
    void initialize() {
        initializeOkHttp();
        initializeRetrofitBuilder();
    }


    /**
     * Initialize OKHttp.
     */
    private void initializeOkHttp() {
        mOkHttpClient = new OkHttpClient.Builder()
                .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                .addNetworkInterceptor(new LoggingInterceptor())
                .build();
    }


    /**
     * Initialize retrofit builder.
     */
    void initializeRetrofitBuilder() {
        mBuilder = new Retrofit.Builder();
    }


    /**
     * Gets service instance.
     *
     * @param <S>           the type parameter
     * @param type          the type
     * @param customAdapter the custom adapter
     * @return the service instance
     */
    public <S> S getServiceInstance(Class<S> type, ICustomTypeAdapterProvider customAdapter) {
        mBuilder.baseUrl(BaseURL)
                .client(mOkHttpClient)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(ServiceManager.initializeGson(customAdapter)));
        return mBuilder.build().create(type);
    }


    /**
     * Initialize  gson.
     *
     * @param adapterProvider the adapter provider
     * @return the gson
     */
    static Gson initializeGson(ICustomTypeAdapterProvider adapterProvider) {

        GsonBuilder gsonBuilder = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .disableHtmlEscaping()
                .serializeNulls();

        if (adapterProvider != null) {
            adapterProvider.registerTypeAdapter(gsonBuilder);
        }

        return gsonBuilder.create();
    }

}
