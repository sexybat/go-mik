/*
 * Copyright 2018 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, June 2018
 */

package id.co.next_innovation.go_mik.ui.home;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import id.co.next_innovation.go_mik.R;
import id.co.next_innovation.go_mik.data.db.entity.Category;
import id.co.next_innovation.go_mik.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import id.co.next_innovation.go_mik.ui.category.CategoryFragment;
import id.co.next_innovation.go_mik.utils.AppLogger;

public class HomeActivity extends BaseActivity implements HomeView {

    @Inject
    HomeMvpPresenter<HomeView> mPresenter;

    @BindView(R.id.btn_explorer)
    ImageView ico_explorer;

//    @BindView(R.id.btn_continue_watching)
//    ImageView ico_continue_watching;

    @BindView(R.id.btn_feeds)
    ImageView ico_feeds;

    @BindView(R.id.pagerHome)
    ViewPager viewPager;

    @BindView(R.id.tabs)
    TabLayout tabs;

    private HomePagerAdapter pagerAdapter;
    private List<Category> categories;
    private int tabPosition = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(this);

        mPresenter.loadCategory();

        setUp();
    }

    @OnClick(R.id.f_btn_more)
    void more() {

    }

    @OnClick(R.id.f_btn_search)
    void search() {

    }

    @OnClick(R.id.f_btn_feeds)
    void feeds() {
        setNonActive();
        ico_feeds.setImageResource(R.mipmap.ico_feeds_active);
    }

    @OnClick(R.id.f_btn_explorer)
    void explorer() {
        setNonActive();
        ico_explorer.setImageResource(R.mipmap.ico_explorer_active);
    }
//
//    @OnClick(R.id.f_btn_continue_watching)
//    void ongoing() {
//        setNonActive();
//        ico_continue_watching.setImageResource(R.mipmap.ico_continue_watching_active);
//    }

    @Override
    protected void setUp() {

        pagerAdapter = new HomePagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        pagerAdapter.notifyDataSetChanged();
        tabs.setupWithViewPager(viewPager);

    }

    private void setNonActive() {
        ico_feeds.setImageResource(R.mipmap.ico_feeds);
        ico_explorer.setImageResource(R.mipmap.ico_explorer);
//        ico_continue_watching.setImageResource(R.mipmap.ico_continue_watching);
    }

    @Override
    public void addTab(Category category) {
        pagerAdapter.addFragment(CategoryFragment.newInstance(category), category.getName());
//        pagerAdapter.notifyDataSetChanged();
    }

    @Override
    public void setOffScreenPageLimit(int i) {
        tabs.setupWithViewPager(viewPager);

//        tabs.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                tabPosition = position;
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
    }
}
