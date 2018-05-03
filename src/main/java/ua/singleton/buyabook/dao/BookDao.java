package ua.singleton.buyabook.dao;

import ua.singleton.buyabook.model.Book;

import java.util.List;

public interface BookDao {
    Book getBookById(long id);
    List<Book> getAllBooks();
    void addBook(Book book);
    void updateBook(Book book);
    void removeBookById(long id);
}
