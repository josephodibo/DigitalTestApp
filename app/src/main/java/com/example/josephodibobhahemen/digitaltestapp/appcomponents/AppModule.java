package com.example.josephodibobhahemen.digitaltestapp.appcomponents;

import android.content.Context;

import com.example.josephodibobhahemen.digitaltestapp.MainActivity;
import com.example.josephodibobhahemen.digitaltestapp.manager.EventBusManager;
import com.example.josephodibobhahemen.digitaltestapp.manager.ServiceManager;
import com.example.josephodibobhahemen.digitaltestapp.service.TestService;
import com.example.josephodibobhahemen.digitaltestapp.uikit.DetailsFragmentUIKit;
import com.example.josephodibobhahemen.digitaltestapp.uikit.ListFragmentUIKit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by josephodibobhahemen on 10/21/16.
 */

@Module(
        library = true,
        injects = {MainActivity.class}
)
public class AppModule {

    private final Context mContext;

    public AppModule(Context context) {
        this.mContext  = context;
    }

    @Provides
    @Singleton
    public ServiceManager providesServiceManager(){
        return new ServiceManager();
    }

    @Provides
    @Singleton
    public EventBusManager providesEventBusManager() {
        return new EventBusManager();
    }

    @Provides
    public ListFragmentUIKit providesListFragmentUIKit() {
        return new ListFragmentUIKit();
    }

    @Provides
    public DetailsFragmentUIKit providesDetailsFragmentUIKit() {
        return new DetailsFragmentUIKit();
    }

    @Provides
    @Singleton
    public TestService providesTestService() {
        return new TestService();
    }
}
