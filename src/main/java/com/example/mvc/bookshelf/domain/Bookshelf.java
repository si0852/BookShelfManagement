package com.example.mvc.bookshelf.domain;

import jakarta.persistence.*;

@Entity
public class Bookshelf {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String bookShelfName;

    private int floor;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBookShelfName() {
        return bookShelfName;
    }

    public void setBookShelfName(String bookShelfName) {
        this.bookShelfName = bookShelfName;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }
}
