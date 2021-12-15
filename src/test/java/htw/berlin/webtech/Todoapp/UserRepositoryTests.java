package htw.berlin.webtech.Todoapp;

import htw.berlin.webtech.Todoapp.persistence.User;
import htw.berlin.webtech.Todoapp.persistence.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private UserRepository repo;

    @Test
    public void canCreateUser() {
        User newUser = new User();
        newUser.setFirstname("Quoc Huy");
        newUser.setLastname("Pham");
        newUser.setEmail("phamquochuy2905@gmail.com");
        newUser.setPassword("huy29051997");

        User savedUser = repo.save(newUser);
        User existUser = entityManager.find(User.class, savedUser.getId());

        assertThat(newUser.getEmail()).isEqualTo(existUser.getEmail());
    }
}
