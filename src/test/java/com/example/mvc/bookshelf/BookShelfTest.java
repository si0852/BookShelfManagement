package com.example.mvc.bookshelf;

import com.example.mvc.bookshelf.domain.Bookshelf;
import com.example.mvc.bookshelf.repository.BookshelfRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BookShelfTest {

    @Autowired
    BookshelfRepository bookshelfRepository;

    @Test
    void bookshelf_h2_connect_test() {
        Bookshelf shelf = new Bookshelf();
        shelf.setBookShelfName("bookName");
        shelf.setFloor(1);


        // insert
        bookshelfRepository.save(shelf);

       Bookshelf testShelf = bookshelfRepository.findBybookShelfName(shelf.getBookShelfName()).get();

        assertThat(testShelf.getBookShelfName()).isEqualTo(shelf.getBookShelfName());
    }

    @Test
    void 책장_추가_테스트() {
        Bookshelf bookshelf = new Bookshelf();
        bookshelf.setFloor(10);
        bookshelf.setBookShelfName("역사책장");

        bookshelfRepository.save(bookshelf);

        Bookshelf saveShelf = bookshelfRepository.findBybookShelfName(bookshelf.getBookShelfName()).get();
        assertEquals(bookshelf.getBookShelfName(), saveShelf.getBookShelfName());
    }


    // 책장 수정 테스트

    // 책장 삭제 테스트

    // 책장 조회 by id

    // 책장 조회 by name

    // 모든 책장 조회
}
