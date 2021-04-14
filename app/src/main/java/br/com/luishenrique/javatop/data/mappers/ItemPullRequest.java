package br.com.luishenrique.javatop.data.mappers;

import com.squareup.moshi.Json;

public class ItemPullRequest {

    @Json(name = "id")
    public Long id;

    @Json(name = "title")
    public String title;

    @Json(name = "upadated_at")
    public String updated_at;

    @Json(name = "body")
    public String body;

    @Json(name = "user")
    public UserPullRequest userPullRequest;
}
