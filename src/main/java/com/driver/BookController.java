package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {
    @Autowired
    BookService bookService;

    // One example controller, make the rest by yourself
    @PostMapping("/create-book")
    public ResponseEntity createBook(@RequestBody Book book){
        Book newbook = bookService.createBook(book);
        return new ResponseEntity<>(newbook, HttpStatus.CREATED);
    }

    //Get book by id
    @GetMapping("/books/get-book-by-id/{id}")
    public ResponseEntity getBookById(@PathVariable("id") int id){
        Book book = bookService.findBookById(String.valueOf(id));
        return new ResponseEntity<>(book,HttpStatus.FOUND);
    }

    //Get all books
    @GetMapping("/books/get-all-books")
    public ResponseEntity getAllBooks(){
        List<Book> book= new ArrayList<>();
        book = bookService.findAllBooks();
        return new ResponseEntity<>(book,HttpStatus.FOUND);
    }

    //get books by author
    @GetMapping("/books/get-books-by-author")
    public ResponseEntity getBooksByAuthor(@RequestParam("author") String name){
        List<Book> book = new ArrayList<>();
        book = bookService.findBooksByAuthor(name);
        return new ResponseEntity<>(book,HttpStatus.FOUND);
    }

    //get all books by genre
    @GetMapping("/books/get-books-by-genre")
    public ResponseEntity getBooksByGenre(@RequestParam("genre") String name){
        List<Book> book = new ArrayList<>();
        book = bookService.findBooksByGenre(name);
        return new ResponseEntity<>(book,HttpStatus.FOUND);
    }

    @DeleteMapping("/books/delete-book-by-id/{id}")
    public ResponseEntity deleteBookById(@PathVariable("id") int id){
        bookService.deleteBookById(String.valueOf(id));
        return new ResponseEntity("Success", HttpStatus.OK);
    }

    //delete all books
    @DeleteMapping("/books/delete-all-books")
    public ResponseEntity deleteAllBooks(){
        bookService.deleteAllBooks();
        return new ResponseEntity("Success", HttpStatus.OK);
    }

}