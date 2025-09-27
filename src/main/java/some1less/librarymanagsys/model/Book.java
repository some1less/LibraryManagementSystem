package some1less.librarymanagsys.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "BOOK")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "title", nullable = false)
    @Size(max = 255)
    private String title;

    @Column(name = "author", nullable = false)
    @Size(max = 255)
    private String author;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "publisher_Id", nullable = false)
    private Publisher publisher;

    @Column(name = "publication_Year", nullable = false)
    private int publicationYear;

    @Column(name = "isbn", nullable = false, unique = true)
    @Size(max = 255)
    private String isbn;

    @OneToMany(mappedBy = "book",
                cascade = {CascadeType.PERSIST, CascadeType.MERGE},
                orphanRemoval = true)
    private List<Copy> copies = new ArrayList<>();

    public Book() {}

    public Book(String title, String author, Publisher publisher, int publicationYear, String isbn) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
