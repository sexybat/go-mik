package id.co.next_innovation.go_mik.ui.category;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.co.next_innovation.go_mik.R;
import id.co.next_innovation.go_mik.data.db.entity.Category;
import id.co.next_innovation.go_mik.data.db.entity.Comic;
import id.co.next_innovation.go_mik.di.component.ActivityComponent;
import id.co.next_innovation.go_mik.ui.base.BaseFragment;
import id.co.next_innovation.go_mik.ui.comic.ComicAdapter;
import id.co.next_innovation.go_mik.utils.AppLogger;

public class CategoryFragment extends BaseFragment implements CategoryView {

    @Inject
    CategoryMvpPresenter<CategoryView> mPresenter;

    @Inject
    ComicAdapter comicAdapter;

    ComicAdapter mComicAdapter;

    @Inject
    LinearLayoutManager layoutManager;

    @BindView(R.id.recycler_comics)
    RecyclerView rvComics;

    private Category category;

    public static CategoryFragment newInstance(Category category) {
        
        Bundle args = new Bundle();
        args.putSerializable("category", category);
        CategoryFragment fragment = new CategoryFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);
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
        Bundle bundle = getArguments();

        if (bundle==null) {
            return;
        } else {
            category = (Category) bundle.getSerializable("category");
            if (category!=null) {
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                rvComics.setAdapter(comicAdapter);
                rvComics.setLayoutManager(layoutManager);
                mPresenter.loadComicsByCategory(category.getId());
            }
        }
    }

    @Override
    public void showComics(List<Comic> comics) {
        comicAdapter.addItems(comics);
        AppLogger.e("CONTENT " + new Gson().toJson(comics));
    }
}
