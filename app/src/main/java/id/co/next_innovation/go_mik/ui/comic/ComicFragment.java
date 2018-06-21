package id.co.next_innovation.go_mik.ui.comic;

import android.view.View;

import javax.inject.Inject;

import id.co.next_innovation.go_mik.ui.base.BaseFragment;

public class ComicFragment extends BaseFragment implements ComicView {

    @Inject
    ComicMvpPresenter<ComicView> mPresenter;

    @Override
    protected void setUp(View view) {

    }
}
