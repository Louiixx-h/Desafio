package br.com.luishenrique.javatop.data.models;

public class PullRequest {

    private Long id;
    private String namePullRequest, body, avatarUrl, username, data;

    public PullRequest(Long id, String namePullRequest, String body,
                       String avatarUrl, String username, String data) {
        this.id = id;
        this.namePullRequest = namePullRequest;
        this.body = body;
        this.avatarUrl = avatarUrl;
        this.username = username;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public String getNamePullRequest() {
        return namePullRequest;
    }

    public String getBody() {
        return body;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getUsername() {
        return username;
    }

    public String getData() {
        return data;
    }
}
