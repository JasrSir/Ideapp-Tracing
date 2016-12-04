package com.jasrsir.tracing.pojo;

/**
 * Created by Jasrsir on 04/12/2016.
 */

public class Error {
    public static final int OK=0;
    public static final int DATA_EMPTY = 10;
    public static final int PASSWORD_DIGIT=11;
    public static final int PASSWORD_CASE=12;
    public static final int PASSWORD_LENGTH=13;
    public static final int EMAIL_INVALID = 14;
    public static final int PHONE_INVALID = 15;
    public static final int CIF_INVALID = 16;
    public static final int SIGNIN = 17;
    public static int code;
    public static String message;
    // Inicializar valores static
    static {

    }
}
