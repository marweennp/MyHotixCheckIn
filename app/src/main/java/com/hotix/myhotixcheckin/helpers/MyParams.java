package com.hotix.myhotixcheckin.helpers;

import android.content.Context;
import android.content.SharedPreferences;

public class MyParams {

    //Shared Preferences Keys
    // Booleans
    public static final String KEY_FIRST_NAME = "firstName";
    public static final String KEY_LAST_NAME = "lastName";
    public static final String KEY_GENDER = "gender";
    public static final String KEY_BIRTHDAY = "birthday";
    public static final String KEY_FAMILY_SITUATION = "familySituation";
    public static final String KEY_PHONE = "phone";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_ADDRESS = "address";
    public static final String KEY_COUNTRY = "country";
    public static final String KEY_POSTAL_CODE = "postalCode";
    public static final String KEY_CITY = "city";
    public static final String KEY_PROFESSION = "profession";
    public static final String KEY_TYPE_DOC_ID = "typeDocId";
    public static final String KEY_HANDICAP = "handicap";
    public static final String KEY_SMOKER = "smoker";

    // Sharedpref file name
    private static final String PREF_NAME = "CheckInParams";
    // Shared Preferences
    SharedPreferences pref;
    // Editor for Shared preferences
    SharedPreferences.Editor editor;
    // Context
    Context _context;
    // Shared pref mode
    int PRIVATE_MODE = 0;


    // Constructor
    public MyParams(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    /**********************************(  Getters & Setters )**************************************/
    // Booleans
    public boolean getFirstName() {
        return pref.getBoolean(KEY_FIRST_NAME, true);
    }

    public void setFirstName(boolean firstName) {
        editor.putBoolean(KEY_FIRST_NAME, firstName);
        editor.commit();
    }

    public boolean getlastName() {
        return pref.getBoolean(KEY_LAST_NAME, true);
    }

    public void setLastName(boolean lastName) {
        editor.putBoolean(KEY_LAST_NAME, lastName);
        editor.commit();
    }

    public boolean getGender() {
        return pref.getBoolean(KEY_GENDER, true);
    }

    public void setGender(boolean gender) {
        editor.putBoolean(KEY_GENDER, gender);
        editor.commit();
    }

    public boolean getBirthDay() {
        return pref.getBoolean(KEY_BIRTHDAY, true);
    }

    public void setBirthDay(boolean birthday) {
        editor.putBoolean(KEY_BIRTHDAY, birthday);
        editor.commit();
    }

    public boolean getFamilySituation() {
        return pref.getBoolean(KEY_FAMILY_SITUATION, true);
    }

    public void setFamilySituation(boolean familySituation) {
        editor.putBoolean(KEY_FAMILY_SITUATION, familySituation);
        editor.commit();
    }

    public boolean getPhone() {
        return pref.getBoolean(KEY_PHONE, true);
    }

    public void setPhone(boolean phone) {
        editor.putBoolean(KEY_PHONE, phone);
        editor.commit();
    }

    public boolean getEmail() {
        return pref.getBoolean(KEY_EMAIL, true);
    }

    public void setEmail(boolean email) {
        editor.putBoolean(KEY_EMAIL, email);
        editor.commit();
    }

    public boolean getAddress() {
        return pref.getBoolean(KEY_ADDRESS, true);
    }

    public void setAddress(boolean address) {
        editor.putBoolean(KEY_ADDRESS, address);
        editor.commit();
    }

    public boolean getCountry() {
        return pref.getBoolean(KEY_COUNTRY, true);
    }

    public void setCountry(boolean country) {
        editor.putBoolean(KEY_COUNTRY, country);
        editor.commit();
    }

    public boolean getPostalCode() {
        return pref.getBoolean(KEY_POSTAL_CODE, true);
    }

    public void setPostalCode(boolean postalCode) {
        editor.putBoolean(KEY_POSTAL_CODE, postalCode);
        editor.commit();
    }

    public boolean getCity() {
        return pref.getBoolean(KEY_CITY, true);
    }

    public void setCity(boolean city) {
        editor.putBoolean(KEY_CITY, city);
        editor.commit();
    }

    public boolean getProfession() {
        return pref.getBoolean(KEY_PROFESSION, true);
    }

    public void setProfession(boolean profession) {
        editor.putBoolean(KEY_PROFESSION, profession);
        editor.commit();
    }

    public boolean getTypeDocId() {
        return pref.getBoolean(KEY_TYPE_DOC_ID, true);
    }

    public void setTypeDocId(boolean typeDocId) {
        editor.putBoolean(KEY_TYPE_DOC_ID, typeDocId);
        editor.commit();
    }

    public boolean getHandicap() {
        return pref.getBoolean(KEY_HANDICAP, true);
    }

    public void setHandicap(boolean handicap) {
        editor.putBoolean(KEY_HANDICAP, handicap);
        editor.commit();
    }

    public boolean getSmoker() {
        return pref.getBoolean(KEY_SMOKER, true);
    }

    public void setSmoker(boolean smoker) {
        editor.putBoolean(KEY_SMOKER, smoker);
        editor.commit();
    }

    /*****************************************(  _______  )****************************************/
    //Clear MySettings details
    public void clearSettingsDetails() {
        // Clearing all data from Shared Preferences
        editor.clear();
        editor.commit();
    }


}
