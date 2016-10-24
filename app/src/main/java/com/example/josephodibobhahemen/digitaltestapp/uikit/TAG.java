package com.example.josephodibobhahemen.digitaltestapp.uikit;

import android.support.annotation.IntDef;
import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by josephodibobhahemen on 10/22/16.
 */


@StringDef({TAG.ITEM, TAG.LOG})
@IntDef({TAG.DATA_ROW})

@Retention(RetentionPolicy.SOURCE)
public @interface TAG {
    /**
     * The constant ITEM.
     */
    String ITEM = "ADS_ITEM";
    /**
     * The constant DATA_ROW.
     */
    int DATA_ROW = 0;
    /**
     * The constant LOG.
     */
    String LOG = "LOGGING";
}
