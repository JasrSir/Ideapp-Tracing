package com.jasrsir.tracing.database;

import android.app.Application;
import android.content.Context;

/**
 * DATABASE APPLICATION FOR TRACING APP
 * Created by Juan Antonio Suárez Rosa (JasrSir)
 */

public class TracingApplication extends Application {

    //region Object
    private static Context mContext;

    //endregion

    public static Context getContext(){
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        TracingApplication.mContext = this;
    }


}
