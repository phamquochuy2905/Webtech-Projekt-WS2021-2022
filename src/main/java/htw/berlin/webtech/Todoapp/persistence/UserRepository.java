package htw.berlin.webtech.Todoapp.persistence;

import htw.berlin.webtech.Todoapp.api.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    List<UserEntity> findAllByEmail(String email);
}
