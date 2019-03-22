package com.hotix.myhotixcheckin.activitys;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.ProgressBar;

import com.hotix.myhotixcheckin.R;
import com.hotix.myhotixcheckin.helpers.InputValidation;
import com.hotix.myhotixcheckin.helpers.MySettings;
import com.hotix.myhotixcheckin.models.HotelSettings;
import com.hotix.myhotixcheckin.models.Pax;
import com.hotix.myhotixcheckin.models.StartData;
import com.hotix.myhotixcheckin.retrofit2.RetrofitClient;
import com.hotix.myhotixcheckin.retrofit2.RetrofitInterface;
import com.hotix.myhotixcheckin.views.kbv.KenBurnsView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.hotix.myhotixcheckin.helpers.ConnectionChecher.checkNetwork;
import static com.hotix.myhotixcheckin.helpers.ConstantConfig.BASE_URL;
import static com.hotix.myhotixcheckin.helpers.ConstantConfig.FINAL_APP_ID;
import static com.hotix.myhotixcheckin.helpers.ConstantConfig.GLOBAL_PAX_LIST;
import static com.hotix.myhotixcheckin.helpers.ConstantConfig.GLOBAL_START_DATA;
import static com.hotix.myhotixcheckin.helpers.Utils.setBaseUrl;
import static com.hotix.myhotixcheckin.helpers.Utils.showSnackbar;
import static com.hotix.myhotixcheckin.helpers.Utils.stringEmptyOrNull;

public class HomeActivity extends AppCompatActivity {

    // Butter Knife BindView
    @BindView(R.id.il_home_resa_num)
    TextInputLayout ilResaNum;
    @BindView(R.id.et_home_resa_num)
    AppCompatEditText etResaNum;
    @BindView(R.id.btn_search)
    AppCompatButton btnSearch;
    @BindView(R.id.pb_search)
    ProgressBar pbSearch;
    @BindView(R.id.tv_home_version)
    AppCompatTextView tvVersion;
    @BindView(R.id.tv_home_hotel_name)
    AppCompatTextView tvHotelName;
    @BindView(R.id.ibtn_home_setting)
    AppCompatImageButton btnSetting;
    @BindView(R.id.ibtn_home_prams)
    AppCompatImageButton btnParams;

    //MySettings
    private MySettings mMySettings;

    private KenBurnsView mKenBurns;
    private InputValidation mInputValidation;

