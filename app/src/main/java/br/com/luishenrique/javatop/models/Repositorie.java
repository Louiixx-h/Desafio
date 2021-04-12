package br.com.luishenrique.javatop.models;

public class Repositorie {

    private String title;
    private String description;
    private String username;
    private String name;

    public Repositorie(String title, String description, String username, String name) {
        this.title = title;
        this.description = description;
        this.username = username;
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
