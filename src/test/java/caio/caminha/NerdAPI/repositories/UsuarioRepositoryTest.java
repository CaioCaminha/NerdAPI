package caio.caminha.NerdAPI.repositories;

import caio.caminha.NerdAPI.models.Usuario;
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
public class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    @DisplayName(value = "DeveRetornarUmOptional<Usuario>")
    public void findUsuarioByCPF(){
        String email = "caminhacaiopro@gmail.com";
        Optional<Usuario> usuario = this.usuarioRepository.findByEmail(email);
        Assert.assertNotNull(usuario.get());
        Assert.assertEquals(email, usuario.get().getEmail());
        Assert.assertTrue(usuario.isPresent());
    }

}
