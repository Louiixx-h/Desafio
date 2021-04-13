package br.com.luishenrique.javatop.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import br.com.luishenrique.javatop.R;
import br.com.luishenrique.javatop.data.mappers.Item;
import br.com.luishenrique.javatop.data.models.Repository;

public class RepositoryAdapter extends PagedListAdapter<Item, RepositoryAdapter.RepositoryHolder> {


    private Context context;

    protected RepositoryAdapter(Context context) {
        super(DIFF_CALLBACK);
        this.context = context;
    }

    @NonNull
    @Override
    public RepositoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new RepositoryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RepositoryHolder holder, int position) {
        Item item = getItem(position);
        holder.toRepository(item);
    }

    private static DiffUtil.ItemCallback<Item> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<Item>() {
                @Override
                public boolean areItemsTheSame(@NonNull Item oldItem, @NonNull Item newItem) {
                    return oldItem.owner.id == newItem.owner.id;
                }

                @SuppressLint("DiffUtilEquals")
                @Override
                public boolean areContentsTheSame(@NonNull Item oldItem, @NonNull Item newItem) {
                    return oldItem.equals(newItem);
                }
            };

    class RepositoryHolder extends RecyclerView.ViewHolder {

        private TextView item_title;
        private TextView item_desc;
        private TextView item_forks;
        private TextView item_stars;
        private TextView item_username;
        private ImageView item_avatar;

        public RepositoryHolder(View itemView) {
            super(itemView);
            item_title = itemView.findViewById(R.id.item_title);
            item_desc = itemView.findViewById(R.id.item_desc);
            item_forks = itemView.findViewById(R.id.item_forks);
            item_stars = itemView.findViewById(R.id.item_stars);
            item_avatar = itemView.findViewById(R.id.item_avatar);
            item_username = itemView.findViewById(R.id.item_username);
        }

        public void toRepository(Item item) {
             Repository repo = new Repository(
                    item.nameRepo,
                    item.desc,
                    item.owner.avatarUrl,
                    item.owner.username,
                    item.stars,
                    item.forks,
                    item.owner.id
            );
            bind(repo);
        }

        public void bind(Repository repo) {
            item_title.setText(repo.getNameRepository());
            item_desc.setText(repo.getDescription());
            item_forks.setText(repo.getForks());
            item_stars.setText(repo.getStars());
            item_username.setText(repo.getUsername());
            Glide.with(context)
                    .load(repo.getAvatarUrl())
                    .into(item_avatar);
        }
    }
}
