package com.jasrsir.tracing.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.jasrsir.tracing.database.DatabaseContract;
import com.jasrsir.tracing.database.DatabaseHelper;

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
    private static SQLiteDatabase sqLiteDatabase;

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

    /**
     * Create connection in Database in private variable
     * @return true if DB is open, False if DB is closed
     */
    @Override
    public boolean onCreate() {
        sqLiteDatabase = DatabaseHelper.getInstance().openDatabase();
        return sqLiteDatabase.isOpen();
    }

    /**
     * Execute a Query sql statement
     * @param uri
     * @param projection All Columns of table
     * @param selection string for Where clause
     * @param selectionArgs array with arguments in WHERE
     * @param sortOrder Order by colums
     * @return a Cursor with result
     */
    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {

        SQLiteQueryBuilder sqLiteQueryBuilder = new SQLiteQueryBuilder();

        switch (uriMatcher.match(uri)){//Clasificamos la URI y se autoejecuta la correspondiente orden.
            case BUSINESS:
                sqLiteQueryBuilder.setTables(DatabaseContract.BusinessEntry.TABLE_NAME);
                if (TextUtils.isEmpty(sortOrder))
                    sortOrder = DatabaseContract.BusinessEntry.DEFAULT_SORT;
                break;
            case BUSINESS_ID:
                break;
            case PROFESSIONAL:
                sqLiteQueryBuilder.setTables(DatabaseContract.ProfessionalEntry.TABLE_NAME);
                if (TextUtils.isEmpty(sortOrder))
                    sortOrder = DatabaseContract.ProfessionalEntry.DEFAULT_SORT;
                break;
            case PROFESSIONAL_ID:
                break;
            case USERS:
                sqLiteQueryBuilder.setTables(DatabaseContract.UsersEntry.TABLE_NAME);
                if (TextUtils.isEmpty(sortOrder))
                    sortOrder = DatabaseContract.UsersEntry.DEFAULT_SORT;
                break;
            case USERS_ID:
                break;
            case ZONES:
                sqLiteQueryBuilder.setTables(DatabaseContract.ZonesEntry.TABLE_NAME);
                if (TextUtils.isEmpty(sortOrder))
                    sortOrder = DatabaseContract.ZonesEntry.DEFAULT_SORT;
                break;
            case ZONES_ID:
                break;
            /*case BUSINESS_PROFESSIONAL:
                sqLiteQueryBuilder.setTables(DatabaseContract.Business_ProfessionalEntry.TABLE_NAME);
                if (TextUtils.isEmpty(sortOrder))
                    sortOrder = DatabaseContract.Business_ProfessionalEntry.DEFAULT_SORT;
                break;
            case BUSINESS_PROFESSIONAL_ID:
                break;
            case PROFESSIONAL_USERS:
                sqLiteQueryBuilder.setTables(DatabaseContract.Professional_UsersEntry.TABLE_NAME);
                if (TextUtils.isEmpty(sortOrder))
                    sortOrder = DatabaseContract.Professional_UsersEntry.DEFAULT_SORT;
                break;
            case PROFESSIONAL_USERS_ID:
                break;*/
            case NOTES:
                sqLiteQueryBuilder.setTables(DatabaseContract.NotesEntry.TABLE_NAME);
                if (TextUtils.isEmpty(sortOrder))
                    sortOrder = DatabaseContract.NotesEntry.DEFAULT_SORT;
                break;
            case NOTES_ID:
                break;
            case ACTIONS:
                sqLiteQueryBuilder.setTables(DatabaseContract.ActionsEntry.TABLE_NAME);
                if (TextUtils.isEmpty(sortOrder))
                    sortOrder = DatabaseContract.ActionsEntry.DEFAULT_SORT;
                break;
            case ACTIONS_ID:
                break;
            case LINKS:
                sqLiteQueryBuilder.setTables(DatabaseContract.LinksEntry.TABLE_NAME);
                if (TextUtils.isEmpty(sortOrder))
                    sortOrder = DatabaseContract.LinksEntry.DEFAULT_SORT;
                break;
            case LINKS_ID:
                break;
            case DATES:
                sqLiteQueryBuilder.setTables(DatabaseContract.DatesEntry.TABLE_NAME);
                if (TextUtils.isEmpty(sortOrder))
                    sortOrder = DatabaseContract.DatesEntry.DEFAULT_SORT;
                break;
            case DATES_ID:
                break;
            case UriMatcher.NO_MATCH:
                throw new IllegalArgumentException("URI invalid");
        }
        //statement for debugging
        String sqlQuery = sqLiteQueryBuilder.buildQuery(projection,selection,null,null,sortOrder,null);
        //Create cursor, query statement and return result.
        Cursor cursor = sqLiteQueryBuilder.query(sqLiteDatabase,projection,selection,selectionArgs, null, null, sortOrder);
        return cursor;
    }

    /**
     *
     * @param uri
     * @return
     */
    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    /**
     *
     * @param uri
     * @param contentValues
     * @return
     */
    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    /**
     *
     * @param uri
     * @param selection
     * @param selectionArgs
     * @return
     */
    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    /**
     *
     * @param uri
     * @param contentValues
     * @param selection
     * @param selectionArgs
     * @return
     */
    @Override
    public int update(Uri uri, ContentValues contentValues, String selection, String[] selectionArgs) {
        return 0;
    }
    //endregion
}
