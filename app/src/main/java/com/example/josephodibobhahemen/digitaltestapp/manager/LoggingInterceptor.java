package com.example.josephodibobhahemen.digitaltestapp.manager;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by josephodibobhahemen on 10/21/16.
 */

public class LoggingInterceptor implements Interceptor {

    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {

        Request original = chain.request();

        Request request = original.newBuilder()
                .header("Connection", "Keep-Alive")
                .header("cache-Control", "no-cache")
                .header("User-Agent", "Android-Version")
                .build();

        Log.d("LoggingInterceptor", String.format("Sending request %s on %s%n%s%s", request.url(), chain.connection(), request.headers(), request.body()));

        return  chain.proceed(request);
    }
}
