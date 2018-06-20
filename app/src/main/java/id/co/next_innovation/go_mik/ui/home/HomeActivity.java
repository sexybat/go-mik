/*
 * Copyright 2018 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, June 2018
 */

package id.co.next_innovation.go_mik.ui.home;

import android.os.Bundle;

import id.co.next_innovation.go_mik.R;
import id.co.next_innovation.go_mik.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity implements HomeView {

    @Inject
    HomeMvpPresenter<HomeView> mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(this);

        setUp();
    }

    @Override
    protected void setUp() {

    }
}
