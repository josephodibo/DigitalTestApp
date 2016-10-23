package com.example.josephodibobhahemen.digitaltestapp.uikit;

import android.view.View;

/**
 * Created by josephodibobhahemen on 10/22/16.
 */
public class RecyclerViewListener {


    /**
     * The interface On item click listener.
     *
     * @param <T> the type parameter
     */
    public interface onItemClickListener<T> {
        /**
         * On item click.
         *
         * @param view the view
         * @param object    the t
         */
       void onItemClick(View view, T object);
    }
}
