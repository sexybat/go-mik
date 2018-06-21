package id.co.next_innovation.go_mik.ui.episode;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import butterknife.ButterKnife;
import id.co.next_innovation.go_mik.R;
import id.co.next_innovation.go_mik.di.component.ActivityComponent;
import id.co.next_innovation.go_mik.ui.base.BaseFragment;

public class EpisodeFragment extends BaseFragment implements EpisodeView {

    @Inject
    EpisodePresenter<EpisodeView> mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_episode, container, false);

        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, view));
            mPresenter.onAttach(this);
        }
        return view;
    }

    @Override
    protected void setUp(View view) {

    }
}
