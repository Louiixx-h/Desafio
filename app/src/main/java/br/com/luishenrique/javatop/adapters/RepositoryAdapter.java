package br.com.luishenrique.javatop.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import br.com.luishenrique.javatop.R;
import br.com.luishenrique.javatop.data.mappers.ItemRepository;
import br.com.luishenrique.javatop.data.models.Repository;

public class RepositoryAdapter extends PagedListAdapter<ItemRepository, RepositoryAdapter.RepositoryViewHolder> {


    private Context context;
    private RecyclerViewClickListener listerner;
    public static Repository repository;

    public RepositoryAdapter(Context context, RecyclerViewClickListener listerner) {
        super(DIFF_CALLBACK);
        this.context = context;
        this.listerner = listerner;
    }

    @NonNull
    @Override
    public RepositoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_repository, parent, false);
        return new RepositoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RepositoryViewHolder holder, int position) {
        ItemRepository item = getItem(position);
        holder.toRepository(item);
    }

    private static DiffUtil.ItemCallback<ItemRepository> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<ItemRepository>() {
                @Override
                public boolean areItemsTheSame(@NonNull ItemRepository oldItem, @NonNull ItemRepository newItem) {
                    return oldItem.id == newItem.id;
                }

                @SuppressLint("DiffUtilEquals")
                @Override
                public boolean areContentsTheSame(@NonNull ItemRepository oldItem, @NonNull ItemRepository newItem) {
                    return oldItem.equals(newItem);
                }
            };

    class RepositoryViewHolder extends RecyclerView.ViewHolder {

        private CardView card_repository;
        private TextView item_title;
        private TextView item_desc;
        private TextView item_forks;
        private TextView item_stars;
        private TextView item_username;
        private ImageView item_avatar;

        public RepositoryViewHolder(View itemView) {
            super(itemView);
            item_title = itemView.findViewById(R.id.item_title);
            item_desc = itemView.findViewById(R.id.item_desc);
            item_forks = itemView.findViewById(R.id.item_forks);
            item_stars = itemView.findViewById(R.id.item_stars);
            item_avatar = itemView.findViewById(R.id.item_avatar);
            item_username = itemView.findViewById(R.id.item_username);
            card_repository = itemView.findViewById(R.id.card_repository);

            card_repository.setOnClickListener( v -> {
                listerner.OnclickRecyclerItem(getAdapterPosition(), getItem(getAdapterPosition()));
            });
        }

        public void toRepository(ItemRepository item) {
             Repository repo = new Repository(
                    item.nameRepo,
                    item.desc,
                    item.owner.avatarUrl,
                    item.owner.username,
                    item.stars,
                    item.forks,
                    item.id
            );
            bind(repo);
        }

        public void bind(Repository repo) {
            item_title.setText(repo.getNameRepository());
            item_desc.setText(repo.getDescription());
            item_forks.setText(""+repo.getForks());
            item_stars.setText(""+repo.getStars());
            item_username.setText(repo.getUsername());
            Glide.with(context)
                    .load(repo.getAvatarUrl())
                    .into(item_avatar);
            repository = repo;
        }
    }

    public interface RecyclerViewClickListener {
        void OnclickRecyclerItem(int position, ItemRepository item);
    }
}
