package caio.caminha.NerdAPI.service;

import caio.caminha.NerdAPI.dtos.InputUser;
import caio.caminha.NerdAPI.dtos.OutputUser;
import caio.caminha.NerdAPI.repositories.UserRepository;
import caio.caminha.NerdAPI.services.UsuarioService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserServiceTest {
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName(value = "DeveRetornarOutputVeiculo")
    public void createInvalidUsuarioTest() throws Exception{
        InputUser input = new InputUser("caio", "caio@email.com", "12346578");
        OutputUser user = this.usuarioService.saveUser(input);
        Assert.assertNotNull(user.getId());
        Assert.assertEquals(input.getNome(), user.getNome());
        this.userRepository.deleteById(user.getId());
    }

}
