package some1less.librarymanagsys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import some1less.librarymanagsys.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> { }
