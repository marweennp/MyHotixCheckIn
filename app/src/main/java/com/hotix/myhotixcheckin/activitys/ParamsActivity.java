package com.hotix.myhotixcheckin.activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.widget.CompoundButton;

import com.hotix.myhotixcheckin.R;
import com.hotix.myhotixcheckin.helpers.MyParams;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.hotix.myhotixcheckin.helpers.Utils.setBaseUrl;

public class ParamsActivity extends AppCompatActivity {

    // Butter Knife BindView Toolbar
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.sw_param_first_name)
    SwitchCompat swFirstName;
    @BindView(R.id.sw_param_last_name)
    SwitchCompat swLastName;
    @BindView(R.id.sw_param_gender)
    SwitchCompat swGender;
    @BindView(R.id.sw_param_birthday)
    SwitchCompat swBirthday;
    @BindView(R.id.sw_param_famili_situation)
    SwitchCompat swFamiliSituation;
    @BindView(R.id.sw_param_phone)
    SwitchCompat swPhone;
    @BindView(R.id.sw_param_email)
    SwitchCompat swEmail;
    @BindView(R.id.sw_param_address)
    SwitchCompat swAddress;
    @BindView(R.id.sw_param_country)
    SwitchCompat swCountry;
    @BindView(R.id.sw_param_postal_code)
    SwitchCompat swPostalCode;
    @BindView(R.id.sw_param_city)
    SwitchCompat swCity;
    @BindView(R.id.sw_param_profession)
    SwitchCompat swProfession;
    @BindView(R.id.sw_param_type_doc_id)
    SwitchCompat swTypeDocId;
    @BindView(R.id.sw_param_handicap)
    SwitchCompat swHandicap;
    @BindView(R.id.sw_param_smoker)
    SwitchCompat swSmoker;

    private MyParams mMyParams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_params);

        ButterKnife.bind(this);
        //settings
        mMyParams = new MyParams(getApplicationContext());

        init();
    }

    @Override
    public void onBackPressed() {
        saveParams();
        setBaseUrl(this);
        super.onBackPressed();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadParams();
        setBaseUrl(this);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    //****************************************************************************************************

    private void init() {

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.text_user_parameters);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        swFirstName.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean bChecked) {

                if (bChecked) {
                    swFirstName.setText(R.string.all_on);
                } else {
                    swFirstName.setText(R.string.all_off);
                }
            }
        });

        swLastName.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean bChecked) {

                if (bChecked) {
                    swLastName.setText(R.string.all_on);
                } else {
                    swLastName.setText(R.string.all_off);
                }
            }
        });

        swGender.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean bChecked) {

                if (bChecked) {
                    swGender.setText(R.string.all_on);
                } else {
                    swGender.setText(R.string.all_off);
                }
            }
        });

        swBirthday.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean bChecked) {

                if (bChecked) {
                    swBirthday.setText(R.string.all_on);
                } else {
                    swBirthday.setText(R.string.all_off);
                }
            }
        });

        swFamiliSituation.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean bChecked) {

                if (bChecked) {
                    swFamiliSituation.setText(R.string.all_on);
                } else {
                    swFamiliSituation.setText(R.string.all_off);
                }
            }
        });

        swPhone.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean bChecked) {

                if (bChecked) {
                    swPhone.setText(R.string.all_on);
                } else {
                    swPhone.setText(R.string.all_off);
                }
            }
        });

        swEmail.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean bChecked) {

                if (bChecked) {
                    swEmail.setText(R.string.all_on);
                } else {
                    swEmail.setText(R.string.all_off);
                }
            }
        });

        swAddress.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean bChecked) {

                if (bChecked) {
                    swAddress.setText(R.string.all_on);
                } else {
                    swAddress.setText(R.string.all_off);
                }
            }
        });

        swCountry.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean bChecked) {

                if (bChecked) {
                    swCountry.setText(R.string.all_on);
                } else {
                    swCountry.setText(R.string.all_off);
                }
            }
        });

        swPostalCode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean bChecked) {

                if (bChecked) {
                    swPostalCode.setText(R.string.all_on);
                } else {
                    swPostalCode.setText(R.string.all_off);
                }
            }
        });

        swCity.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean bChecked) {

                if (bChecked) {
                    swCity.setText(R.string.all_on);
                } else {
                    swCity.setText(R.string.all_off);
                }
            }
        });

        swProfession.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean bChecked) {

                if (bChecked) {
                    swProfession.setText(R.string.all_on);
                } else {
                    swProfession.setText(R.string.all_off);
                }
            }
        });

        swTypeDocId.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean bChecked) {

                if (bChecked) {
                    swTypeDocId.setText(R.string.all_on);
                } else {
                    swTypeDocId.setText(R.string.all_off);
                }
            }
        });

        swHandicap.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean bChecked) {

                if (bChecked) {
                    swHandicap.setText(R.string.all_on);
                } else {
                    swHandicap.setText(R.string.all_off);
                }
            }
        });

        swSmoker.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean bChecked) {

                if (bChecked) {
                    swSmoker.setText(R.string.all_on);
                } else {
                    swSmoker.setText(R.string.all_off);
                }
            }
        });

    }

    private void loadParams() {

        swFirstName.setChecked(mMyParams.getFirstName());
        swLastName.setChecked(mMyParams.getlastName());
        swGender.setChecked(mMyParams.getGender());
        swBirthday.setChecked(mMyParams.getBirthDay());
        swFamiliSituation.setChecked(mMyParams.getFamilySituation());
        swPhone.setChecked(mMyParams.getPhone());
        swEmail.setChecked(mMyParams.getEmail());
        swAddress.setChecked(mMyParams.getAddress());
        swCountry.setChecked(mMyParams.getCountry());
        swPostalCode.setChecked(mMyParams.getPostalCode());
        swCity.setChecked(mMyParams.getCity());
        swProfession.setChecked(mMyParams.getProfession());
        swTypeDocId.setChecked(mMyParams.getTypeDocId());
        swHandicap.setChecked(mMyParams.getHandicap());
        swSmoker.setChecked(mMyParams.getSmoker());

    }

    private void saveParams() {

        mMyParams.setFirstName(swFirstName.isChecked());
        mMyParams.setLastName(swLastName.isChecked());
        mMyParams.setGender(swGender.isChecked());
        mMyParams.setBirthDay(swBirthday.isChecked());
        mMyParams.setFamilySituation(swFamiliSituation.isChecked());
        mMyParams.setPhone(swPhone.isChecked());
        mMyParams.setEmail(swEmail.isChecked());
        mMyParams.setAddress(swAddress.isChecked());
        mMyParams.setCountry(swCountry.isChecked());
        mMyParams.setPostalCode(swPostalCode.isChecked());
        mMyParams.setCity(swCity.isChecked());
        mMyParams.setProfession(swProfession.isChecked());
        mMyParams.setTypeDocId(swTypeDocId.isChecked());
        mMyParams.setHandicap(swHandicap.isChecked());
        mMyParams.setSmoker(swSmoker.isChecked());

    }
}
