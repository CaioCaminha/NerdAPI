package caio.caminha.NerdAPI.controllers;

import caio.caminha.NerdAPI.dtos.InputUsuario;
import caio.caminha.NerdAPI.models.Usuario;
import caio.caminha.NerdAPI.repositories.UsuarioRepository;
import caio.caminha.NerdAPI.repositories.UsuarioRepositoryTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.net.URI;
import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UsuarioControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    @DisplayName(value = "Deve retornar 400 por causa de dados inválidos")
    public void createInvalidUsuario() throws Exception{
        URI uri = new URI("/user");

        InputUsuario input = new InputUsuario(null, null, null);
        String json = new ObjectMapper().writeValueAsString(input);
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(json);
        mvc
                .perform(request)
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName(value = "Deve retornar 200 ao cadastrar usuario")
    public void createUsuario() throws Exception{
        URI uri = new URI("/user");

        InputUsuario input = new InputUsuario("cainho games", "caio@gmail.com", "caminha123");
        String json = new ObjectMapper().writeValueAsString(input);
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(json);
        mvc
                .perform(request)
                .andExpect(status().isCreated())
                .andExpect(jsonPath("id").isNotEmpty());

        Optional<Usuario> usuarioCriado = this.usuarioRepository.findByEmail(input.getEmail());
        this.usuarioRepository.deleteById(usuarioCriado.get().getId());
    }


}
