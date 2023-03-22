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
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;

    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @PostMapping("/addBook")
    public String addBook(@RequestParam(name = "name") String name,
                          @RequestParam(name = "category") String category,
                          @RequestParam(name = "author") String author,
                          @RequestParam(name = "availableCopies") String availableCopies) throws Exception {
        bookService.saveBook(name, Category.valueOf(category), authorService.findAuthor(Long.parseLong(author)), Integer.parseInt(availableCopies));
        return "redirect:/index";
    }

    @GetMapping("/edit")
    public String getEditPage(@RequestParam(name = "id") String id, Model model) throws Exception {
        model.addAttribute("book", bookService.findBookById(Long.parseLong(id)));
        model.addAttribute("authors", authorService.listAllAuthors());
        model.addAttribute("categories", Category.values());
        return "editBook";
    }

    @PostMapping("/editBook")
    public String editBook(@RequestParam(name = "id") String id,
                           @RequestParam(name = "name") String name,
                           @RequestParam(name = "category") String category,
                           @RequestParam(name = "author") String author,
                           @RequestParam(name = "availableCopies") String availableCopies) throws Exception {
        bookService.editBook(Long.parseLong(id), name, Category.valueOf(category), authorService.findAuthor(Long.parseLong(author)), Integer.parseInt(availableCopies));
        return "redirect:/index";
    }

    @PostMapping("/delete")
    public String deleteBook(@RequestParam(name = "id") String id) throws Exception {
        bookService.deleteBook(Long.parseLong(id));
        return "redirect:/index";
    }

    @PostMapping("/reduceCopy")
    public String reduceCopy(@RequestParam(name = "id") String id) throws Exception {
        bookService.reduceCopy(Long.parseLong(id));
        return "redirect:/index";
    }

}
