package com.hotix.myhotixcheckin.helpers;

import com.hotix.myhotixcheckin.models.Pax;
import com.hotix.myhotixcheckin.models.StartData;

import java.util.ArrayList;

public class ConstantConfig {

    /********************** *****************( Final )************************  *******************/
    //FINAL BASE URL
    public static final String FINAL_BASE_URL = "http://41.228.21.123:99/";
    //public static final String FINAL_BASE_URL = "http://192.168.0.6:99/";

    //FINAL App Id
    public static final String FINAL_APP_ID = "3";

    /***************************************(Non Final )*******************************************/
    //BASE URL
    public static String BASE_URL = "";

    // HNGAPI version
    public static String API_VERSION = "v0";

    //Pax List Global
    public static ArrayList<Pax> GLOBAL_PAX_LIST = new ArrayList<>();

    //this will be loaded on app startup
    public static StartData GLOBAL_START_DATA = new StartData();

}
