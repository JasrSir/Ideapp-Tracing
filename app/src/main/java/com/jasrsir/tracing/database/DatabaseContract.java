package com.jasrsir.tracing.database;

import android.provider.BaseColumns;

/**
 * Created by jasrsir on 29/01/17.
 * This class keep the SCHEMA of data i DATABASE
 */

public class DatabaseContract {

    private DatabaseContract(){

    }

    //region Tables Business, Professional, User
    /**
     * Class to define Business Table
     */
    public static class BusinessEntry implements BaseColumns {
        //region COLUMNS
        public static final String TABLE_NAME = "business";
        public static final String COLUMN_UCB = "ucb";
        public static final String COLUMN_SOCIALNAME = "name";
        public static final String COLUMN_ADDRESS = "address";
        public static final String COLUMN_EMAIL = "email";
        public static final String COLUMN_PHONE = "phone";
        public static final String COLUMN_ID_ZONE = "zone_id";
        public static final String COLUMN_PROFILEBACK = "profileb";
        public static final String COLUMN_PROFILEPRE = "profilep";

        public static final String REFERENCE_ID_ZONE = String.format("REFERENCES %s (%s) ON UPDATE CASCADE ON DELETE RESTRICT,", ZonesEntry.TABLE_NAME,BaseColumns._ID);
        public static final String[] ALL_COLUMNS = new String[]{BaseColumns._ID ,COLUMN_UCB,COLUMN_SOCIALNAME,COLUMN_ADDRESS, COLUMN_EMAIL, COLUMN_PHONE, COLUMN_ID_ZONE, COLUMN_PROFILEBACK, COLUMN_PROFILEPRE};
        //endregion
        //region SQLquery
        public static final String SQL_CREATE_ENTRIES = String.format(
                "CREATE TABLE IF NOT EXISTS %s (" +
                        "%s TEXT PRIMARY KEY," +
                        "%s TEXT NOT NULL," +
                        "%s TEXT NOT NULL," +
                        "%s TEXT NOT NULL," +
                        "%s TEXT NOT NULL," +
                        "%s INTEGER NOT NULL %s" +
                        "%s BLOB NULL," +
                        "%s BLOB NULL )"
                ,TABLE_NAME, COLUMN_UCB,COLUMN_SOCIALNAME,COLUMN_ADDRESS,COLUMN_EMAIL, COLUMN_PHONE,COLUMN_ID_ZONE,REFERENCE_ID_ZONE, COLUMN_PROFILEBACK, COLUMN_PROFILEPRE
        );

        public static final String SQL_DELETE_ENTRIES = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);

