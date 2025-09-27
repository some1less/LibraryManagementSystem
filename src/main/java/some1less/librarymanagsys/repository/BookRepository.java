package some1less.librarymanagsys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import some1less.librarymanagsys.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
