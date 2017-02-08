package com.jasrsir.tracing.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by jasrsir on 8/02/17.
 * Class Content Provider who use TracingContract
 */

public class TracingProvider extends ContentProvider {

    //region CONSTANTS
    private static final int BUSINESS = 1;
    private static final int BUSINESS_ID = 2;
    private static final int PROFESSIONAL = 3;
    private static final int PROFESSIONAL_ID = 4;
    private static final int USERS = 5;
    private static final int USERS_ID = 6;
    
    private static final int ZONES = 7;
    private static final int ZONES_ID = 8;
    private static final int BUSINESS_PROFESSIONAL = 9;
    private static final int BUSINESS_PROFESSIONAL_ID = 10;
    private static final int PROFESSIONAL_USERS = 11;
    private static final int PROFESSIONAL_USERS_ID = 12;

    private static final int NOTES = 13;
    private static final int NOTES_ID = 14;
    private static final int ACTIONS = 15;
    private static final int ACTIONS_ID = 16;
    private static final int LINKS = 17;
    private static final int LINKS_ID = 18;
    private static final int DATES = 19;
    private static final int DATES_ID = 20;


    private static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    
    //todo URI DEFINITION FOR CONTENT PROVIDER
    static {
        uriMatcher.addURI(TracingContract.AUTHORITY,TracingContract.Business.CONTENT_PATH,BUSINESS);
        uriMatcher.addURI(TracingContract.AUTHORITY,TracingContract.Business.CONTENT_PATH+"/#",BUSINESS_ID);
        uriMatcher.addURI(TracingContract.AUTHORITY,TracingContract.Professional.CONTENT_PATH,PROFESSIONAL);
        uriMatcher.addURI(TracingContract.AUTHORITY,TracingContract.Professional.CONTENT_PATH+"/#",PROFESSIONAL_ID);
        uriMatcher.addURI(TracingContract.AUTHORITY,TracingContract.Users.CONTENT_PATH,USERS);
        uriMatcher.addURI(TracingContract.AUTHORITY,TracingContract.Users.CONTENT_PATH+"/#",USERS_ID);

        uriMatcher.addURI(TracingContract.AUTHORITY,TracingContract.Zones.CONTENT_PATH,ZONES);
        uriMatcher.addURI(TracingContract.AUTHORITY,TracingContract.Zones.CONTENT_PATH+"/#",ZONES_ID);
        uriMatcher.addURI(TracingContract.AUTHORITY,TracingContract.Business_Professional.CONTENT_PATH,BUSINESS_PROFESSIONAL);
        uriMatcher.addURI(TracingContract.AUTHORITY,TracingContract.Business_Professional.CONTENT_PATH+"/#",BUSINESS_PROFESSIONAL_ID);
        uriMatcher.addURI(TracingContract.AUTHORITY,TracingContract.Professional_Users.CONTENT_PATH,PROFESSIONAL_USERS);
        uriMatcher.addURI(TracingContract.AUTHORITY,TracingContract.Professional_Users.CONTENT_PATH+"/#",PROFESSIONAL_USERS_ID);

        uriMatcher.addURI(TracingContract.AUTHORITY,TracingContract.Notes.CONTENT_PATH,NOTES);
        uriMatcher.addURI(TracingContract.AUTHORITY,TracingContract.Notes.CONTENT_PATH+"/#",NOTES_ID);
        uriMatcher.addURI(TracingContract.AUTHORITY,TracingContract.Actions.CONTENT_PATH,ACTIONS);
        uriMatcher.addURI(TracingContract.AUTHORITY,TracingContract.Actions.CONTENT_PATH+"/#",ACTIONS_ID);
        uriMatcher.addURI(TracingContract.AUTHORITY,TracingContract.Links.CONTENT_PATH,LINKS);
        uriMatcher.addURI(TracingContract.AUTHORITY,TracingContract.Links.CONTENT_PATH+"/#",LINKS_ID);
        uriMatcher.addURI(TracingContract.AUTHORITY,TracingContract.Dates.CONTENT_PATH,DATES);
        uriMatcher.addURI(TracingContract.AUTHORITY,TracingContract.Dates.CONTENT_PATH+"/#",DATES_ID);
    }
    //endregion

    //region Content Provider Override Methods 
    @Override
    public boolean onCreate() {
        return false;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] strings, String s, String[] strings1, String s1) {
        return null;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        return 0;
    }
    //endregion
}
