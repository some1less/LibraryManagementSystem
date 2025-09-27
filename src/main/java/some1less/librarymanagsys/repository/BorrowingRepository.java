package some1less.librarymanagsys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import some1less.librarymanagsys.model.Borrowing;

public interface BorrowingRepository extends JpaRepository<Borrowing, Integer> {
}
