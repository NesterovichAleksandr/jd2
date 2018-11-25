package com.reserved.beans;

public class ReservedTicket {

    private long id;
    private int code;
    private double cost;
    private long users_id;
    private long films_id;
    private long cinemas_id;

    public ReservedTicket() {
    }

    public ReservedTicket(long id, int code, double cost, long users_id, long films_id, long cinemas_id) {
        this.id = id;
        this.code = code;
        this.cost = cost;
        this.users_id = users_id;
        this.films_id = films_id;
        this.cinemas_id = cinemas_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public long getUsers_id() {
        return users_id;
    }

    public void setUsers_id(long users_id) {
        this.users_id = users_id;
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
        return "ReservedTickets{" +
                "id=" + id +
                ", code=" + code +
                ", cost=" + cost +
                ", users_id=" + users_id +
                ", films_id=" + films_id +
                ", cinemas_id=" + cinemas_id +
                '}';
    }
}
