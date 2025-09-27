package some1less.librarymanagsys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import some1less.librarymanagsys.model.Librarian;

public interface LibrarianRepository extends JpaRepository<Librarian, Integer> {
}
