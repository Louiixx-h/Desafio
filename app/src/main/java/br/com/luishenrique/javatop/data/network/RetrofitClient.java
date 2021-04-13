package br.com.luishenrique.javatop.data.network;

import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class RetrofitClient {

    private static final String BASE_URL = "https://api.github.com/";
    private static ApiRequest INSTANCE;

    public static ApiRequest getInstance() {
        if (INSTANCE == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build();
            INSTANCE = retrofit.create(ApiRequest.class);
        }
        return INSTANCE;
    }
}
