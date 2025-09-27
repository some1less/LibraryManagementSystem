package some1less.librarymanagsys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import some1less.librarymanagsys.model.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
}
