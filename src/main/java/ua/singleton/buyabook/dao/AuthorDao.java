package ua.singleton.buyabook.dao;

import ua.singleton.buyabook.model.Author;

import java.util.List;

public interface AuthorDao {
    Author getAuthorById(long id);
    List<Author> getAllAuthors();
    void addAuthor(Author author);
    void updateAuthor(Author author);
    void removeAuthorById(long id);
}
