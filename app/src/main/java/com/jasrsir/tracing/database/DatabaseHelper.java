package com.jasrsir.tracing.database;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * SQLiteOpenHelper to manage database
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    //region Objects
    private static final int DATABASE_VERSION = 4;
    private static final String DATABASE_NAME = "Tracing.db";

    private volatile static DatabaseHelper mInstance; //synronized
    private AtomicInteger mOpenCounter; //Threads in ejecution
    private SQLiteDatabase mDatabase; //Our Database
    //endregion

    //region Functions

    /**
     * Constrctor
     */
    public DatabaseHelper() {
        super(TracingApplication.getContext(),DATABASE_NAME, null, DATABASE_VERSION);
        mOpenCounter = new AtomicInteger();
    }

    /**
     * Get Database helper instance
     * @return instance
     */
    public synchronized static DatabaseHelper getInstance(){
        if (mInstance == null)
            mInstance = new DatabaseHelper();
        return mInstance;
    }

    /**
     * Open database instance
     * @return database open
     */
    public synchronized SQLiteDatabase openDatabase(){
        if (mOpenCounter.incrementAndGet() == 1)
            mDatabase = getWritableDatabase();
        return mDatabase;
    }

    /**
     * Database closer
     */
    public synchronized void closeDatabase(){
        if (mOpenCounter.decrementAndGet() == 0)
            mDatabase.close();
    }

    public SQLiteDatabase open(){
        return getWritableDatabase();
    }
    //endregion

    //region Override Functions

    /**
     * Database creation with transaction and tables to init application
     * @param sqldb database instance
     */
    @Override
    public void onCreate(SQLiteDatabase sqldb) {
        sqldb.beginTransaction();

        try {
            sqldb.execSQL(DatabaseContract.BusinessEntry.SQL_CREATE_ENTRIES);
            sqldb.execSQL(DatabaseContract.ProfessionalEntry.SQL_CREATE_ENTRIES);
            sqldb.execSQL(DatabaseContract.UsersEntry.SQL_CREATE_ENTRIES);
            sqldb.execSQL(DatabaseContract.Business_ProfessionalEntry.SQL_CREATE_ENTRIES);
            sqldb.execSQL(DatabaseContract.Professional_UsersEntry.SQL_CREATE_ENTRIES);
            sqldb.execSQL(DatabaseContract.ZonesEntry.SQL_CREATE_ENTRIES);
            sqldb.execSQL(DatabaseContract.NotesEntry.SQL_CREATE_ENTRIES);
            sqldb.execSQL(DatabaseContract.ActionsEntry.SQL_CREATE_ENTRIES);
            sqldb.execSQL(DatabaseContract.LinksEntry.SQL_CREATE_ENTRIES);
            sqldb.execSQL(DatabaseContract.DatesEntry.SQL_CREATE_ENTRIES);
            sqldb.setTransactionSuccessful();
        } catch (SQLException e){
            Log.e("tracingdatabase","Error to create DATABASE-> " + e.getMessage());
        } finally {
            sqldb.endTransaction();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqldb, int oldVersion, int newVersion) {
        sqldb.beginTransaction();

        try {
            sqldb.execSQL(DatabaseContract.BusinessEntry.SQL_DELETE_ENTRIES);
            sqldb.execSQL(DatabaseContract.ProfessionalEntry.SQL_DELETE_ENTRIES);
            sqldb.execSQL(DatabaseContract.UsersEntry.SQL_DELETE_ENTRIES);
            sqldb.execSQL(DatabaseContract.Business_ProfessionalEntry.SQL_DELETE_ENTRIES);
            sqldb.execSQL(DatabaseContract.Professional_UsersEntry.SQL_DELETE_ENTRIES);
            sqldb.execSQL(DatabaseContract.ZonesEntry.SQL_DELETE_ENTRIES);
            sqldb.execSQL(DatabaseContract.NotesEntry.SQL_DELETE_ENTRIES);
            sqldb.execSQL(DatabaseContract.ActionsEntry.SQL_DELETE_ENTRIES);
            sqldb.execSQL(DatabaseContract.LinksEntry.SQL_DELETE_ENTRIES);
            sqldb.execSQL(DatabaseContract.DatesEntry.SQL_DELETE_ENTRIES);
            onCreate(sqldb);
            sqldb.setTransactionSuccessful();
        } catch (SQLException e){
            Log.e("tracingdatabase","Error to create DATABASE-> " + e.getMessage());
        } finally {
            sqldb.endTransaction();
        }
    }

    /**
     * Method to downgrade version in db, delete and create all database
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    /**
     * Override method to open database and set foreign keys ON
     * @param db database to open
     */
    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.JELLY_BEAN)
                db.setForeignKeyConstraintsEnabled(true);
            else
                db.execSQL("PRAGMA foreign_keys=ON");
        }
    }
    //endregion
}
