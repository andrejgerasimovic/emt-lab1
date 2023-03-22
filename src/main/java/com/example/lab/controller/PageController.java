package com.example.lab.controller;

import com.example.lab.entity.enums.Category;
import com.example.lab.service.AuthorService;
import com.example.lab.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {

    private final AuthorService authorService;
    private final BookService bookService;

    public PageController(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @GetMapping("/index")
    public String getIndexPage(Model model) {
        model.addAttribute("books", bookService.listAllBooks());
        return "index";
    }

    @GetMapping("/addBook")
    public String getAddBookPage(Model model) {
        model.addAttribute("authors", authorService.listAllAuthors());
        model.addAttribute("categories", Category.values());
        return "addBook";
    }

}
