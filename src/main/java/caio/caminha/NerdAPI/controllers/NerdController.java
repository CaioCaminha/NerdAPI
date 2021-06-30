package caio.caminha.NerdAPI.controllers;

import caio.caminha.NerdAPI.clientSW.*;
import caio.caminha.NerdAPI.services.NerdService;
import caio.caminha.NerdAPI.clientSW.SWClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/recurso/")
public class NerdController {
    @Autowired
    private SWClient client;

    @Autowired
    private NerdService nerdService;

    @GetMapping("pessoas")
    public List<OutputPeople> getPessoas(){
        return this.nerdService.getAllPeople();
    }

    @GetMapping("pessoas/{id}")
    public ResponseEntity<OutputPeople> getPessoasById(@PathVariable("id") int id){
        return ResponseEntity.ok(new OutputPeople(this.client.getPeopleById(id)));
    }

    @GetMapping("filmes")
    public List<OutputFilm> getAllFilms(){
        return  this.nerdService.getAllFilms();
    }

    @GetMapping("filmes/{id}")
    public ResponseEntity<OutputFilm> getFilmeById(@PathVariable("id") int id){
        return ResponseEntity.ok(new OutputFilm(this.client.getFilmById(id)));
    }

    @GetMapping("planetas")
    public List<OutputPlanet> getAllPlanets(){
        return this.nerdService.getAllPlanets();
    }

    @GetMapping(path = "planetas/{id}")
    public ResponseEntity<OutputPlanet> getPlanetaById(@PathVariable("id") int id){
        return ResponseEntity.ok(new OutputPlanet(this.client.getPlanetsById(id)));
    }
}
