package br.com.luishenrique.javatop.data.mappers;

import com.squareup.moshi.Json;

public class ItemRepository {

    @Json(name = "id")
    public Long id;

    @Json(name = "name")
    public String nameRepo;

    @Json(name = "description")
    public String desc;

    @Json(name = "forks_count")
    public int forks;

    @Json(name = "stargazers_count")
    public int stars;

    @Json(name = "owner")
    public OwnerRepository owner;
}