        //endregion
    }

    /**
     * Class to define Professional Table
     */
    public static class ProfessionalEntry implements BaseColumns {
        //region COLUMNS
        public static final String TABLE_NAME = "professional";
        public static final String COLUMN_UCP = "ucp";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_SURNAME = "surname";
        public static final String COLUMN_EMAIL = "email";
        public static final String COLUMN_PHONE = "phone";
        public static final String COLUMN_ID_ZONE = "zone_id";
        public static final String COLUMN_PROFILEBACK = "profileb";
        public static final String COLUMN_PROFILEPRE = "profilep";

        public static final String REFERENCE_ID_ZONE = String.format("REFERENCES %s (%s) ON UPDATE CASCADE ON DELETE RESTRICT,", ZonesEntry.TABLE_NAME,BaseColumns._ID);
        public static final String[] ALL_COLUMNS = new String[]{ BaseColumns._ID ,COLUMN_UCP,COLUMN_NAME,COLUMN_SURNAME, COLUMN_EMAIL, COLUMN_PHONE, COLUMN_ID_ZONE, COLUMN_PROFILEBACK, COLUMN_PROFILEPRE};
        //endregion
        //region SQLquery
        public static final String SQL_CREATE_ENTRIES = String.format(
                "CREATE TABLE IF NOT EXISTS %s (" +
                        "%s TEXT PRIMARY KEY," +
                        "%s TEXT NOT NULL," +
                        "%s TEXT NOT NULL," +
                        "%s TEXT NOT NULL," +
                        "%s TEXT NOT NULL," +
                        "%s INTEGER NOT NULL %s" +
                        "%s BLOB NULL," +
                        "%s BLOB NULL )"
                ,TABLE_NAME, COLUMN_UCP,COLUMN_NAME,COLUMN_SURNAME,COLUMN_EMAIL, COLUMN_PHONE,COLUMN_ID_ZONE,REFERENCE_ID_ZONE, COLUMN_PROFILEBACK, COLUMN_PROFILEPRE
        );

        public static final String SQL_DELETE_ENTRIES = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);

        //endregion
    }

    /**
     * Class to define User Table
     */
    public static class UsersEntry implements BaseColumns {
        //region COLUMNS
        public static final String TABLE_NAME = "users";
        public static final String COLUMN_UCU = "ucu";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_SURNAME = "surname";
        public static final String COLUMN_EMAIL = "email";
        public static final String COLUMN_PHONE = "phone";
        public static final String COLUMN_PROFILEBACK = "profileb";
        public static final String COLUMN_PROFILEPRE = "profilep";

        public static final String[] ALL_COLUMNS = new String[]{ BaseColumns._ID ,COLUMN_UCU,COLUMN_NAME,COLUMN_SURNAME, COLUMN_EMAIL, COLUMN_PHONE, COLUMN_PROFILEBACK, COLUMN_PROFILEPRE};
        //endregion
        //region SQLquery
        public static final String SQL_CREATE_ENTRIES = String.format(
                "CREATE TABLE IF NOT EXISTS %s (" +
                        "%s TEXT PRIMARY KEY," +
                        "%s TEXT NOT NULL," +
                        "%s TEXT NOT NULL," +
                        "%s TEXT NOT NULL," +
                        "%s TEXT NOT NULL," +
                        "%s BLOB NULL," +
                        "%s BLOB NULL )"
                ,TABLE_NAME, COLUMN_UCU,COLUMN_NAME,COLUMN_SURNAME,COLUMN_EMAIL, COLUMN_PHONE, COLUMN_PROFILEBACK, COLUMN_PROFILEPRE
        );

        public static final String SQL_DELETE_ENTRIES = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);

        //endregion
    }
    //endregion

    //region FKs
    /**
     * Class to define Zones Table
     */
    public static class ZonesEntry implements BaseColumns {
        //region COLUMNS
        public static final String TABLE_NAME = "zones";
        public static final String COLUMN_NAME = "name";

        public static final String[] ALL_COLUMNS = new String[]{BaseColumns._ID, COLUMN_NAME};
        //endregion
        //region SQLquery
        public static final String SQL_CREATE_ENTRIES = String.format(
                "CREATE TABLE IF NOT EXISTS %s (" +
                        "%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "%s TEXT NOT NULL)"
                , TABLE_NAME, BaseColumns._ID, COLUMN_NAME
        );

        public static final String SQL_DELETE_ENTRIES = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);
        //endregion
    }

    /**
     * Class to define Business-Professional Relationship Table
     */
    public static class Business_ProfessionalEntry implements BaseColumns {
        //region COLUMNS
        public static final String TABLE_NAME = "business_professional";
        public static final String COLUMN_UCB = "ucb";
        public static final String COLUMN_UCP = "ucp";

        public static final String REFERENCE_UCB = String.format("REFERENCES %s (%s) ON UPDATE CASCADE ON DELETE RESTRICT,", BusinessEntry.TABLE_NAME,BusinessEntry.COLUMN_UCB);
        public static final String REFERENCE_UCP = String.format("REFERENCES %s (%s) ON UPDATE CASCADE ON DELETE RESTRICT", ProfessionalEntry.TABLE_NAME,ProfessionalEntry.COLUMN_UCP);

        public static final String[] ALL_COLUMNS = new String[]{ BaseColumns._ID ,COLUMN_UCB,COLUMN_UCP};
        //endregion
        //region SQLquery
        public static final String SQL_CREATE_ENTRIES = String.format(
                "CREATE TABLE IF NOT EXISTS %s (" +
                        "%s TEXT %s" +
                        "%s TEXT %s)"
                , TABLE_NAME, COLUMN_UCB, REFERENCE_UCB, COLUMN_UCP,REFERENCE_UCP
        );

        public static final String SQL_DELETE_ENTRIES = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);
        //endregion
    }

    /**
     * Class to define Professional-users Relationship Table
     */
    public static class Professional_UsersEntry implements BaseColumns {
        //region COLUMNS
        public static final String TABLE_NAME = "professional_user";
        public static final String COLUMN_UCP = "ucp";
        public static final String COLUMN_UCU = "ucu";

        public static final String REFERENCE_UCP = String.format("REFERENCES %s (%s) ON UPDATE CASCADE ON DELETE RESTRICT,", ProfessionalEntry.TABLE_NAME,ProfessionalEntry.COLUMN_UCP);
        public static final String REFERENCE_UCU = String.format("REFERENCES %s (%s) ON UPDATE CASCADE ON DELETE RESTRICT", UsersEntry.TABLE_NAME, UsersEntry.COLUMN_UCU);

        public static final String[] ALL_COLUMNS = new String[]{ BaseColumns._ID ,COLUMN_UCP,COLUMN_UCU};
        //endregion
        //region SQLquery
        public static final String SQL_CREATE_ENTRIES = String.format(
                "CREATE TABLE IF NOT EXISTS %s (" +
                        "%s TEXT %s" +
                        "%s TEXT %s)"
                , TABLE_NAME, COLUMN_UCP, REFERENCE_UCP, COLUMN_UCU, REFERENCE_UCU
        );

        public static final String SQL_DELETE_ENTRIES = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);
        //endregion
    }
    //endregion

    //region ACTIONS TABLES

    /**
     * Class to define NOTES Table
     */
    public static class NotesEntry implements BaseColumns {
        //region COLUMNS
        public static final String TABLE_NAME = "notes";
        public static final String COLUMN_NOTECODE = "notecode";
        public static final String COLUMN_SENDER = "sender";
        public static final String COLUMN_RECEIVER = "receiver";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_NOTE = "note";

        public static final String[] ALL_COLUMNS = new String[]{ BaseColumns._ID ,COLUMN_NOTECODE,COLUMN_SENDER,COLUMN_RECEIVER, COLUMN_TITLE,COLUMN_NOTE};
        //endregion
        //region SQLquery
        public static final String SQL_CREATE_ENTRIES = String.format(
                "CREATE TABLE IF NOT EXISTS %s (" +
                        "%s TEXT NOT NULL PRIMARY KEY," +
                        "%s TEXT NOT NULL," +
                        "%s TEXT NOT NULL," +
                        "%s TEXT NOT NULL," +
                        "%s TEXT NOT NULL)"
                , TABLE_NAME, COLUMN_NOTECODE,COLUMN_SENDER,COLUMN_RECEIVER,COLUMN_TITLE, COLUMN_NOTE
        );

        public static final String SQL_DELETE_ENTRIES = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);
        //endregion
    }

    /**
     * Class to define ACTIONS Table
     */
    public static class ActionsEntry implements BaseColumns {
        //region COLUMNS
        public static final String TABLE_NAME = "actions";
        public static final String COLUMN_ACTIONCODE = "actioncode";
        public static final String COLUMN_SENDER = "sender";
        public static final String COLUMN_RECEIVER = "receiver";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_SUMMARY = "summary";
        public static final String COLUMN_REPETITION = "repetition";
        public static final String COLUMN_DURATION = "duration";

        public static final String[] ALL_COLUMNS = new String[]{BaseColumns._ID , COLUMN_ACTIONCODE,COLUMN_SENDER,COLUMN_RECEIVER, COLUMN_TITLE,COLUMN_SUMMARY, COLUMN_REPETITION, COLUMN_DURATION};
        //endregion
        //region SQLquery
        public static final String SQL_CREATE_ENTRIES = String.format(
                "CREATE TABLE IF NOT EXISTS %s (" +
                        "%s TEXT NOT NULL PRIMARY KEY," +
                        "%s TEXT NOT NULL," +
                        "%s TEXT NOT NULL," +
                        "%s TEXT NOT NULL," +
                        "%s TEXT NOT NULL," +
                        "%s TEXT NOT NULL," +
                        "%s TEXT NOT NULL)"
                , TABLE_NAME, COLUMN_ACTIONCODE,COLUMN_SENDER,COLUMN_RECEIVER,COLUMN_TITLE, COLUMN_SUMMARY, COLUMN_REPETITION,COLUMN_DURATION
        );

        public static final String SQL_DELETE_ENTRIES = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);
        //endregion
    }

    /**
     * Class to define LINKS Table
     */
    public static class LinksEntry implements BaseColumns {
        //region COLUMNS
        public static final String TABLE_NAME = "links";
        public static final String COLUMN_LINKCODE = "linkcode";
        public static final String COLUMN_SENDER = "sender";
        public static final String COLUMN_RECEIVER = "receiver";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_LINK = "link";

        public static final String[] ALL_COLUMNS = new String[]{ BaseColumns._ID ,COLUMN_LINKCODE,COLUMN_SENDER,COLUMN_RECEIVER, COLUMN_TITLE, COLUMN_LINK};
        //endregion
        //region SQLquery
        public static final String SQL_CREATE_ENTRIES = String.format(
                "CREATE TABLE IF NOT EXISTS %s (" +
                        "%s TEXT NOT NULL PRIMARY KEY," +
                        "%s TEXT NOT NULL," +
                        "%s TEXT NOT NULL," +
                        "%s TEXT NOT NULL," +
                        "%s TEXT NOT NULL)"
                , TABLE_NAME, BaseColumns._ID, COLUMN_LINKCODE,COLUMN_SENDER,COLUMN_RECEIVER,COLUMN_TITLE, COLUMN_LINK
        );

        public static final String SQL_DELETE_ENTRIES = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);
        //endregion
    }

    /**
     * Class to define DATES Table
     */
    public static class DatesEntry implements BaseColumns {
        //region COLUMNS
        public static final String TABLE_NAME = "dates";
        public static final String COLUMN_DATECODE = "datecode";
        public static final String COLUMN_SENDER = "sender";
        public static final String COLUMN_RECEIVER = "receiver";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_CITEDATE = "citedate";
        public static final String COLUMN_HOURSTART = "hourstart";
        public static final String COLUMN_HOUREND = "hourend";
        public static final String COLUMN_SUMMARY = "summary";


        public static final String[] ALL_COLUMNS = new String[]{ BaseColumns._ID ,COLUMN_DATECODE,COLUMN_SENDER,COLUMN_RECEIVER, COLUMN_TITLE,COLUMN_CITEDATE,COLUMN_HOURSTART, COLUMN_HOUREND, COLUMN_SUMMARY};
        //endregion
        //region SQLquery
        public static final String SQL_CREATE_ENTRIES = String.format(
                "CREATE TABLE IF NOT EXISTS %s (" +
                        "%s TEXT NOT NULL PRIMARY KEY," +
                        "%s TEXT NOT NULL," +
                        "%s TEXT NOT NULL," +
                        "%s TEXT NOT NULL," +
                        "%s TEXT NOT NULL," +
                        "%s TEXT NOT NULL," +
                        "%s TEXT NOT NULL," +
                        "%s TEXT NOT NULL)"
                , TABLE_NAME, COLUMN_DATECODE,COLUMN_SENDER,COLUMN_RECEIVER,COLUMN_TITLE, COLUMN_CITEDATE, COLUMN_HOURSTART, COLUMN_HOUREND, COLUMN_SUMMARY
        );

        public static final String SQL_DELETE_ENTRIES = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);
        //endregion
    }

    //endregion
}

