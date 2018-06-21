package id.co.next_innovation.go_mik.ui.episode;

import javax.inject.Inject;

import id.co.next_innovation.go_mik.data.DataManager;
import id.co.next_innovation.go_mik.ui.base.BasePresenter;
import id.co.next_innovation.go_mik.utils.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;

public class EpisodePresenter<V extends EpisodeView> extends BasePresenter<V> implements EpisodeMvpPresenter<V> {

    @Inject
    public EpisodePresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }
}
