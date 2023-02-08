package com.driver;
import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

    HashMap<String,Book> bookMap = new HashMap<>();

    public BookRepository(){

    }

    public Book save(Book book){

        //Book book1 = new Book(book);
        bookMap.put(book.getName(),book);
        return book;
    }

    public Book findBookById(int id){
        for(Map.Entry<String, Book> book: bookMap.entrySet()){
            if(book.getValue().getId()==id){
                return book.getValue();
            }
        }
        return null;
    }

    public List<Book> findAll(){
        List<Book> allBooks = new ArrayList<>();
        for(Map.Entry<String, Book> book: bookMap.entrySet()){
            allBooks.add(book.getValue());
        }
        return allBooks;
    }



    public void deleteBookById(int id){
        for(Map.Entry<String, Book> book: bookMap.entrySet()){
            if(book.getValue().getId()==id){
                bookMap.remove(book);
            }
        }
    }

    public void deleteAll(){
        bookMap.clear();
    }

    public List<Book> findBooksByAuthor(String author){
        List<Book> allBooks = new ArrayList<>();
        for(Map.Entry<String, Book> book: bookMap.entrySet()){
            if(book.getValue().getAuthor()==author){
                allBooks.add(book.getValue());
            }
        }
        return allBooks;
    }


    public List<Book> findBooksByGenre(String genre){
        List<Book> allBooks = new ArrayList<>();
        for(Map.Entry<String, Book> book: bookMap.entrySet()){
            if(book.getValue().getGenre()==genre){
                allBooks.add(book.getValue());
            }
        }
        return allBooks;
    }
}