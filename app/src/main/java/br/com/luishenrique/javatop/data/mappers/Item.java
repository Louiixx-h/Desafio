package br.com.luishenrique.javatop.data.mappers;

import com.squareup.moshi.Json;

public class Item {

    @Json(name = "name")
    public String nameRepo;

    @Json(name = "description")
    public String desc;

    @Json(name = "forks_count")
    public int forks;

    @Json(name = "stargazers_count")
    public int stars;

    @Json(name = "owner")
    public Owner owner;
}
