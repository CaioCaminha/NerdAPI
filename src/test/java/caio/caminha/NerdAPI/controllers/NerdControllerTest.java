package caio.caminha.NerdAPI.controllers;

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

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class NerdControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName(value = "DeveRetornar200")
    public void allPlanetsTest() throws Exception{
        URI uri = new URI("/recurso/planetas");

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        mvc
                .perform(request)
                .andExpect(status().isForbidden());
    }

    @Test
    @DisplayName(value = "DeveRetornar200")
    public void onePlanetTest() throws Exception{
        URI uri = new URI("/recurso/planetas/1");

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        mvc
                .perform(request)
                .andExpect(status().isForbidden());
    }

    @Test
    @DisplayName(value = "DeveRetornar200")
    public void allFilmsTest() throws Exception{
        URI uri = new URI("/recurso/filmes");

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        mvc
                .perform(request)
                .andExpect(status().isForbidden());
    }

    @Test
    @DisplayName(value = "DeveRetornar200")
    public void oneFilmTest() throws Exception{
        URI uri = new URI("/recurso/filmes/1");

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        mvc
                .perform(request)
                .andExpect(status().isForbidden());
    }

    @Test
    @DisplayName(value = "DeveRetornar200")
    public void allPeopeTest() throws Exception{
        URI uri = new URI("/recurso/pessoas");

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        mvc
                .perform(request)
                .andExpect(status().isForbidden());
    }

    @Test
    @DisplayName(value = "DeveRetornar200")
    public void onePeopleTest() throws Exception{
        URI uri = new URI("/recurso/pessoas/1");

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        mvc
                .perform(request)
                .andExpect(status().isForbidden());
    }
}
