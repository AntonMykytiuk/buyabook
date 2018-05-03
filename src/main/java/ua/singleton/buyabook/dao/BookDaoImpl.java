package ua.singleton.buyabook.dao;

import org.springframework.stereotype.Repository;
import ua.singleton.buyabook.model.Book;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {
    @Override
    public Book getBookById(long id) {
        return null;
    }

    @Override
    public List<Book> getAllBooks() {
        return null;
    }

    @Override
    public void addBook(Book book) {

    }

    @Override
    public void updateBook(Book book) {

    }

    @Override
    public void removeBookById(long id) {

    }
}
