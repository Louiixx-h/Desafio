package br.com.luishenrique.javatop.data.mappers;

import com.squareup.moshi.Json;

public class OwnerRepository {

    @Json(name = "avatar_url")
    public String avatarUrl;

    @Json(name = "login")
    public String username;

}
