package com.example.lab.service;

import com.example.lab.entity.AuthorEntity;
import com.example.lab.entity.BookEntity;
import com.example.lab.entity.enums.Category;

import java.util.List;

public interface BookService {

    BookEntity findBookById(Long id) throws Exception;

    List<BookEntity> listAllBooks();

    void saveBook(String name, Category category, AuthorEntity author, int availableCopies);

    void deleteBook(Long id) throws Exception;

    void reduceCopy(Long id) throws Exception;

    void editBook(Long id, String name, Category category, AuthorEntity author, int availableCopies) throws Exception;


}
