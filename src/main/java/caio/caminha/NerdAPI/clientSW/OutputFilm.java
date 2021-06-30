package caio.caminha.NerdAPI.clientSW;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OutputFilm {
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

    public OutputFilm(OutputFilmClient outputFilmClient){
        this.titulo = outputFilmClient.getTile();
        this.episodio_id = outputFilmClient.getEpisode_id();
        this.descricao = outputFilmClient.getOpening_crawl();
        this.diretor = outputFilmClient.getDirector();
        this.produtor = outputFilmClient.getProducer();
        this.data_lancamento = outputFilmClient.getRelease_date();
        this.especies = outputFilmClient.getSpecies();
        this.naves = outputFilmClient.getStarships();
        this.veiculos = outputFilmClient.getVehicles();
        this.planetas = outputFilmClient.getPlanets();
        this.personagens = outputFilmClient.getCharacters();
        this.link = outputFilmClient.getUrl();
        this.criado = outputFilmClient.getCreated();
        this.editado = outputFilmClient.getEdited();
    }
}
