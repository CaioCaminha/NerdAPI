package caio.caminha.NerdAPI.services;

import caio.caminha.NerdAPI.clientSW.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NerdService {

    @Autowired
    private SWClient client;

    public List<OutputFilm> getAllFilms(){
        OutputAllFilmsClient outputAllFilms = this.client.getAllFilms();
        return  outputAllFilms.getResults()
                .stream()
                .map(outputFilmeClient -> new OutputFilm(outputFilmeClient))
                .collect(Collectors.toList());
    }

    public List<OutputPlanet> getAllPlanets(){
        OutputAllPlanetsClient outputAllPlanets = this.client.getAllPlanets();
        return outputAllPlanets.getResults()
                .stream()
                .map(outputPlanetaClient -> new OutputPlanet(outputPlanetaClient))
                .collect(Collectors.toList());
    }

    public List<OutputPeople> getAllPeople(){
        OutputAllPeopleClient outputAllPeople = this.client.getAllPeople();
        return outputAllPeople.getResults()
                .stream()
                .map(outputPessoaClient -> new OutputPeople(outputPessoaClient))
                .collect(Collectors.toList());
    }



}
