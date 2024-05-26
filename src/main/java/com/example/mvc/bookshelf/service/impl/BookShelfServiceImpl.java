package com.example.mvc.bookshelf.service.impl;

import com.example.mvc.bookshelf.domain.Bookshelf;
import com.example.mvc.bookshelf.repository.BookshelfRepository;
import com.example.mvc.bookshelf.service.BookShelfService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class BookShelfServiceImpl implements BookShelfService {

    @Autowired
    BookshelfRepository bookshelfRepository;

    @Override
    public Integer saveBookShelf(Bookshelf bookshelf) {
        Optional<Bookshelf> findData = bookshelfRepository.findBybookShelfName(bookshelf.getBookShelfName());
        if(findData.isPresent()) return null;
        return 1;
    }
}
