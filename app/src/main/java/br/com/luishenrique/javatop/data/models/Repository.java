package br.com.luishenrique.javatop.data.models;

public class Repository {

    private String nameRepository, description, avatarUrl, username;
    private int stars, forks;
    private Long id;

    public Repository() {
    }

    public Repository(String nameRepository, String description, String avatarUrl,
                      String username, int stars, int forks, Long id) {
        this.nameRepository = nameRepository;
        this.description = description;
        this.avatarUrl = avatarUrl;
        this.username = username;
        this.stars = stars;
        this.forks = forks;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getNameRepository() {
        return nameRepository;
    }

    public String getDescription() {
        return description;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getUsername() {
        return username;
    }

    public int getStars() {
        return stars;
    }

    public int getForks() {
        return forks;
    }
}
