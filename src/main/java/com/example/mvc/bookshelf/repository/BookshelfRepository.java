package com.example.mvc.bookshelf.repository;

import com.example.mvc.bookshelf.domain.Bookshelf;

import java.util.Optional;

public interface BookshelfRepository {
    Bookshelf save(Bookshelf shelf);

    Optional<Bookshelf> findById(Long id); // optional?

    Optional<Bookshelf> findBybookShelfName(String bookShelfName);

}
