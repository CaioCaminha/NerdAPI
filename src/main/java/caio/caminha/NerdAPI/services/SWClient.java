package caio.caminha.NerdAPI.services;

import caio.caminha.NerdAPI.dtosSW.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@FeignClient(url = "https://swapi.dev/api/", name = "sw")
public interface SWClient {

    @GetMapping("people/{id}/?format=json")
    OutputPessoaClient getPeopleById(@PathVariable("id") int id);

    @GetMapping("people/?format=json")
    OutputAllPeople getAllPeople();

    @GetMapping("films")
    OutputAllFilms getAllFilms();

    @GetMapping("films/{id}")
    OutputFilmeClient getFilmById(@PathVariable("id") int id);

    @GetMapping("planets")
    OutputAllPlanets getAllPlanets();

    @GetMapping("planets/{id}")
    OutputPlanetaClient getPlanetsById(@PathVariable("id") int id);

}
