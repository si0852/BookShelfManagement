package com.example.mvc.bookshelf;

import com.example.mvc.bookshelf.domain.Bookshelf;
import com.example.mvc.bookshelf.repository.BookshelfRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BookShelfRepositoryTest {

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


    // 책장 수정 테스트 (객체 생성 -> save -> 객체 수정 -> save)
    @Test
    void 책장_수정_테스트(){
        Bookshelf bookshelf = new Bookshelf();
        bookshelf.setBookShelfName("자기개발 책장");
        bookshelf.setFloor(5);

        bookshelfRepository.save(bookshelf);

        Bookshelf saveShelf = bookshelfRepository.findBybookShelfName(bookshelf.getBookShelfName()).get();

        saveShelf.setBookShelfName("경제개발 책장");
        saveShelf.setFloor(6);

        bookshelfRepository.save(saveShelf);

        Bookshelf updateShelf = bookshelfRepository.findById(saveShelf.getId()).get();

        assertNotEquals(bookshelf.getBookShelfName(), updateShelf.getBookShelfName());
    }

    // 책장 삭제 테스트
    @Test
    void 책장_삭제_테스트() {
        Optional<Bookshelf> deleteShelf = bookshelfRepository.findBybookShelfName("역사 책장");
        if(deleteShelf.isPresent())bookshelfRepository.delete(deleteShelf.get());

        Optional<Bookshelf> findShelf = deleteShelf.isPresent() ? bookshelfRepository.findById(deleteShelf.get().getId()) : null;


        assertEquals(null, findShelf);
    }
}
