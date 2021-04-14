package br.com.luishenrique.javatop.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import br.com.luishenrique.javatop.R;
import br.com.luishenrique.javatop.adapters.RepositoryAdapter;
import br.com.luishenrique.javatop.data.ViewModel.RepositoryViewModel;
import br.com.luishenrique.javatop.data.mappers.ItemRepository;

public class MainActivity extends AppCompatActivity implements RepositoryAdapter.RecyclerViewClickListener{

    private RecyclerView rv_main;
    private RepositoryAdapter repositoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv_main = findViewById(R.id.rv_main);
        rv_main.setLayoutManager(new LinearLayoutManager(this));
        rv_main.setHasFixedSize(true);

        RepositoryViewModel repositoryViewModel = ViewModelProviders.of(this)
                .get(RepositoryViewModel.class);

        repositoryAdapter = new RepositoryAdapter(this, this);

        repositoryViewModel.itemPagedList.observe(this, new Observer<PagedList<ItemRepository>>() {
            @Override
            public void onChanged(PagedList<ItemRepository> itemRepositories) {
                repositoryAdapter.submitList(itemRepositories);
            }
        });

        rv_main.setAdapter(repositoryAdapter);
    }

    @Override
    public void OnclickRecyclerItem(int position, ItemRepository item) {
        Intent i = new Intent(getApplicationContext(), PullRequestActivity.class);
        Bundle params = new Bundle();
        params.putString("username", item.owner.username);
        params.putString("name-repo", item.nameRepo);
        i.putExtras(params);
        startActivity(i);
    }
}