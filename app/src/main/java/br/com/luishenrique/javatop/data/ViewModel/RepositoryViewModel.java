package br.com.luishenrique.javatop.data.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PageKeyedDataSource;
import androidx.paging.PagedList;

import br.com.luishenrique.javatop.data.Factory.RepositoryDataSourceFactory;
import br.com.luishenrique.javatop.data.datasources.RepositoryDataSource;
import br.com.luishenrique.javatop.data.mappers.ItemRepository;

public class RepositoryViewModel extends ViewModel {

    public LiveData<PagedList<ItemRepository>> itemPagedList;
    public LiveData<PageKeyedDataSource<Integer, ItemRepository>> liveData;

    public RepositoryViewModel() {

        RepositoryDataSourceFactory itemRepositoryDataSourceFactory
                = new RepositoryDataSourceFactory();
        liveData = itemRepositoryDataSourceFactory.getItemLiveDataSource();

        PagedList.Config config =
                (new PagedList.Config.Builder())
                    .setEnablePlaceholders(false)
                    .setPageSize(RepositoryDataSource.PAGE_SIZE)
                    .build();
        itemPagedList = (new LivePagedListBuilder(itemRepositoryDataSourceFactory, config))
                .build();
    }
}
