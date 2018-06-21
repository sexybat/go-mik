package id.co.next_innovation.go_mik.ui.category;

import java.util.List;

import id.co.next_innovation.go_mik.data.db.entity.Category;
import id.co.next_innovation.go_mik.data.db.entity.Comic;
import id.co.next_innovation.go_mik.ui.base.MvpView;

public interface CategoryView extends MvpView {

    void showComics(List<Comic> comics);
}
