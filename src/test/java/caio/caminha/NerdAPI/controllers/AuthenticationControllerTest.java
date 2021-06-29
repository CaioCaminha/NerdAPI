package caio.caminha.NerdAPI.controllers;

import caio.caminha.NerdAPI.dtos.InputAuth;
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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AuthenticationControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName(value = "DeveRetornar200")
    public void authenticationTest() throws Exception{
        URI uri = new URI("/auth");

        InputAuth input = new InputAuth("caminhacaiopro@gmail.com", "caminha123");
        String json = new ObjectMapper().writeValueAsString(input);
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(json);

        mvc
                .perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("token").isNotEmpty());

    }

    @Test
    @DisplayName(value = "DeveRetornar400")
    public void InvalidAuthenticationTest() throws Exception{
        URI uri = new URI("/auth");

        InputAuth input = new InputAuth("null", "caminha123");
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
}
