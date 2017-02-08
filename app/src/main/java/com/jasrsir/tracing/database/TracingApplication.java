package com.jasrsir.tracing.database;

import android.app.Application;
import android.content.Context;

/**
 * DATABASE APPLICATIONFOR TRACING APP
 *
 */

public class TracingApplication extends Application {

    //region Object
    private DatabaseHelper mDatabase; //Database instance

    private static TracingApplication mInstance; //Instancia del repositorio
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
