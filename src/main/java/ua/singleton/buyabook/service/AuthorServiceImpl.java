package ua.singleton.buyabook.service;

import org.springframework.stereotype.Service;
import ua.singleton.buyabook.dao.AuthorRepo;
import ua.singleton.buyabook.model.Author;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {
    private AuthorRepo authorRepo;

    public AuthorServiceImpl(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    @Override
    public Author getById(Long id) {
        return authorRepo.getById(id);
    }

    @Override
    public List<Author> getAll() {
        return authorRepo.getAll();
    }

    @Override
    public void create(Author author) {
        authorRepo.create(author);
    }

    @Override
    public void update(Long id, Author author) {
        Author authorFromRepo = authorRepo.getById(id);
        authorFromRepo.setFirstName(author.getFirstName());
        authorFromRepo.setLastName(author.getLastName());
        authorRepo.update(authorFromRepo);
    }

    @Override
    public void removeById(Long id) {
        authorRepo.removeById(id);
    }
}
