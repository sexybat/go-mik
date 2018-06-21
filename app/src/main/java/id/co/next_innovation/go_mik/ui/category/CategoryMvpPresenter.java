package id.co.next_innovation.go_mik.ui.category;

import id.co.next_innovation.go_mik.ui.base.MvpPresenter;

public interface CategoryMvpPresenter<V extends CategoryView> extends MvpPresenter<V> {

    void loadComicsByCategory(int category_id);
}
