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

    public static Context getAppContext(){
        return TracingApplication.mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        TracingApplication.mContext = getApplicationContext();

    }

   // private void saveEvent(EventPojo eventPojo) {
    //    mEventList.add(eventPojo);
   // }

    //public List<EventPojo> getListEvent() {
   //     return mEventList;
    //}
}
