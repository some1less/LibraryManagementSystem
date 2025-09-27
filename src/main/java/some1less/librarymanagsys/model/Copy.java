package some1less.librarymanagsys.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Copy")
public class Copy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Column(name = "copy_number", nullable = false)
    private int copyNumber;

    @Column(name = "status", nullable = false)
    private String status;

    @OneToMany(mappedBy = "copy", cascade = {CascadeType.PERSIST, CascadeType.MERGE},
                            orphanRemoval = true)
    private List<Borrowing> borrowings = new ArrayList<Borrowing>();

    public Copy() {}

    public Copy(Book book, int copyNumber, String status) {
        this.book = book;
        this.copyNumber = copyNumber;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getCopyNumber() {
        return copyNumber;
    }

    public void setCopyNumber(int copyNumber) {
        this.copyNumber = copyNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
