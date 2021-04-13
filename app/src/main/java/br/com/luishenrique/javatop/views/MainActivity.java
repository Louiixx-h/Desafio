package br.com.luishenrique.javatop.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import br.com.luishenrique.javatop.R;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv_main = findViewById(R.id.rv_main);
    }
}