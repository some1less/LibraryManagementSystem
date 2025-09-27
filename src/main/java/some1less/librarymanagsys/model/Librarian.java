package some1less.librarymanagsys.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Librarian")
public class Librarian {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_Id", nullable = false, unique = true)
    private User user;

    @Column(name = "employment_date", nullable = false)
    private LocalDate employmentDate;

    @Column(nullable = false)
    private String position;

    public Librarian() {}

    public Librarian(User user, LocalDate employmentDate, String position) {
        this.user = user;
        this.employmentDate = employmentDate;
        this.position = position;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(LocalDate employmentDate) {
        this.employmentDate = employmentDate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
