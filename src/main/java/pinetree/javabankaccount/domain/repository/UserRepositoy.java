package pinetree.javabankaccount.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pinetree.javabankaccount.domain.model.User;

import java.util.UUID;

@Repository
public interface UserRepositoy extends JpaRepository<User, UUID> {
}
