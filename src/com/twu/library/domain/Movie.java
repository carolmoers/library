package com.twu.library.domain;

public class Movie {
    private Integer code;
    private String name;
    private String year;
    private String director;
    private Integer rating;
    private boolean checkout;

    public Movie(Integer code, String name, String year, String director, Integer rating, boolean checkout) {
        this.code = code;
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
        this.checkout = checkout;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return this.name;
    }

    public String getYear() {
        return this.year;
    }

    public String getDirector() {
        return this.director;
    }

    public Integer getRating() {
        return this.rating;
    }

    public boolean isCheckout() {
        return checkout;
    }
}
