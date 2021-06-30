package caio.caminha.NerdAPI.clientSW;

import lombok.Data;

import java.util.List;

@Data
public class OutputPlanet {
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

    public OutputPlanet(OutputPlanetClient outputPlanetClient){
        this.nome = outputPlanetClient.getName();
        this.diametro = outputPlanetClient.getDiameter();
        this.periodo_rotacao = outputPlanetClient.getRotation_period();
        this.periodo_orbital = outputPlanetClient.getOrbital_period();
        this.gravidade = outputPlanetClient.getGravity();
        this.populacao = outputPlanetClient.getPopulation();
        this.clima = outputPlanetClient.getClimate();
        this.terreno = outputPlanetClient.getTerrain();
        this.superfice_aquatica = outputPlanetClient.getSurface_water();
        this.filmes = outputPlanetClient.getFilms();
        this.residentes = outputPlanetClient.getResidents();
        this.link = outputPlanetClient.getUrl();
        this.criado = outputPlanetClient.getCreated();
        this.editado = outputPlanetClient.getEdited();
    }
}
