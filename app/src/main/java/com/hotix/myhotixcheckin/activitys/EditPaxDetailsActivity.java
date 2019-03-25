package com.hotix.myhotixcheckin.activitys;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;

import com.hotix.myhotixcheckin.R;
import com.hotix.myhotixcheckin.fragments.PaxDetailsFragment;
import com.hotix.myhotixcheckin.helpers.MyParams;
import com.hotix.myhotixcheckin.models.Pax;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

import static com.hotix.myhotixcheckin.helpers.ConstantConfig.GLOBAL_PAX_LIST;
import static com.hotix.myhotixcheckin.helpers.Utils.setBaseUrl;
import static com.hotix.myhotixcheckin.helpers.Utils.showSnackbar;

public class EditPaxDetailsActivity extends AppCompatActivity {


    PaxDetailsFragment mFragment;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Toolbar toolbar;
    private MyParams mMyParams;
    private String resaId;
    private List<Fragment> mFragmentList = new ArrayList<>();
    private List<String> mFragmentTitleList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_pax_details);
        ButterKnife.bind(this);

        mMyParams = new MyParams(getApplicationContext());

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        AppCompatTextView toolbarTitle = (AppCompatTextView) toolbar.findViewById(R.id.toolbar_center_title);
        toolbarTitle.setText(R.string.guest_details);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            resaId = extras.getString("resaId");
        }

        viewPager = (ViewPager) findViewById(R.id.viewpager_pax);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    protected void onResume() {
        super.onResume();
        setBaseUrl(this);
        if (GLOBAL_PAX_LIST.size() > 0) {
            setupViewPager(viewPager);
            setupTabIcons();
        } else {
            //finish();
            showSnackbar(findViewById(android.R.id.content), getString(R.string.error_message_check_settings));
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        int i = 0;
        for (Pax obj : GLOBAL_PAX_LIST) {
            PaxDetailsFragment frag = PaxDetailsFragment.newInstance(i);
            adapter.addFragment(frag, obj.getPrenom());
            i++;
        }
        viewPager.setAdapter(adapter);
    }

    private void setupTabIcons() {

        for (int i = 0; i < GLOBAL_PAX_LIST.size(); i++) {
            tabLayout.getTabAt(i).setIcon(R.drawable.ic_account_circle_white_36dp);
        }
    }

    //*******************************************************************************************************************

    class ViewPagerAdapter extends FragmentPagerAdapter {


        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            //return mFragmentTitleList.get(position);
            return null;
        }
    }

}
