package com.hogrider.service;

import com.hogrider.dao.BookDAO;
import com.hogrider.pojo.Book;
import com.hogrider.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookDAO bookDAO;

    @Autowired
    CategoryService categoryService;

    public List<Book> list(){
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        return bookDAO.findAll(sort);
    }

    public void addOrUpdate(Book book){
        bookDAO.save(book);
    }

    public void deleteById(Integer id){
        bookDAO.deleteById(id);
    }

    public List<Book> listByCategory(Integer cid){
        Category category = categoryService.get( cid);
        return bookDAO.findAllByCategory(category);
    }

    public List<Book> searchResult( String keywords){
        return bookDAO.findByTitleLikeOrAuthorLike('%' + keywords + '%', '%' + keywords + '%');
    }
}
