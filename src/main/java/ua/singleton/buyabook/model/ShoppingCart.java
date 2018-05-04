package ua.singleton.buyabook.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Book> chosenBooks = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Book> getChosenBooks() {
        return chosenBooks;
    }

    public void setChosenBooks(List<Book> chosenBooks) {
        this.chosenBooks = chosenBooks;
    }
}
