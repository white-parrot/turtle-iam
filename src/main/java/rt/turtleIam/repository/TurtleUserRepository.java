package rt.turtleIam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rt.turtleIam.entity.TurtleUser;

import java.util.Optional;

@Repository
public interface TurtleUserRepository extends JpaRepository<TurtleUser, Long> {
    Optional<TurtleUser> findUserByEmail(String email);
}
