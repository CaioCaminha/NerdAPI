package caio.caminha.NerdAPI.repositories;

import caio.caminha.NerdAPI.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName(value = "DeveRetornarUmOptional<Usuario>")
    public void findUsuarioByCPF(){
        String email = "caminhacaiopro@gmail.com";
        Optional<User> user = this.userRepository.findByEmail(email);
        Assert.assertNotNull(user.get());
        Assert.assertEquals(email, user.get().getEmail());
        Assert.assertTrue(user.isPresent());
    }

}
