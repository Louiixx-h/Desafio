package br.com.luishenrique.javatop.data.mappers;

import com.squareup.moshi.Json;

public class UserPullRequest {

    @Json(name = "login")
    public String login;

    @Json(name = "avatar_url")
    public String avatar;
}
