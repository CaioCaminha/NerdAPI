package caio.caminha.NerdAPI.services;

import caio.caminha.NerdAPI.modelsSW.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NerdService {

    @Autowired
    private SWClient client;



    public List<OutputFilme> getAllFilms(){
        OutputAllFilms outputAllFilms = this.client.getAllFilms();
        return  outputAllFilms.getResults()
                .stream()
                .map(outputFilmeClient -> new OutputFilme(outputFilmeClient))
                .collect(Collectors.toList());
    }

    public List<OutputPlaneta> getAllPlanets(){
        OutputAllPlanets outputAllPlanets = this.client.getAllPlanets();
        return outputAllPlanets.getResults()
                .stream()
                .map(outputPlanetaClient -> new OutputPlaneta(outputPlanetaClient))
                .collect(Collectors.toList());
    }

    public List<OutputPessoa> getAllPeople(){
        OutputAllPeople outputAllPeople = this.client.getAllPeople();
        return outputAllPeople.getResults()
                .stream()
                .map(outputPessoaClient -> new OutputPessoa(outputPessoaClient))
                .collect(Collectors.toList());
    }



}