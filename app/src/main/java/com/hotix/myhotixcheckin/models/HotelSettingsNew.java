package com.hotix.myhotixcheckin.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HotelSettingsNew {

    @SerializedName("Hotel_ID")
    @Expose
    private Integer hotel_ID;

    @SerializedName("Hotel_Code")
    @Expose
    private String hotel_Code;

    @SerializedName("Hotel_Name")
    @Expose
    private String hotel_Name;

    @SerializedName("Hotel_IP_Local")
    @Expose
    private String hotel_IP_Local;

    @SerializedName("Hotel_IP_Public")
    @Expose
    private String hotel_IP_Public;

    @SerializedName("Hotel_Latitude")
    @Expose
    private String hotel_Latitude;

    @SerializedName("Hotel_Longitude")
    @Expose
    private String hotel_Longitude;

    @SerializedName("Hotel_Logo")
    @Expose
    private String hotel_Logo;

    @SerializedName("Application_Version")
    @Expose
    private String application_Version;

    @SerializedName("API_Version")
    @Expose
    private String API_Version;

    @SerializedName("Projet")
    @Expose
    private String projet;

    @SerializedName("Hotel_Is_Active")
    @Expose
    private Boolean hotel_Is_Active;

    @SerializedName("Hotel_Is_Visible")
    @Expose
    private Boolean hotel_Is_Visible;

    @SerializedName("Authorized_Devices_Is_Active")
    @Expose
    private Boolean authorized_Devices_Is_Active;

    @SerializedName("Application_Is_Active")
    @Expose
    private Boolean application_Is_Active;

    public Integer getHotelID() {
        return hotel_ID;
    }
    public void setHotelID(Integer hotel_ID) {
        this.hotel_ID = hotel_ID;
    }

    public String getHotelCode() {
        return hotel_Code;
    }
    public void setHotelCode(String hotel_Code) {
        this.hotel_Code = hotel_Code;
    }

    public String getHotelName() {
        return hotel_Name;
    }
    public void setHotelName(String hotel_Name) {
        this.hotel_Name = hotel_Name;
    }

    public String getHotelIPLocal() {
        return hotel_IP_Local;
    }
    public void setHotelIPLocal(String hotel_IP_Local) {
        this.hotel_IP_Local = hotel_IP_Local;
    }

    public String getHotelIPPublic() {
        return hotel_IP_Public;
    }
    public void setHotelIPPublic(String hotel_IP_Public) {
        this.hotel_IP_Public = hotel_IP_Public;
    }

    public String getHotelLatitude() {
        return hotel_Latitude;
    }
    public void setHotelLatitude(String hotel_Latitude) {
        this.hotel_Latitude = hotel_Latitude;
    }

    public String getHotelLongitude() {
        return hotel_Longitude;
    }
    public void setHotelLongitude(String hotel_Longitude) {
        this.hotel_Longitude = hotel_Longitude;
    }

    public String getHotelLogo() {
        return hotel_Logo;
    }
    public void setHotelLogo(String hotel_Logo) {
        this.hotel_Logo = hotel_Logo;
    }

    public String getApplicationVersion() {
        return application_Version;
    }
    public void setApplicationVersion(String application_Version) {
        this.application_Version = application_Version;
    }

    public String getAPIVersion() {
        return API_Version;
    }
    public void setAPIVersion(String API_Version) {
        this.API_Version = API_Version;
    }

    public String getProjet() {
        return projet;
    }
    public void setProjet(String projet) {
        this.projet = projet;
    }

    public Boolean getHotelIsActive() {
        return hotel_Is_Active;
    }
    public void setHotelIsActive(Boolean hotel_Is_Active) {
        this.hotel_Is_Active = hotel_Is_Active;
    }

    public Boolean getHotelIsVisible() {
        return hotel_Is_Visible;
    }
    public void setHotelIsVisible(Boolean appIsActive) {
        this.hotel_Is_Visible = hotel_Is_Visible;
    }

    public Boolean getAuthorizedDevicesIsActive() {
        return authorized_Devices_Is_Active;
    }
    public void setAuthorizedDevicesIsActive(Boolean authorized_Devices_Is_Active) {
        this.authorized_Devices_Is_Active = authorized_Devices_Is_Active;
    }

    public Boolean getApplicationIsActive() {
        return application_Is_Active;
    }
    public void setApplicationIsActive(Boolean application_Is_Active) {
        this.application_Is_Active = application_Is_Active;
    }

}
