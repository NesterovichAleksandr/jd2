package com.reserved.beans;

public class FilmCinema {

    private long id;
    private long films_id;
    private long cinemas_id;

    public FilmCinema() {
    }

    public FilmCinema(long id, long films_id, long cinemas_id) {
        this.id = id;
        this.films_id = films_id;
        this.cinemas_id = cinemas_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getFilms_id() {
        return films_id;
    }

    public void setFilms_id(long films_id) {
        this.films_id = films_id;
    }

    public long getCinemas_id() {
        return cinemas_id;
    }

    public void setCinemas_id(long cinemas_id) {
        this.cinemas_id = cinemas_id;
    }

    @Override
    public String toString() {
        return "FilmCinema{" +
                "id=" + id +
                ", films_id=" + films_id +
                ", cinemas_id=" + cinemas_id +
                '}';
    }
}
