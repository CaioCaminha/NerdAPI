package caio.caminha.NerdAPI.service;

import caio.caminha.NerdAPI.dtos.InputUsuario;
import caio.caminha.NerdAPI.dtos.OutputUsuario;
import caio.caminha.NerdAPI.repositories.UsuarioRepository;
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
public class UsuarioServiceTest {
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    @DisplayName(value = "DeveRetornarOutputVeiculo")
    public void createInvalidUsuarioTest() throws Exception{
        InputUsuario input = new InputUsuario("caio", "caio@email.com", "12346578");
        OutputUsuario usuario = this.usuarioService.saveUsuario(input);
        Assert.assertNotNull(usuario.getId());
        Assert.assertEquals(input.getNome(), usuario.getNome());
        this.usuarioRepository.deleteById(usuario.getId());
    }

}
