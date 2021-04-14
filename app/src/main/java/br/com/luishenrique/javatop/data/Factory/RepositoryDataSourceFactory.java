package br.com.luishenrique.javatop.data.Factory;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.PageKeyedDataSource;

import br.com.luishenrique.javatop.data.datasources.RepositoryDataSource;
import br.com.luishenrique.javatop.data.mappers.ItemRepository;

public class RepositoryDataSourceFactory extends DataSource.Factory {

    private MutableLiveData<PageKeyedDataSource<Integer, ItemRepository>> itemLiveDataSource
            = new MutableLiveData<>();

    @NonNull
    @Override
    public DataSource create() {
        RepositoryDataSource repositoryDataSource = new RepositoryDataSource();
        itemLiveDataSource.postValue(repositoryDataSource);
        return repositoryDataSource;
    }

    public MutableLiveData<PageKeyedDataSource<Integer, ItemRepository>> getItemLiveDataSource() {
        return itemLiveDataSource;
    }
}
