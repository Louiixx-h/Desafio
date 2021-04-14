package br.com.luishenrique.javatop.data.network;

import br.com.luishenrique.javatop.data.mappers.RepositorieResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiRequest {

    @GET("search/repositories")
    Call<RepositorieResponse> findAllReposritories(
            @Query("q") String q,
            @Query("sort") String sort,
            @Query("page") int page
    );

    @GET("repos/{user}/{repo}/pulls")
    Call<RepositorieResponse> findAllPullRquests(
            @Path("user") String user,
            @Path("repo") String repo
    );
}
