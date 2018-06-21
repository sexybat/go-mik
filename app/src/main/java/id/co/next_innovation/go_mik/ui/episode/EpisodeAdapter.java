package id.co.next_innovation.go_mik.ui.episode;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.co.next_innovation.go_mik.R;
import id.co.next_innovation.go_mik.data.db.entity.Episode;
import id.co.next_innovation.go_mik.ui.base.BaseViewHolder;

public class EpisodeAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    public static final int VIEW_TYPE_EMPTY = 0;
    public static final int VIEW_TYPE_NORMAL = 1;

    private Callback mCallback;
    private List<Episode> episodes;

    public EpisodeAdapter(List<Episode> episodes) {
        this.episodes = episodes;
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
        if (episodes !=null && episodes.size() > 0) {
            return episodes.size();
        } else {
            return 1;
        }
    }

    public void addItems(List<Episode> episodeList) {
        episodes.addAll(episodeList);
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

            Episode episode = episodes.get(position);



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
