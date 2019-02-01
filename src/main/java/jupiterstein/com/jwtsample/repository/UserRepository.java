package jupiterstein.com.jwtsample.repository;

import jupiterstein.com.jwtsample.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    User findByEmail(String username);
}
