package caio.caminha.NerdAPI.modelsSW;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OutputFilme {
    private String titulo;
    private Integer episodio_id;
    private String descricao;
    private String diretor;
    private String produtor;
    private Date data_lancamento;
    private List<String> especies;
    private List<String> naves;
    private List<String> veiculos;
    private List<String> planetas;
    private List<String> personagens;
    private String link;
    private String criado;
    private String editado;

    public OutputFilme(OutputFilmeClient outputFilmeClient){
        this.titulo = outputFilmeClient.getTile();
        this.episodio_id = outputFilmeClient.getEpisode_id();
        this.descricao = outputFilmeClient.getOpening_crawl();
        this.diretor = outputFilmeClient.getDirector();
        this.produtor = outputFilmeClient.getProducer();
        this.data_lancamento = outputFilmeClient.getRelease_date();
        this.especies = outputFilmeClient.getSpecies();
        this.naves = outputFilmeClient.getStarships();
        this.veiculos = outputFilmeClient.getVehicles();
        this.planetas = outputFilmeClient.getPlanets();
        this.personagens = outputFilmeClient.getCharacters();
        this.link = outputFilmeClient.getUrl();
        this.criado = outputFilmeClient.getCreated();
        this.editado = outputFilmeClient.getEdited();
    }
}
