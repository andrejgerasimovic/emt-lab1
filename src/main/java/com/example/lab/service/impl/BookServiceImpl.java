package com.example.lab.service.impl;

import com.example.lab.entity.AuthorEntity;
import com.example.lab.entity.BookEntity;
import com.example.lab.entity.enums.Category;
import com.example.lab.repository.BookRepository;
import com.example.lab.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookEntity> listAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void saveBook(String name, Category category, AuthorEntity author, int availableCopies) {
        bookRepository.save(new BookEntity(name, category, author, availableCopies));
    }

    @Override
    public void deleteBook(Long id) throws Exception {
        BookEntity bookEntity = bookRepository.findById(id).orElseThrow(Exception::new);
        bookRepository.delete(bookEntity);
    }

    @Override
    public void reduceCopy(Long id) throws Exception {
        BookEntity bookEntity = bookRepository.findById(id).orElseThrow(Exception::new);
        bookEntity.setAvailableCopies(bookEntity.getAvailableCopies() - 1);
        bookRepository.save(bookEntity);
    }


    @Override
    public BookEntity findBookById(Long id) throws Exception {
        return bookRepository.findById(id).orElseThrow(Exception::new);
    }

    @Override
    public void editBook(Long id, String name, Category category, AuthorEntity author, int availableCopies) throws Exception {
        BookEntity bookEntity = bookRepository.findById(id).orElseThrow(Exception::new);
        bookEntity.setName(name);
        bookEntity.setCategory(category);
        bookEntity.setAuthor(author);
        bookEntity.setAvailableCopies(availableCopies);
        bookRepository.save(bookEntity);
    }
}
