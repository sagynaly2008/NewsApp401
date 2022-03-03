package kg.geektech.newsapp40;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import kg.geektech.models.News;
import kg.geektech.newsapp40.databinding.ItemNewsBinding;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private ArrayList<News> list = new ArrayList<>();
    private List<News> news;

    public void setList(ArrayList<News> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    public void addItem(News news) {
        this.list.add(news);
        notifyItemInserted(0);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemNewsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(list.get(position));

        if (position % 2 == 0) {
            //holder.rootView.setBackgroundColor(Color.BLACK);
            holder.itemView.setBackgroundResource(R.color.teal_200);
        } else {
            //holder.rootView.setBackgroundColor(Color.WHITE);
            holder.itemView.setBackgroundResource(R.color.white);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public void addItems(List<News> newsList){
        news = newsList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ItemNewsBinding binding;

        public ViewHolder(@NonNull ItemNewsBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

        public void onBind(News news) {
            binding.tvTitle.setText(news.getTitle());
            binding.tvCreated.setText(news.getCreatedAt());
        }
    }
}