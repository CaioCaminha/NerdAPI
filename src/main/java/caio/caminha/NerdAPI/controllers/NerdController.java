package caio.caminha.NerdAPI.controllers;

import caio.caminha.NerdAPI.modelsSW.*;
import caio.caminha.NerdAPI.services.NerdService;
import caio.caminha.NerdAPI.services.SWClient;
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
    public List<OutputPessoa> getPessoas(){
        return this.nerdService.getAllPeople();
    }

    @GetMapping("pessoas/{id}")
    public ResponseEntity<OutputPessoa> getPessoasById(@PathVariable("id") int id){
        return ResponseEntity.ok(new OutputPessoa(this.client.getPeopleById(id)));
    }

    @GetMapping("filmes")
    public List<OutputFilme> getAllFilms(){
        return  this.nerdService.getAllFilms();
    }

    @GetMapping("filmes/{id}")
    public ResponseEntity<OutputFilme> getFilmeById(@PathVariable("id") int id){
        return ResponseEntity.ok(new OutputFilme(this.client.getFilmById(id)));
    }

    @GetMapping("planetas")
    public List<OutputPlaneta> getAllPlanets(){
        return this.nerdService.getAllPlanets();
    }

    @GetMapping(path = "planetas/{id}")
    public ResponseEntity<OutputPlaneta> getPlanetaById(@PathVariable("id") int id){
        return ResponseEntity.ok(new OutputPlaneta(this.client.getPlanetsById(id)));
    }
}
