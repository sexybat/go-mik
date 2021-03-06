package id.co.next_innovation.go_mik.ui.category;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.co.next_innovation.go_mik.R;
import id.co.next_innovation.go_mik.data.db.entity.Comic;
import id.co.next_innovation.go_mik.ui.base.BaseViewHolder;
import id.co.next_innovation.go_mik.utils.AppLogger;

public class CategoryAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    public static final int VIEW_TYPE_EMPTY = 0;
    public static final int VIEW_TYPE_NORMAL = 1;

    private Callback mCallback;
    private List<Comic> comics;

    public CategoryAdapter(List<Comic> comics) {
        this.comics = comics;
    }

    public void setCallback(Callback callback) {
        mCallback = callback;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_NORMAL:
                return new ViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_comic, parent, false));
            case VIEW_TYPE_EMPTY:
            default:
                return new EmptyViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_comic, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        if (comics !=null && comics.size() > 0) {
            return comics.size();
        } else {
            return 1;
        }
    }

    public void addItems(List<Comic> comicList) {
        comics.addAll(comicList);
        notifyDataSetChanged();
    }

    public interface Callback {

    }

    public class ViewHolder extends BaseViewHolder {

        @BindView(R.id.img_content)
        ImageView imgCover;

        @BindView(R.id.txt_title)
        TextView txtComicTitle;
        @BindView(R.id.txt_sub_title)
        TextView txtSynopsis;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        protected void clear() {

        }

        public void onBind(int position) {
            super.onBind(position);

            Comic comic = comics.get(position);

            if (!comic.getCover().isEmpty()) {
                Glide.with(itemView.getContext()).load(comic.getCover()).into(imgCover);
            }
            if (!comic.getTitle().isEmpty()) {
                txtComicTitle.setText(comic.getTitle());
            }
            if (!comic.getSynopsis().isEmpty()) {
                txtSynopsis.setText(comic.getSynopsis());
            }
            itemView.setOnClickListener(v -> {
                Toast.makeText(itemView.getContext(), comic.getTitle(), Toast.LENGTH_SHORT).show();

            });

        }
    }

    public class EmptyViewHolder extends BaseViewHolder {

        public EmptyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        protected void clear() {

        }
    }
}
