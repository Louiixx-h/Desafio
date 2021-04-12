package br.com.luishenrique.javatop.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.luishenrique.javatop.R;
import br.com.luishenrique.javatop.models.Repositorie;

public class AdapterRepositories extends RecyclerView.Adapter<AdapterRepositories.RepositoriesHolder> {

    private Context context;
    private List<Repositorie> repositories;

    public AdapterRepositories(Context context, List<Repositorie> repositories) {
        this.context = context;
        this.repositories = repositories;
    }

    @NonNull
    @Override
    public RepositoriesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new RepositoriesHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RepositoriesHolder holder, int position) {
        holder.bind(repositories.get(position));
    }

    @Override
    public int getItemCount() {
        return repositories.size();
    }

    public class RepositoriesHolder extends RecyclerView.ViewHolder {

        private TextView item_title;
        private TextView item_desc;
        private TextView item_username;
        private TextView item_name;

        public RepositoriesHolder(@NonNull View itemView) {
            super(itemView);

            item_title = itemView.findViewById(R.id.item_title);
            item_desc = itemView.findViewById(R.id.item_desc);
            item_username = itemView.findViewById(R.id.item_username);
            item_name = itemView.findViewById(R.id.item_name);
        }

        public void bind(Repositorie repositorie) {
            item_title.setText(repositorie.getTitle());
            item_desc.setText(repositorie.getDescription());
            item_username.setText(repositorie.getUsername());
            item_name.setText(repositorie.getName());
        }
    }
}
