package com.hotix.myhotixcheckin.retrofit2;

import com.hotix.myhotixcheckin.models.HotelSettings;
import com.hotix.myhotixcheckin.models.Pax;
import com.hotix.myhotixcheckin.models.StartData;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static com.hotix.myhotixcheckin.helpers.ConstantConfig.API_VERSION;

public interface RetrofitInterface {

    /***
     ** GET *********************************************************************************************
     **/

    //Is Connected service call
    @GET("/HNGAPI/" + API_VERSION + "/api/MyHotixguest/isconnected")
    Call<ResponseBody> isConnectedQuery();

    //Get Infos service call
    @GET("/hotixsupport/api/myhotix/GetInfos?")
    Call<HotelSettings> getInfosQuery(@Query("codehotel") String codehotel,
                                      @Query("applicationId") String applicationId);

    //Get Pax Resa service call
    @GET("/HNGAPI/" + API_VERSION + "/api/myhotixguest/GetPaxResa?")
    Call<ArrayList<Pax>> getPaxResaQuery(@Query("resaId") String resaId);

    //Get All Data service call
    @GET("/HNGAPI/" + API_VERSION + "/api/myhotixguest/getalldata")
    Call<StartData> getAllDataQuery();

/***
 ** POST ********************************************************************************************
 **/

}
