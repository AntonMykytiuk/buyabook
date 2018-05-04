package ua.singleton.buyabook.service;

import org.springframework.stereotype.Service;
import ua.singleton.buyabook.dao.BookRepo;
import ua.singleton.buyabook.model.Book;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {
    private BookRepo bookRepo;

    public BookServiceImpl(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public Book getById(Long id) {
        return bookRepo.getById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookRepo.getAll();
    }

    @Override
    public void create(Book book) {
        bookRepo.create(book);
    }

    @Override
    public void update(Long id, Book book) {
        Book bookFromRepo = bookRepo.getById(id);
        bookFromRepo.setTitle(book.getTitle());
        bookFromRepo.setAmount(book.getAmount());
        bookFromRepo.setAuthor(book.getAuthor());
        bookFromRepo.setCategory(book.getCategory());
        bookFromRepo.setYearPublished(book.getYearPublished());
        bookFromRepo.setIcon(book.getIcon());
        bookRepo.update(book);
    }

    @Override
    public void removeById(Long id) {
        bookRepo.removeById(id);
    }
}
