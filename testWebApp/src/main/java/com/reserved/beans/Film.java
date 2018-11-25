package com.reserved.beans;

public class Film {

    private long id;
    private String name;
    private String country;
    private String genre;
    private int yearOfIssue;
    private int duration;

    public Film() {
    }

    public Film(long id, String name, String country, String genre, int yearOfIssue, int duration) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.genre = genre;
        this.yearOfIssue = yearOfIssue;
        this.duration = duration;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYearOfIssue() {
        return yearOfIssue;
    }

    public void setYearOfIssue(int yearOfIssue) {
        this.yearOfIssue = yearOfIssue;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Films{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", genre='" + genre + '\'' +
                ", yearOfIssue=" + yearOfIssue +
                ", duration=" + duration +
                '}';
    }
}
