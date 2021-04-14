package br.com.luishenrique.javatop.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import br.com.luishenrique.javatop.R;

public class PullRequestActivity extends AppCompatActivity {

    public static String USERNAME;
    public static String NAME_REPO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull_request);

        Intent receiveData = getIntent();
        Bundle params = receiveData.getExtras();
        if (params != null) {
                USERNAME = params.getString("username");
                NAME_REPO = params.getString("name-repo");
        }
    }
}