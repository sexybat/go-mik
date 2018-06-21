package id.co.next_innovation.go_mik.ui.comic;

import javax.inject.Inject;

import id.co.next_innovation.go_mik.data.DataManager;
import id.co.next_innovation.go_mik.ui.base.BasePresenter;
import id.co.next_innovation.go_mik.utils.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;

public class ComicPresenter<V extends ComicView> extends BasePresenter<V> implements ComicMvpPresenter<V> {

    @Inject
    public ComicPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }
}
