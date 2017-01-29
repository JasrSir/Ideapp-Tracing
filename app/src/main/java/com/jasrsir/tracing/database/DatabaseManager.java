package com.jasrsir.tracing.database;

import com.jasrsir.tracing.pojo.pojoevent.Note;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jasrsir on 29/01/17.
 */

public class DatabaseManager {

    //region objects
    private static DatabaseManager mInstance;

    //endregion

    private DatabaseManager(){}


    public static DatabaseManager getInstance(){
        if (mInstance == null)
            mInstance = new DatabaseManager();
        return mInstance;
    }

    //region DATESMANAGER

    public List<Note> getAllNotes(){

        ArrayList<Note> mNotes = new ArrayList<>();

        return mNotes;
    }


    //endregion
}
