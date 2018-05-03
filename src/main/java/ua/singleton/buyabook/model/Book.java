package ua.singleton.buyabook.model;

import javax.persistence.*;
import java.time.Year;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

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
}
