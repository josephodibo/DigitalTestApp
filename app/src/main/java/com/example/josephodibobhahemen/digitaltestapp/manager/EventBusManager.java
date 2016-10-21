package com.example.josephodibobhahemen.digitaltestapp.manager;

import android.os.Handler;
import android.os.Looper;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

/**
 * Created by josephodibobhahemen on 10/21/16.
 */

public class EventBusManager {

    private static volatile EventBusManager instance;
    private final Handler mainThread = new Handler(Looper.getMainLooper());

    private EventBus eventBus;

    @Inject
    public EventBusManager() {
        initializeBus();
    }


    /**
     * Initialize bus.
     */
    void initializeBus() {
        eventBus = EventBus.getDefault();
    }


    /**
     * Register.
     *
     * @param subscriber the subscriber
     */
    public void register(Object subscriber) {
        eventBus.register(subscriber);
    }

    /**
     * Unregister.
     *
     * @param subscriber the subscriber
     */
    public void unregister(Object subscriber) {
        eventBus.unregister(subscriber);
    }


    /**
     * Is registered boolean.
     *
     * @param subscriber the subscriber
     * @return the boolean
     */
    public synchronized boolean isRegistered(Object subscriber) {
        return eventBus.isRegistered(subscriber);
    }

    /**
     * Post.
     *
     * @param event the event
     */
    public void post(final Object event) {
        if (event == null) {
            throw new NullPointerException("Event intended for posting is null");
        }

        if (Looper.myLooper() == Looper.getMainLooper()) {
            eventBus.post(event);
        } else {
            mainThread.post(new Runnable() {
                @Override
                public void run() {
                    eventBus.post(event);
                }
            });
        }
    }

}
