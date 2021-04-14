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
import br.com.luishenrique.javatop.data.mappers.ItemPullRequest;
import br.com.luishenrique.javatop.data.mappers.ItemRepository;
import br.com.luishenrique.javatop.data.models.PullRequest;
import br.com.luishenrique.javatop.data.models.Repository;

public class PullRequestAdapter extends PagedListAdapter<ItemPullRequest, PullRequestAdapter.PullRequestViewHolder> {


private Context context;

    protected PullRequestAdapter(Context context) {
        super(DIFF_CALLBACK);
        this.context = context;
    }

    @NonNull
    @Override
    public PullRequestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_pull_request, parent, false);
        return new PullRequestViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PullRequestViewHolder holder, int position) {
        ItemPullRequest itemPullRequest = getItem(position);
        holder.toPullRequest(itemPullRequest);
    }

    private static DiffUtil.ItemCallback<ItemPullRequest> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<ItemPullRequest>() {
                @Override
                public boolean areItemsTheSame(@NonNull ItemPullRequest oldItem, @NonNull ItemPullRequest newItem) {
                    return oldItem.id == newItem.id;
                }

                @SuppressLint("DiffUtilEquals")
                @Override
                public boolean areContentsTheSame(@NonNull ItemPullRequest oldItem, @NonNull ItemPullRequest newItem) {
                    return oldItem.equals(newItem);
                }
            };

    class PullRequestViewHolder extends RecyclerView.ViewHolder {

    private TextView title_pr;
    private TextView body_pr;
    private ImageView avatar_pr;
    private TextView username_pr;
    private TextView date_pr;

    public PullRequestViewHolder(View itemView) {
        super(itemView);
        title_pr = itemView.findViewById(R.id.title_pr);
        body_pr = itemView.findViewById(R.id.body_pr);
        avatar_pr = itemView.findViewById(R.id.avatar_pr);
        username_pr = itemView.findViewById(R.id.username_pr);
        date_pr = itemView.findViewById(R.id.date_pr);
    }

    public void toPullRequest(ItemPullRequest item) {
        PullRequest Pr = new PullRequest(
                item.id,
                item.title,
                item.body,
                item.userPullRequest.avatar,
                item.userPullRequest.login,
                item.updated_at
        );
        bind(Pr);
    }

    public void bind(PullRequest Pr) {
        title_pr.setText(Pr.getNamePullRequest());
        body_pr.setText(Pr.getBody());
        username_pr.setText(Pr.getUsername());
        date_pr.setText(Pr.getData());
        Glide.with(context)
                .load(Pr.getAvatarUrl())
                .into(avatar_pr);
    }
}
}