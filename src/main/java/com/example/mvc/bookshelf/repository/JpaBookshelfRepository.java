package com.example.mvc.bookshelf.repository;

import com.example.mvc.bookshelf.domain.Bookshelf;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaBookshelfRepository extends JpaRepository<Bookshelf, Long>, BookshelfRepository {

}
