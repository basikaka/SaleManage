package com.hogrider.controller;

import antlr.collections.impl.LList;
import com.hogrider.pojo.Book;
import com.hogrider.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class LibraryController {

    @Autowired
    BookService bookService;

    @GetMapping("/books")
    public List<Book> list(){
        return  bookService.list();
    }

    @GetMapping("/categories/{cid}/books")
    public List<Book> listByCategory(@PathVariable("cid") Integer cid){
        if( 0 != cid){
            return bookService.listByCategory( cid );
        }else {
            return list();
        }

    }

    @PostMapping("/books")
    public Book addOrUpdate(@RequestBody Book book){
        bookService.addOrUpdate( book );
        return book;
    }

    @PostMapping("/delete")
    public void delelet(@RequestBody Book book){
        bookService.deleteById(book.getId());
    }

    @GetMapping("/search")
    public List<Book> searchResult(@RequestParam("keywords") String keywords){
        if( "".equals(keywords)){
            return bookService.list();
        }else {
            return bookService.searchResult(keywords);
        }
    }
}
