package caio.caminha.NerdAPI.services;

import caio.caminha.NerdAPI.modelsSW.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "https://swapi.dev/api/", name = "sw")
public interface SWClient {

    @GetMapping("people/{id}/?format=json")
    OutputPessoaClient getPeopleById(@PathVariable("id") int id);

    @GetMapping("people/?format=json")
    OutputAllPeopleClient getAllPeople();

    @GetMapping("films")
    OutputAllFilmsClient getAllFilms();

    @GetMapping("films/{id}")
    OutputFilmeClient getFilmById(@PathVariable("id") int id);

    @GetMapping("planets")
    OutputAllPlanetsClient getAllPlanets();

    @GetMapping("planets/{id}")
    OutputPlanetaClient getPlanetsById(@PathVariable("id") int id);

}
