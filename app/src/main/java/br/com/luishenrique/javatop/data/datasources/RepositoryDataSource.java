package br.com.luishenrique.javatop.data.datasources;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import br.com.luishenrique.javatop.data.mappers.Item;
import br.com.luishenrique.javatop.data.mappers.RepositorieResponse;
import br.com.luishenrique.javatop.data.network.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RepositoryDataSource extends PageKeyedDataSource<Integer, Item> {

    public static final int FIRST_PAGE = 1;
    public static final String TOPIC = "language:Java";
    public static final String SORT = "stars";

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, Item> callback) {
        RetrofitClient.getInstance()
                .findAll(TOPIC, SORT, FIRST_PAGE)
                .enqueue(new Callback<RepositorieResponse>() {
                    @Override
                    public void onResponse(Call<RepositorieResponse> call, Response<RepositorieResponse> response) {
                        if (response.body() != null && response.isSuccessful()) {
                            callback.onResult(response.body().items, null, FIRST_PAGE+1);
                        }
                    }

                    @Override
                    public void onFailure(Call<RepositorieResponse> call, Throwable t) {

                    }
                });
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Item> callback) {
        RetrofitClient.getInstance()
                .findAll(TOPIC, SORT, params.key)
                .enqueue(new Callback<RepositorieResponse>() {
                    @Override
                    public void onResponse(Call<RepositorieResponse> call, Response<RepositorieResponse> response) {
                        Integer key = (params.key > 1 ) ? params.key - 1 : null;
                        if (response.body() != null && response.isSuccessful()) {
                            callback.onResult(response.body().items, key);
                        }
                    }

                    @Override
                    public void onFailure(Call<RepositorieResponse> call, Throwable t) {

                    }
                });
    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Item> callback) {
        RetrofitClient.getInstance()
                .findAll(TOPIC, SORT, params.key)
                .enqueue(new Callback<RepositorieResponse>() {
                    @Override
                    public void onResponse(Call<RepositorieResponse> call, Response<RepositorieResponse> response) {
                        if (response.body() != null && response.isSuccessful()) {
                            Integer key = params.key + 1;
                            callback.onResult(response.body().items, key);
                        }
                    }

                    @Override
                    public void onFailure(Call<RepositorieResponse> call, Throwable t) {

                    }
                });
    }
}
