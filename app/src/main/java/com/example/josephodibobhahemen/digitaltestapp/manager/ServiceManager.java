package com.example.josephodibobhahemen.digitaltestapp.manager;

import com.example.josephodibobhahemen.digitaltestapp.service.TypeConverter;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.strategy.Strategy;

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

    public static final String BaseURL = "http://ads.appia.com/"; // provide your endpoint


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
     * @param customAdapter the custom adapter
     * @return the service instance
     */
    public  static <S> S getServiceInstance(Class<S>  type, ICustomTypeAdapterProvider customAdapter) {

        getInstance().mBuilder
                .baseUrl(BaseURL)
                .client(getInstance().mOkHttpClient)
                .addConverterFactory(new TypeConverter.TypedXmlConverter(SimpleXmlConverterFactory.create()));
        return getInstance().mBuilder.build().create(type);
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

        if(adapterProvider !=  null) {
            adapterProvider.registerTypeAdapter(gsonBuilder);
        }

        return gsonBuilder.create();
    }


}
