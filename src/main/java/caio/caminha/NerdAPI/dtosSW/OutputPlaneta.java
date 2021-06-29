package caio.caminha.NerdAPI.dtosSW;

import lombok.Data;

import java.util.List;

@Data
public class OutputPlaneta {
    private String nome;
    private String diametro;
    private String periodo_rotacao;
    private String periodo_orbital;
    private String gravidade;
    private String populacao;
    private String clima;
    private String terreno;
    private String superfice_aquatica;
    private List<String> residentes;
    private List<String> filmes;
    private String link;
    private String criado;
    private String editado;

    public OutputPlaneta(OutputPlanetaClient outputPlanetaClient){
        this.nome = outputPlanetaClient.getName();
        this.diametro = outputPlanetaClient.getDiameter();
        this.periodo_rotacao = outputPlanetaClient.getRotation_period();
        this.periodo_orbital = outputPlanetaClient.getOrbital_period();
        this.gravidade = outputPlanetaClient.getGravity();
        this.populacao = outputPlanetaClient.getPopulation();
        this.clima = outputPlanetaClient.getClimate();
        this.terreno = outputPlanetaClient.getTerrain();
        this.superfice_aquatica = outputPlanetaClient.getSurface_water();
        this.filmes = outputPlanetaClient.getFilms();
        this.residentes = outputPlanetaClient.getResidents();
        this.link = outputPlanetaClient.getUrl();
        this.criado = outputPlanetaClient.getCreated();
        this.editado = outputPlanetaClient.getEdited();
    }
}
