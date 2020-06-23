package com.hotix.myhotixcheckin.retrofit2;

import com.hotix.myhotixcheckin.models.HotelSettings;
import com.hotix.myhotixcheckin.models.HotelSettingsNew;
import com.hotix.myhotixcheckin.models.Pax;
import com.hotix.myhotixcheckin.models.ResponseMsg;
import com.hotix.myhotixcheckin.models.StartData;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;

import static com.hotix.myhotixcheckin.helpers.ConstantConfig.API_VERSION;

public interface RetrofitInterface {

    /***
     ** GET *********************************************************************************************
     **/

    //Is Connected service call
    @GET
    Call<ResponseBody> isConnectedQuery(@Url String URL);

    //Get Infos service call
    @GET("/hotixsupport/api/myhotix/GetInfos?")
    Call<HotelSettings> getInfosQuery(@Query("codehotel") String codehotel,
                                      @Query("applicationId") String applicationId);

    //Get Infos service call
    @GET("/HotixSupportNew/API/Myhotix/GetInfos?")
    Call<HotelSettingsNew> getHotelInfosQuery(@Query("codehotel") String codehotel,
                                              @Query("applicationId") String applicationId);

    //Get Pax Resa service call
    @GET
    Call<ArrayList<Pax>> getPaxResaQuery(@Url String URL,
                                         @Query("resaId") String resaId);

    //Get All Data service call
    @GET
    Call<StartData> getAllDataQuery(@Url String URL);

/***
 ** POST ********************************************************************************************
 **/


//Post UpdateReservationInfos service call
@FormUrlEncoded
@POST
Call<ResponseMsg> updateReservationInfosQuery(@Url String URL,
                                              @Field("clientId") String clientId,
                                              @Field("NomClient") String NomClient,
                                              @Field("PrenomClient") String PrenomClient,
                                              @Field("PaysId") String PaysId,
                                              @Field("clientAdresse") String clientAdresse,
                                              @Field("DateNaiss") String DateNaiss,
                                              @Field("LieuNaiss") String LieuNaiss,
                                              @Field("Sexe") String Sexe,
                                              @Field("SitFam") String SitFam,
                                              @Field("Fumeur") String Fumeur,
                                              @Field("Handicape") String Handicape,
                                              @Field("DocTypeId") String DocTypeId,
                                              @Field("DocIdNum") String DocIdNum,
                                              @Field("Email") String Email,
                                              @Field("Gsm") String Gsm,
                                              @Field("Profession") String Profession,
                                              @Field("Image") String Image,
                                              @Field("civilite") String civilite);
}