    private TextInputLayout ilHotelCode;
    private AppCompatEditText etHotelCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ButterKnife.bind(this);
        //settings
        mMySettings = new MySettings(getApplicationContext());
        mInputValidation = new InputValidation(this);
        init();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mMySettings.getFirstStart()) {
            startDownloadSettingsDialog();
        }
        setBaseUrl(this);
        loadeImage();
        tvHotelName.setText(mMySettings.getHotelName());
        btnSearch.setEnabled(true);
    }

    @Override
    public void onBackPressed() {
        startExitDialog();
    }


    /**********************************************************************************************/

    @OnClick(R.id.btn_search)
    public void startSearch() {
        if (checkNetwork(this)) {
            if (inputTextValidation()) {
                try {
                    loadResaPax();
                } catch (Exception e) {
                    showSnackbar(findViewById(android.R.id.content), getString(R.string.error_message_check_settings));
                }
                btnSearch.setEnabled(false);
            }
        } else {
            showSnackbar(findViewById(android.R.id.content), getString(R.string.error_message_no_internet));
        }
    }

    @OnClick(R.id.ibtn_home_setting)
    public void startSettings() {
        Intent i = new Intent(getApplicationContext(), SettingsActivity.class);
        startActivity(i);
    }

    @OnClick(R.id.ibtn_home_prams)
    public void startParms() {
        Intent i = new Intent(getApplicationContext(), ParamsActivity.class);
        startActivity(i);
    }

    //************************************************************************************************

    //This method is for EditText valus validation.
    private boolean inputTextValidation() {

        if (!mInputValidation.isInputEditTextFilled(etResaNum, ilResaNum, getString(R.string.error_message_field_required))) {
            return false;
        }
        //Return true if all the inputs are valid
        return true;

    }

    //This method is for init Views.
    private void init() {

        mKenBurns = (KenBurnsView) findViewById(R.id.ken_burns_images);
        mKenBurns.setImageResource(R.drawable.hotel);

        loadeImage();

        try {
            PackageInfo pInfo = this.getPackageManager().getPackageInfo(getPackageName(), 0);
            tvVersion.setText(getString(R.string.text_vertion) + " " + pInfo.versionName);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void loadeImage() {

        Picasso.get().load(BASE_URL + "Android/pics_check_in/hotel.jpg").into(new Target() {

            @Override
            public void onPrepareLoad(Drawable arg0) {
            }

            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom arg1) {
                mKenBurns.setImageBitmap(bitmap);
            }

            @Override
            public void onBitmapFailed(Exception e, Drawable errorDrawable) {

            }

        });
    }

    //This method show exit dialog.
    private void startExitDialog() {

        AlertDialog.Builder mBuilder = new AlertDialog.Builder(this);

        View mView = getLayoutInflater().inflate(R.layout.dialog_exit, null);
        AppCompatButton btnYes = (AppCompatButton) mView.findViewById(R.id.btn_dialog_exit_yes);
        AppCompatButton btnCancel = (AppCompatButton) mView.findViewById(R.id.btn_dialog_exit_cancel);

        mBuilder.setView(mView);
        mBuilder.setCancelable(false);
        final AlertDialog dialog = mBuilder.create();
        dialog.show();

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                dialog.dismiss();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

    }

    //This method show Download Hotel Settings dialog.
    private void startDownloadSettingsDialog() {

        AlertDialog.Builder mBuilder = new AlertDialog.Builder(this);

        View mView = getLayoutInflater().inflate(R.layout.dialog_hotel_settings, null);
        AppCompatButton btnDownload = (AppCompatButton) mView.findViewById(R.id.btn_dialog_hotel_settings_download);
        AppCompatButton btnCancel = (AppCompatButton) mView.findViewById(R.id.btn_dialog_hotel_settings_cancel);
        ilHotelCode = (TextInputLayout) mView.findViewById(R.id.il_dialog_hotel_settings_code);
        etHotelCode = (AppCompatEditText) mView.findViewById(R.id.et_dialog_hotel_settings_code);

        mBuilder.setView(mView);
        mBuilder.setCancelable(false);
        final AlertDialog dialog = mBuilder.create();
        dialog.show();

        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mInputValidation.isInputEditTextFilled(etHotelCode, ilHotelCode, getString(R.string.error_message_field_required))) {
                    try {
                        lodeHotelInfos(etHotelCode.getText().toString());
                    } catch (Exception e) {
                        showSnackbar(findViewById(android.R.id.content), getString(R.string.error_message_something_wrong));
                    }
                    dialog.dismiss();
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                dialog.dismiss();
            }
        });

    }

    //This method show Contact Support dialog.
    private void startContactSupportDialog() {

        AlertDialog.Builder mBuilder = new AlertDialog.Builder(this);

        View mView = getLayoutInflater().inflate(R.layout.dialog_contact_support, null);
        AppCompatButton btnOk = (AppCompatButton) mView.findViewById(R.id.btn_dialog_contact_support_ok);
        AppCompatButton btnRtery = (AppCompatButton) mView.findViewById(R.id.btn_dialog_contact_support_retry);

        mBuilder.setView(mView);
        mBuilder.setCancelable(false);
        final AlertDialog dialog = mBuilder.create();
        dialog.show();

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                dialog.dismiss();
            }
        });

        btnRtery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startDownloadSettingsDialog();
                dialog.dismiss();
            }
        });

    }

    //*************************************(  Lode Hotel Infos  )****************************************

    public void lodeHotelInfos(String code) {

        RetrofitInterface service = RetrofitClient.getHotixSupportApi().create(RetrofitInterface.class);
        Call<HotelSettings> userCall = service.getInfosQuery(code, FINAL_APP_ID);

        final ProgressDialog progressDialog = new ProgressDialog(HomeActivity.this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage(getString(R.string.all_downloading));
        progressDialog.setCancelable(false);
        progressDialog.show();

        userCall.enqueue(new Callback<HotelSettings>() {
            @Override
            public void onResponse(Call<HotelSettings> call, Response<HotelSettings> response) {

                progressDialog.dismiss();

                if (response.raw().code() == 200) {
                    HotelSettings hotelSettings = response.body();
                    //Check if hotel id > 0
                    if (!(hotelSettings.getId() > 0)) {
                        //Hotel do not exist
                        startContactSupportDialog();
                    } else {

                        //Get Public IP
                        if (!stringEmptyOrNull(hotelSettings.getIPPublic())) {
                            mMySettings.setPublicIp(hotelSettings.getIPPublic());
                            mMySettings.setPublicBaseUrl("http://" + hotelSettings.getIPPublic() + "/");
                            mMySettings.setPublicIpEnabled(true);
                        } else {
                            mMySettings.setPublicIp("xxx.xxx.xxx.xxx");
                            mMySettings.setPublicIpEnabled(false);
                        }

                        //Get Local IP
                        if (!stringEmptyOrNull(hotelSettings.getIPLocal())) {
                            mMySettings.setLocalIp(hotelSettings.getIPLocal());
                            mMySettings.setLocalBaseUrl("http://" + hotelSettings.getIPLocal() + "/");
                            mMySettings.setLocalIpEnabled(true);
                        } else {
                            mMySettings.setLocalIp("xxx.xxx.xxx.xxx");
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

                        mMySettings.setFirstStart(false);
                        mMySettings.setConfigured(true);
                        mMySettings.setSettingsUpdated(true);

                        showSnackbar(findViewById(android.R.id.content), getString(R.string.message_settings_updated));
                        setBaseUrl(getApplicationContext());
                    }

                } else {
                    startDownloadSettingsDialog();
                    showSnackbar(findViewById(android.R.id.content), response.message());
                }

            }

            @Override
            public void onFailure(Call<HotelSettings> call, Throwable t) {
                progressDialog.dismiss();
                startDownloadSettingsDialog();
                showSnackbar(findViewById(android.R.id.content), getString(R.string.error_message_server_down));
            }
        });

    }

    //**********************************(  load Resa Pax  )*************************************
    public void loadResaPax() {

        pbSearch.setVisibility(View.VISIBLE);
        String resaId = etResaNum.getText().toString();

        RetrofitInterface service = RetrofitClient.getClientHngApi().create(RetrofitInterface.class);
        Call<ArrayList<Pax>> userCall = service.getPaxResaQuery(resaId);
        userCall.enqueue(new Callback<ArrayList<Pax>>() {
            @Override
            public void onResponse(Call<ArrayList<Pax>> call, Response<ArrayList<Pax>> response) {

                pbSearch.setVisibility(View.GONE);

                if (response.raw().code() == 200) {
                    GLOBAL_PAX_LIST = response.body();
                    if (GLOBAL_PAX_LIST.size() > 0) {
                        try {
                            loadingStartData();
                        } catch (Exception e) {
                            showSnackbar(findViewById(android.R.id.content), getString(R.string.error_message_check_settings));
                            btnSearch.setEnabled(true);
                        }
                    } else {
                        showSnackbar(findViewById(android.R.id.content), getString(R.string.error_message_empty_reservation));
                        btnSearch.setEnabled(true);
                    }
                } else {
                    showSnackbar(findViewById(android.R.id.content), response.message());
                    btnSearch.setEnabled(true);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Pax>> call, Throwable t) {
                pbSearch.setVisibility(View.GONE);
                showSnackbar(findViewById(android.R.id.content), getString(R.string.error_message_server_down));
                btnSearch.setEnabled(true);
            }
        });

    }
    //**********************************(  Loading Start Data  )*************************************
    public void loadingStartData() {

        RetrofitInterface service = RetrofitClient.getClientHngApi().create(RetrofitInterface.class);
        Call<StartData> userCall = service.getAllDataQuery();

        pbSearch.setVisibility(View.VISIBLE);

        userCall.enqueue(new Callback<StartData>() {
            @Override
            public void onResponse(Call<StartData> call, Response<StartData> response) {

                pbSearch.setVisibility(View.GONE);

                if (response.raw().code() == 200) {
                    GLOBAL_START_DATA = response.body();
                    Intent i = new Intent(getApplicationContext(), EditInfosActivity.class);
                    startActivity(i);
                } else {
                    showSnackbar(findViewById(android.R.id.content), response.message());
                    btnSearch.setEnabled(true);
                }
            }

            @Override
            public void onFailure(Call<StartData> call, Throwable t) {
                pbSearch.setVisibility(View.GONE);
                showSnackbar(findViewById(android.R.id.content), getString(R.string.error_message_server_down));
                btnSearch.setEnabled(true);
            }
        });

    }

}
