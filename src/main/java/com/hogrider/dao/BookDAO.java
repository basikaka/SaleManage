package com.hogrider.dao;

import com.hogrider.pojo.Book;
import com.hogrider.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookDAO extends JpaRepository<Book, Integer> {

    List<Book> findAllByCategory(Category category);
    List<Book> findByTitleLikeOrAuthorLike(String keyword1, String keyword2);

}
