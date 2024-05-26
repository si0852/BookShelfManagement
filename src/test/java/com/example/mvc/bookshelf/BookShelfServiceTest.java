package com.example.mvc.bookshelf;

import com.example.mvc.bookshelf.domain.Bookshelf;
import com.example.mvc.bookshelf.repository.BookshelfRepository;
import com.example.mvc.bookshelf.service.BookShelfService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BookShelfServiceTest {

    @Autowired
    BookShelfService bookShelfService;

    @Autowired
    BookshelfRepository repository;

    Bookshelf saveBookShelf;

    @BeforeEach
    void add_bookshelf() {
        saveBookShelf = new Bookshelf();
        saveBookShelf.setFloor(10);
        saveBookShelf.setBookShelfName("bookName");

        repository.save(saveBookShelf);
    }

    // 책장 추가 테스트
    // 로직: 요청한 데이터를 받는다.-> 데이터가 존재하는지 확인 -> 존재한다면 Error(ㅜㅕㅣㅣ -> 존재안한다면 insert -> 결과값에 따라

    @Test
    void 책장_추가_테스트_데이터_존재여부o() {
        Integer result = bookShelfService.saveBookShelf(saveBookShelf);
        assertEquals(null, result);
    }

//    @Test
//    void 책장_추가_테스트_데이터_존재여부x() {
//        saveBookShelf.setBookShelfName();
//        Integer result = bookShelfService.saveBookShelf(saveBookShelf);
//        assertEquals(null, result);
//    }
}


