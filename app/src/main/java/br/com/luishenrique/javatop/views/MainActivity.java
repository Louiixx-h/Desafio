package br.com.luishenrique.javatop.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import br.com.luishenrique.javatop.R;
import br.com.luishenrique.javatop.adapters.AdapterRepositories;
import br.com.luishenrique.javatop.models.Repositorie;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv_main;
    private AdapterRepositories adapter;
    private List<Repositorie> repositories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv_main = findViewById(R.id.rv_main);

        lista();

        adapter = new AdapterRepositories(this, repositories);
        rv_main.setAdapter(adapter);
        rv_main.setLayoutManager(new LinearLayoutManager(this));
    }

    private void lista() {
        repositories = new ArrayList<>();
        repositories.add(new Repositorie("Tela Login",
                "Um app que tem a tela de login",
                "Louiixx-h",
                "Luis Henrique"));
    }
}