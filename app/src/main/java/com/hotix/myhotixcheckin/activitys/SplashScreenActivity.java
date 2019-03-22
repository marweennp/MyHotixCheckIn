package com.hotix.myhotixcheckin.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;

import com.hotix.myhotixcheckin.R;
import com.hotix.myhotixcheckin.helpers.MySettings;
import com.hotix.myhotixcheckin.models.HotelSettings;
import com.hotix.myhotixcheckin.retrofit2.RetrofitClient;
import com.hotix.myhotixcheckin.retrofit2.RetrofitInterface;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.hotix.myhotixcheckin.helpers.ConstantConfig.FINAL_APP_ID;
import static com.hotix.myhotixcheckin.helpers.Utils.setBaseUrl;
import static com.hotix.myhotixcheckin.helpers.Utils.stringEmptyOrNull;

public class SplashScreenActivity extends AppCompatActivity {

    private static final String TAG = "SplashScreenActivity";

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 2000;
    // Butter Knife BindViews
    @BindView(R.id.img_splash_screen_logo)
    AppCompatImageView imgLogo;
    @BindView(R.id.tv_splash_screen_footer)
    AppCompatTextView tvFooter;

    private MySettings mMySettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        ButterKnife.bind(this);
        //settings
        mMySettings = new MySettings(getApplicationContext());
        //load logo img
        //Picasso.get().load(R.drawable.logo).fit().placeholder(R.drawable.logo).into(imgLogo);

        if (mMySettings.getConfigured() && mMySettings.getAutoUpdate()) {
            UpdateHotelInfos(mMySettings.getHotelCode());
        } else {
            startDelay();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        setBaseUrl(this);
    }

    /**********************************************************************************************/

    private void startDelay() {

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                Intent i = new Intent(SplashScreenActivity.this, HomeActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
                finish();

            }
        }, SPLASH_TIME_OUT);

    }

    /**********************************************************************************************/

    public void UpdateHotelInfos(String code) {

        RetrofitInterface service = RetrofitClient.getHotixSupportApi().create(RetrofitInterface.class);
        Call<HotelSettings> userCall = service.getInfosQuery(code, FINAL_APP_ID);

        userCall.enqueue(new Callback<HotelSettings>() {
            @Override
            public void onResponse(Call<HotelSettings> call, Response<HotelSettings> response) {

                if (response.raw().code() == 200) {
                    HotelSettings hotelSettings = response.body();

                    //Get Public IP
                    if (!stringEmptyOrNull(hotelSettings.getIPPublic())) {
                        mMySettings.setPublicIp(hotelSettings.getIPPublic());
                        mMySettings.setPublicBaseUrl("http://" + hotelSettings.getIPPublic() + "/");
                        mMySettings.setPublicIpEnabled(true);
                    } else {
                        mMySettings.setPublicIp("xxx.xxx.xxx.xxx");
                        mMySettings.setPublicBaseUrl("http://xxx.xxx.xxx.xxx/");
                        mMySettings.setPublicIpEnabled(false);
                    }

                    //Get Local IP
                    if (!stringEmptyOrNull(hotelSettings.getIPLocal())) {
                        mMySettings.setLocalIp(hotelSettings.getIPLocal());
                        mMySettings.setLocalBaseUrl("http://" + hotelSettings.getIPLocal() + "/");
                        mMySettings.setLocalIpEnabled(true);
                    } else {
                        mMySettings.setLocalIp("xxx.xxx.xxx.xxx");
                        mMySettings.setLocalBaseUrl("http://xxx.xxx.xxx.xxx/");
                        mMySettings.setLocalIpEnabled(false);
                    }

                    //Get Hotel ID
                    if (!stringEmptyOrNull(hotelSettings.getCode())) {
                        mMySettings.setHotelCode(hotelSettings.getCode());
                    } else {
                        mMySettings.setHotelCode("0000");
                    }

                    //Get Hotel Name
                    if (!stringEmptyOrNull(hotelSettings.getName())) {
                        mMySettings.setHotelName(hotelSettings.getName());
                    } else {
                        mMySettings.setHotelName("MY HOTEL");
                    }

                    mMySettings.setSettingsUpdated(true);

                } else {
                    mMySettings.setSettingsUpdated(false);
                }
                startDelay();
            }

            @Override
            public void onFailure(Call<HotelSettings> call, Throwable t) {
                mMySettings.setSettingsUpdated(false);
                startDelay();
            }
        });

    }

}


