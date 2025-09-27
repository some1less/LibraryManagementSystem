package some1less.librarymanagsys.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;


    @Column(name = "name", nullable = false, length = 50)
    @Size(max=50)
    private String name;


    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",
            flags = Pattern.Flag.CASE_INSENSITIVE)

    @Column(name = "email", nullable = false, unique=true, length = 50)
    @Size(max=50)
    private String email;

    // todo phoneNumber validation including localization
    @Column(name = "phone_number", nullable = false, length = 50)
    private String phoneNumber;

    @Column(name = "address", nullable = false, length = 50)
    private String address;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private List<Borrowing> borrowings = new ArrayList<Borrowing>();

    @OneToOne(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private Librarian librarian;

    public User(){}
    public User(String name, String email, String phoneNumber, String address){
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + this.id +
                ", name='" + this.name + '\'' +
                ", email='" + this.email + '\'' +
                ", phoneNumber='" + this.phoneNumber + '\'' +
                ", address='" + this.address + '\'' +
                '}';
    }
}
