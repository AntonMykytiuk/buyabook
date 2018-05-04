package ua.singleton.buyabook.controller;

import org.springframework.web.bind.annotation.*;
import ua.singleton.buyabook.model.Author;
import ua.singleton.buyabook.service.AuthorService;

import java.util.List;

@RestController
@RequestMapping("rest/api/authors")
public class AuthorController {
    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> getAllAuthors() {
        return authorService.getAll();
    }

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable Long id) {
        return authorService.getById(id);
    }

    @PostMapping
    public void createAuthor(@RequestBody Author author) {
        authorService.create(author);
    }

    @PutMapping("{id}")
    public void updateAuthor(@PathVariable Long id, @RequestBody Author author) {
        authorService.update(id, author);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable Long id) {
        authorService.removeById(id);
    }
}
