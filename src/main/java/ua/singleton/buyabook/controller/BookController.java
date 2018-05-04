package ua.singleton.buyabook.controller;

import org.springframework.web.bind.annotation.*;
import ua.singleton.buyabook.model.Book;
import ua.singleton.buyabook.service.BookService;

import java.util.List;

@RestController
@RequestMapping("rest/api/books")
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAll();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getById(id);
    }

    @PostMapping
    public void createBook(@RequestBody Book book) {
        bookService.create(book);
    }

    @PutMapping("/{id}")
    public void updateBook(@PathVariable Long id, @RequestBody Book book) {
        bookService.update(id, book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.removeById(id);
    }
}
