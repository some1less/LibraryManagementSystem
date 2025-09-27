package some1less.librarymanagsys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import some1less.librarymanagsys.model.Copy;

public interface CopyRepository extends JpaRepository<Copy, Integer> {
}
