package com.jasrsir.tracing.provider;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by jasrsir on 8/02/17.
 * This class contains Application Content Provider
 */

public class TracingContract {

    //region Authority and Autho_URI
    public static final String AUTHORITY = "com.jasrsir.tracing"; //Package for Content Provider
    public static final Uri AUTHORITY_URI = Uri.parse("content://"+AUTHORITY);

    //endregion


    //region Content Provider Business, Professional, User
    /**
     * Class to define Business CP
     */
    public static class Business implements BaseColumns {
        //region COLUMNS
        public static final String CONTENT_PATH = "business";
        public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI,CONTENT_PATH);
        public static final String UCB = "ucb";
        public static final String SOCIALNAME = "name";
        public static final String ADDRESS = "address";
        public static final String EMAIL = "email";
        public static final String PHONE = "phone";
        public static final String ZONE_ID = "zone_id";
        public static final String PROFILEBACK = "profileb";
        public static final String PROFILEPRE = "profilep";

        public static final String[] PROYECTION = new String[]{ UCB,SOCIALNAME,ADDRESS, EMAIL, PHONE, ZONE_ID, PROFILEBACK, PROFILEPRE};

        //endregion
    }

    /**
     * Class to define Professional CP
     */
    public static class Professional implements BaseColumns {
        //region COLUMNS
        public static final String CONTENT_PATH = "professional";
        public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI,CONTENT_PATH);
        public static final String UCP = "ucp";
        public static final String NAME = "name";
        public static final String SURNAME = "surname";
        public static final String EMAIL = "email";
        public static final String PHONE = "phone";
        public static final String ZONE_ID = "zone_id";
        public static final String PROFILEBACK = "profileb";
        public static final String PROFILEPRE = "profilep";

        public static final String[] PROYECTION = new String[]{ UCP,NAME,SURNAME, EMAIL, PHONE, ZONE_ID, PROFILEBACK, PROFILEPRE};
        //endregion

    }

    /**
     * Class to define User CP
     */
    public static class Users implements BaseColumns {
        //region COLUMNS
        public static final String CONTENT_PATH = "users";
        public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI,CONTENT_PATH);
        public static final String UCU = "ucu";
        public static final String NAME = "name";
        public static final String SURNAME = "surname";
        public static final String EMAIL = "email";
        public static final String PHONE = "phone";
        public static final String PROFILEBACK = "profileb";
        public static final String PROFILEPRE = "profilep";

        public static final String[] PROYECTION = new String[]{ UCU,NAME,SURNAME, EMAIL, PHONE, PROFILEBACK, PROFILEPRE};
        //endregion

    }
    //endregion

    //region FKs
    /**
     * Class to define Zones CP
     */
    public static class Zones implements BaseColumns {
        //region COLUMNS
        public static final String CONTENT_PATH = "zones";
        public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI,CONTENT_PATH);

        public static final String NAME = "name";

        public static final String[] PROYECTION = new String[]{BaseColumns._ID, NAME};
        //endregion
    }

    /**
     * Class to define Business-Professional Relationship CP
     */
    public static class Business_Professional implements BaseColumns {
        //region COLUMNS
        public static final String CONTENT_PATH = "business_professional";
        public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI,CONTENT_PATH);

        public static final String UCB = "ucb";
        public static final String UCP = "ucp";

        public static final String[] PROYECTION = new String[]{ UCB,UCP};
        //endregion

    }

    /**
     * Class to define Professional-users Relationship CP
     */
    public static class Professional_Users implements BaseColumns {
        //region COLUMNS
        public static final String CONTENT_PATH = "professional_user";
        public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI,CONTENT_PATH);

        public static final String UCP = "ucp";
        public static final String UCU = "ucu";

        public static final String[] PROYECTION = new String[]{ UCP,UCU};
        //endregion

    }
    //endregion

    //region ACTIONS CP

    /**
     * Class to define NOTES CP
     */
    public static class Notes implements BaseColumns {
        //region COLUMNS
        public static final String CONTENT_PATH = "notes";
        public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI,CONTENT_PATH);
        public static final String NOTECODE = "notecode";
        public static final String SENDER = "sender";
        public static final String RECEIVER = "receiver";
        public static final String TITLE = "title";
        public static final String NOTE = "note";

        public static final String[] PROYECTION = new String[]{ NOTECODE,SENDER,RECEIVER, TITLE,NOTE};
        //endregion

    }

    /**
     * Class to define ACTIONS CP
     */
    public static class Actions implements BaseColumns {
        //region COLUMNS
        public static final String CONTENT_PATH = "actions";
        public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI,CONTENT_PATH);
        public static final String ACTIONCODE = "actioncode";
        public static final String SENDER = "sender";
        public static final String RECEIVER = "receiver";
        public static final String TITLE = "title";
        public static final String SUMMARY = "summary";
        public static final String REPETITION = "repetition";
        public static final String DURATION = "duration";

        public static final String[] PROYECTION = new String[]{ ACTIONCODE,SENDER,RECEIVER, TITLE,SUMMARY, REPETITION, DURATION};
        //endregion
    }

    /**
     * Class to define LINKS CP
     */
    public static class Links implements BaseColumns {
        //region COLUMNS
        public static final String CONTENT_PATH = "links";
        public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI,CONTENT_PATH);
        public static final String LINKCODE = "linkcode";
        public static final String SENDER = "sender";
        public static final String RECEIVER = "receiver";
        public static final String TITLE = "title";
        public static final String LINK = "link";

        public static final String[] PROYECTION = new String[]{ LINKCODE,SENDER,RECEIVER, TITLE, LINK};
        //endregion
    }

    /**
     * Class to define DATES CP
     */
    public static class Dates implements BaseColumns {
        //region COLUMNS
        public static final String CONTENT_PATH = "dates";
        public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI,CONTENT_PATH);
        public static final String DATECODE = "datecode";
        public static final String SENDER = "sender";
        public static final String RECEIVER = "receiver";
        public static final String TITLE = "title";
        public static final String CITEDATE = "citedate";
        public static final String HOURSTART = "hourstart";
        public static final String HOUREND = "hourend";
        public static final String SUMMARY = "summary";


        public static final String[] PROYECTION = new String[]{ DATECODE,SENDER,RECEIVER, TITLE,CITEDATE,HOURSTART, HOUREND, SUMMARY};
        //endregion
    }

    //endregion
}
