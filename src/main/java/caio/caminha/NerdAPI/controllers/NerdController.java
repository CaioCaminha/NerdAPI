package caio.caminha.NerdAPI.controllers;

import caio.caminha.NerdAPI.dtosSW.*;
import caio.caminha.NerdAPI.services.SWClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recurso/")
public class NerdController {
    @Autowired
    private SWClient client;

    @GetMapping("pessoas")
    public OutputAllPeople getPessoas(){
        return this.client.getAllPeople();
    }

    @GetMapping("pessoas/{id}")
    public ResponseEntity<OutputPessoa> getPessoasById(@PathVariable("id") int id){
        return ResponseEntity.ok(new OutputPessoa(this.client.getPeopleById(id)));
    }

    @GetMapping("filmes")
    public OutputAllFilms getAllFilms(){
        return this.client.getAllFilms();
    }

    @GetMapping("filmes/{id}")
    public ResponseEntity<OutputFilme> getFilmeById(@PathVariable("id") int id){
        return ResponseEntity.ok(new OutputFilme(this.client.getFilmById(id)));
    }

    @GetMapping("planetas")
    public OutputAllPlanets getAllPlanets(){
        return this.client.getAllPlanets();
    }

    @GetMapping(path = "planetas/{id}")
    public ResponseEntity<OutputPlaneta> getPlanetaById(@PathVariable("id") int id){
        return ResponseEntity.ok(new OutputPlaneta(this.client.getPlanetsById(id)));
    }
}
