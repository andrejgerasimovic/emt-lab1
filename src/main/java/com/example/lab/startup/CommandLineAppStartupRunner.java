package com.example.lab.startup;

import com.example.lab.entity.AuthorEntity;
import com.example.lab.entity.BookEntity;
import com.example.lab.entity.CountryEntity;
import com.example.lab.entity.enums.Category;
import com.example.lab.repository.AuthorRepository;
import com.example.lab.repository.BookRepository;
import com.example.lab.repository.CountryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;
    private final BookRepository bookRepository;

    public CommandLineAppStartupRunner(AuthorRepository authorRepository, CountryRepository countryRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        CountryEntity country1 = new CountryEntity("Macedonia", "Europe");
        CountryEntity country2 = new CountryEntity("Greece", "Europe");

        AuthorEntity author1 = new AuthorEntity("Andrej", "Gerasimovic", country1);
        AuthorEntity author2 = new AuthorEntity("Petko", "Petkovski", country2);

        BookEntity book1 = new BookEntity("Kniga1", Category.HISTORY, author1, 10);
        BookEntity book2 = new BookEntity("Kniga2", Category.THRILER, author2, 15);

        countryRepository.save(country1);
        countryRepository.save(country2);

        authorRepository.save(author1);
        authorRepository.save(author2);

        bookRepository.save(book1);
        bookRepository.save(book2);


    }
}
