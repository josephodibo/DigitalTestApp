package com.example.josephodibobhahemen.digitaltestapp.manager;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by josephodibobhahemen on 10/21/16.
 */

public class ServiceManager {

    public static final int TIMEOUT = 60;
    private  static ServiceManager _instance;
    private OkHttpClient mOkHttpClient;
    private Retrofit.Builder mBuilder;

    public static final String BaseURL = "http://ads.appia.com/";


    /**
     * Instantiates a new Service maneger.
     */
    public ServiceManager() {
        initialize();
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static ServiceManager getInstance() {
        if(_instance == null) {
            _instance = new ServiceManager();
        }
        return _instance;
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
        mBuilder  = new Retrofit.Builder();
    }


    /**
     * Gets service instance.
     *
     * @param <S>           the type parameter
     * @param type          the type
     * @return the service instance
     */
    public  static <S> S getServiceInstance(Class<S>  type) {
        getInstance().mBuilder
                .baseUrl(BaseURL)
                .client(getInstance().mOkHttpClient)
                .addConverterFactory(new TypeConverter.TypedXmlConverter(SimpleXmlConverterFactory.create()));
        return getInstance().mBuilder.build().create(type);
    }


}
