package ua.singleton.buyabook.model;

import javax.persistence.*;
import java.time.Year;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private Year yearPublished;
    @Lob
    private byte[] icon;
    private List<String> authors;

}
