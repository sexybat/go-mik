/*
 * Copyright 2018 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, June 2018
 */

package id.co.next_innovation.go_mik.ui.splash;

import android.os.Bundle;

import com.hanks.htextview.fade.FadeTextView;
import id.co.next_innovation.go_mik.R;
import id.co.next_innovation.go_mik.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends BaseActivity implements SplashView {

    @Inject
    SplashMvpPresenter<SplashView> mPresenter;

    @BindView(R.id.text_logo)
    FadeTextView mTextLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(this);

        setUp();
    }


    @Override
    protected void setUp() {
        mTextLogo.animateText(getString(R.string.app_splash));
    }
}
