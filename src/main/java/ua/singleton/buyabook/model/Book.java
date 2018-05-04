package ua.singleton.buyabook.model;

import javax.persistence.*;
import java.time.Year;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(name = "published")
    private Year yearPublished;

    private int amount;

    @Lob
    private byte[] icon;

    @ManyToOne
    @JoinColumn(name = "fk_category")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "fk_author")
    private Author author;

    public Book() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Year getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(Year yearPublished) {
        this.yearPublished = yearPublished;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public byte[] getIcon() {
        return icon;
    }

    public void setIcon(byte[] icon) {
        this.icon = icon;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
