package br.com.luishenrique.javatop.data.datasources;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import br.com.luishenrique.javatop.data.mappers.ItemPullRequest;

public class PullRequestDataSource extends PageKeyedDataSource<Integer, ItemPullRequest> {

    public static final int FIRST_PAGE = 1;
    public static final int PAGE_SIZE = 10;
    public static final String TOPIC = "language:Java";
    public static final String SORT = "stars";

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, ItemPullRequest> callback) {
        
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, ItemPullRequest> callback) {

    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, ItemPullRequest> callback) {

    }
}
